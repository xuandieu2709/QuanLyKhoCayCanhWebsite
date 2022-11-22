package com.treemanage.Entity;

import java.awt.Color;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import com.treemanage.Controller.Common;
import com.treemanage.DTO.BaoCaoDTO;

public class ExportPDF extends Common {
    private List<CTBaoCao> ctBaoCaos;
    private List<CayCanh> cayCanhs;
    private BaoCaoDTO baoCaoDTO;

    public ExportPDF(List<CTBaoCao> ctBaoCaos) {
        this.ctBaoCaos = ctBaoCaos;
    }

    public ExportPDF(BaoCaoDTO baoCaoDTO) {
        this.baoCaoDTO = baoCaoDTO;
    }

    public ExportPDF(List<CayCanh> cayCanhs, String x) {
        this.cayCanhs = cayCanhs;
    }

    /* CHuan */
    private void writeTableHeaderReport(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.yellow);
        cell.setPadding(6);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        // font.setFamily("Times New Roman");
        font.setColor(Color.WHITE);
        FontFactory.registerDirectories();

        font = FontFactory.getFont("Times New Roman");
        // cell.setPhrase(new Phrase("Mã chi tiết", font));

        // table.addCell(cell);

        cell.setPhrase(new Phrase("Nội dung báo cáo", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Tên cây", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Số lượng", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Giá Bán", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Thành tiền", font));
        table.addCell(cell);
    }

    private void writeTableDataReport(PdfPTable table) {

        Locale locale = new Locale("vn", "VN");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.WHITE);
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        // font.setFamily("Times New Roman");
        int countSL = 0;
        double countTT = 0;
        font.setColor(Color.WHITE);
        FontFactory.registerDirectories();
        font = FontFactory.getFont("Times New Roman");
        for (CTBaoCao ct : baoCaoDTO.getCtbaocaos()) {
            for (CayCanh cay : baoCaoDTO.getCaycanhs()) {
                if (cay.getMacay() == ct.getMacay()) {
                    // cell.setPhrase(new Phrase(String.valueOf(ct.getMachitiet()), font));
                    // table.addCell(cell);
                    cell.setPhrase(new Phrase(String.valueOf(baoCaoDTO.getBaocao().getNoidung()), font));
                    table.addCell(cell);
                    cell.setPhrase(new Phrase(String.valueOf(cay.getTencay()), font));
                    table.addCell(cell);
                    cell.setPhrase(new Phrase(String.valueOf(ct.getSoluong()), font));
                    table.addCell(cell);
                    cell.setPhrase(new Phrase(String.valueOf(currencyFormatter.format((long) ct.getGia())), font));
                    table.addCell(cell);
                    cell.setPhrase(
                            new Phrase(String.valueOf(currencyFormatter.format((long) ct.getThanhtien())), font));
                    table.addCell(cell);
                    countSL += ct.getSoluong();
                    countTT += ct.getThanhtien();
                }
            }
        }
        cell.setPhrase(new Phrase("Tổng cộng", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase(String.valueOf(countSL), font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase(String.valueOf(currencyFormatter.format(countTT)), font));
        table.addCell(cell);

    }

    public void exportReport(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        FontFactory.registerDirectories();
        font = FontFactory.getFont("Times New Roman");
        font.setSize(18);
        font.setColor(Color.BLACK);

        Paragraph p = new Paragraph("Báo Cáo Thống kê", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(p);
        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {5f, 5f, 2.0f, 3.0f, 3.0f });
        table.setSpacingBefore(10);
        writeTableHeaderReport(table);
        writeTableDataReport(table);
        document.add(table);
        document.close();

    }
    /* End */

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(6);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        // font.setFamily("Times New Roman");
        font.setColor(Color.WHITE);
        FontFactory.registerDirectories();

        font = FontFactory.getFont("Times New Roman");
        cell.setPhrase(new Phrase("Mã chi tiết", font));

        table.addCell(cell);

        cell.setPhrase(new Phrase("Mã báo cáo", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Mã cây", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("So Luong", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Gia", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Thanh Tien", font));
        table.addCell(cell);
    }

    private void writeTableHeaderInventory(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.YELLOW);
        cell.setPadding(6);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("Tên cây cảnh", font));

        table.addCell(cell);

        cell.setPhrase(new Phrase("Tồn kho", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Giá bán", font));
        table.addCell(cell);
    }

    private void writeTableData(PdfPTable table) {
        for (CTBaoCao ct : ctBaoCaos) {
            table.addCell(String.valueOf(ct.getMachitiet()));
            table.addCell(String.valueOf(ct.getMaphieu()));
            table.addCell(String.valueOf(ct.getMacay()));
            table.addCell(String.valueOf(ct.getSoluong()));
            table.addCell(String.valueOf((long) ct.getGia()));
            table.addCell(String.valueOf((long) ct.getThanhtien()));
        }
    }

    private void writeTableDataInventory(PdfPTable table) {
        for (CayCanh cay : cayCanhs) {
            table.addCell(cay.getTencay());
            table.addCell(String.valueOf(cay.getTonkho()));
            table.addCell(String.valueOf(cay.getGiacay()));
        }
    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        FontFactory.registerDirectories();

        font = FontFactory.getFont("Times New Roman");
        // font.setFamily("Times New Roman");
        font.setSize(18);
        font.setColor(Color.GREEN);
        //
        Paragraph p = new Paragraph("BÁO CÁO THỐNG KÊ", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(p);
        PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] { 1.5f, 1.5f, 1.5f, 2.0f, 4.0f, 4.0f });
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);

        document.close();

    }

    public void exportInventory(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.GREEN);

        Paragraph p = new Paragraph("THỐNG KÊ HÀNG TỒN", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(p);
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] { 5f, 3.5f, 6F });
        table.setSpacingBefore(10);

        writeTableHeaderInventory(table);
        writeTableDataInventory(table);

        document.add(table);

        document.close();

    }
}
