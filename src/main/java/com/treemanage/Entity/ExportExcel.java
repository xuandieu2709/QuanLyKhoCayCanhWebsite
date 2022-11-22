package com.treemanage.Entity;

import java.io.IOException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.treemanage.DTO.BaoCaoDTO;

public class ExportExcel {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    // private List<ChiTietPhieuXuat> listctphieuxuat;
    private BaoCaoDTO baoCaoDTO;

    public ExportExcel(XSSFWorkbook workbook, XSSFSheet sheet, BaoCaoDTO baoCaoDTO) {
        this.workbook = workbook;
        this.sheet = sheet;
        this.baoCaoDTO = baoCaoDTO;
    }

    public ExportExcel(BaoCaoDTO baoCaoDTO) {
        this.baoCaoDTO = baoCaoDTO;
        workbook = new XSSFWorkbook();
    }

    public ExportExcel() {
    }

    public XSSFWorkbook getWorkbook() {
        return this.workbook;
    }

    public void setWorkbook(XSSFWorkbook workbook) {
        this.workbook = workbook;
    }

    public XSSFSheet getSheet() {
        return this.sheet;
    }

    public void setSheet(XSSFSheet sheet) {
        this.sheet = sheet;
    }

    public BaoCaoDTO getBaoCaoDTO() {
        return this.baoCaoDTO;
    }

    public void setBaoCaoDTO(BaoCaoDTO baoCaoDTO) {
        this.baoCaoDTO = baoCaoDTO;
    }

    private void writeHeaderLine() {
        sheet = workbook.createSheet("Thống kê báo cáo");

        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontName("Times New Roman");
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "Mã Chi Tiết", style);
        createCell(row, 1, "Mã Báo Cáo", style);
        createCell(row, 2, "Mã cây", style);
        createCell(row, 3, "Số lượng", style);
        createCell(row, 4, "Giá bán", style);
        createCell(row, 5, "Thành tiền", style);

    }

    private void writeHeaderLineBaoCao() {
        sheet = workbook.createSheet("Thống kê báo cáo");

        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontName("Times New Roman");
        font.setFontHeight(16);
        style.setFont(font);

        // createCell(row, 0, "Mã Chi Tiết", style);
        createCell(row, 0, "Nội Dung Báo Cáo", style);
        createCell(row, 1, "Tên cây", style);
        createCell(row, 2, "Số lượng", style);
        createCell(row, 3, "Giá bán", style);
        createCell(row, 4, "Thành tiền", style);

    }

    private void writeDataLinesBaoCao() {

        Locale locale = new Locale("vn", "VN");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontName("Times New Roman");
        font.setFontHeight(14);
        style.setFont(font);
        int count = 0;
        int countSum = 0;
        double countTT = 0;
        for (CTBaoCao ct : baoCaoDTO.getCtbaocaos()) {
            for (CayCanh cay : baoCaoDTO.getCaycanhs()) {
                if (ct.getMacay() == cay.getMacay()) {
                    Row row = sheet.createRow(rowCount++);
                    int columnCount = 0;
                    // createCell(row, columnCount++, ct.getMachitiet(), style); // mactbaocao
                    createCell(row, columnCount++, baoCaoDTO.getBaocao().getNoidung(), style); // Mabaocao
                    createCell(row, columnCount++, cay.getTencay(), style);
                    createCell(row, columnCount++, ct.getSoluong(), style);
                    createCell(row, columnCount++, String.valueOf(currencyFormatter.format((long) ct.getGia())), style);
                    createCell(row, columnCount++, String.valueOf(currencyFormatter.format((long) ct.getThanhtien())),
                            style);
                    count++;
                    countSum += ct.getSoluong();
                    countTT += ct.getThanhtien();
                }
            }

        }
        Row row = sheet.createRow(rowCount++);
        row = sheet.createRow(rowCount++);
        createCell(row, 0, "Tổng cộng", style);
        createCell(row, 2, countSum, style);
        createCell(row, 4, String.valueOf(currencyFormatter.format((long) countTT)), style);
    }

    public void exportReport(HttpServletResponse response) throws IOException {
        writeHeaderLineBaoCao();
        writeDataLinesBaoCao();
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

    }

    private void writeHeaderLineCayCanh() {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        sheet = workbook.createSheet("Thống kê hàng tồn_" + currentDateTime);

        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontName("Times New Roman");
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        createCell(row, 0, "Tên cây cảnh", style);
        createCell(row, 1, "Giá cây", style);
        createCell(row, 2, "Tồn kho", style);

    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else if (value instanceof Double) {
            cell.setCellValue((Double) value);
        } else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    private void writeDataLines() {
        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontName("Times New Roman");
        font.setFontHeight(14);
        style.setFont(font);

        // for (CTBaoCao ct : ctBaoCaos) {
        // for(CayCanh cay: caycanhs)
        // Row row = sheet.createRow(rowCount++);
        // int columnCount = 0;
        // createCell(row, columnCount++, ct.getMachitiet(), style); // mactbaocao
        // createCell(row, columnCount++, ct.getMaphieu(), style); // Mabaocao
        // createCell(row, columnCount++, ct.getMacay(), style);
        // createCell(row, columnCount++, ct.getSoluong(), style);
        // createCell(row, columnCount++, String.valueOf((long) ct.getGia()), style);
        // createCell(row, columnCount++, String.valueOf((long) ct.getThanhtien()),
        // style);
        // }
    }

    private void writeDataLinesCayCanh() {
        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        // font = sheet.getWorkbook().createFont();
        font.setFontName("Times New Roman");
        font.setFontHeight(14);
        style.setFont(font);

        // for (CayCanh cay : listcaycanh) {
        // Row row = sheet.createRow(rowCount++);
        // int columnCount = 0;
        // createCell(row, columnCount++, cay.getTencay(), style);
        // createCell(row, columnCount++, cay.getGiacay(), style);
        // createCell(row, columnCount++, String.valueOf(cay.getTonkho()), style);
        // }
    }

    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();

        outputStream.close();

    }

    public void exportInventory(HttpServletResponse response) throws IOException {
        writeHeaderLineCayCanh();
        writeDataLinesCayCanh();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();

        outputStream.close();

    }
}
