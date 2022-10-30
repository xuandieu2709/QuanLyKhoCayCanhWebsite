package com.treemanage.Controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.lowagie.text.DocumentException;
import com.treemanage.DTO.BaoCaoDTO;
import com.treemanage.Entity.BaoCao;
import com.treemanage.Entity.CTBaoCao;
import com.treemanage.Entity.CayCanh;
import com.treemanage.Entity.ExportExcel;
import com.treemanage.Entity.ExportPDF;

@Controller
public class ExportDataController extends Common {
    @GetMapping("/export/excel/inventory")
    public void exportToExcel(HttpServletResponse response,int id) throws IOException {
        response.setContentType("application/octet-stream");
        response.setCharacterEncoding("UTF-8");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        BaoCao bc = baoCaoService.findRPByID(id);
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename="+(String)bc.getNoidung()+"_TimeExportFile_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
        BaoCao baocao = baoCaoService.findRPByID(id);
        List<CTBaoCao> listCT = ctBaoCaoService.showListByIDReport(id);
        List<CayCanh> listcay = cayCanhService.findAll();
        BaoCaoDTO dto = new BaoCaoDTO(listCT,baocao,listcay);
        ExportExcel excelExporter = new ExportExcel(dto);
        excelExporter.exportReport(response);
    }

    @GetMapping("/export/excels/inventory")
    public void exportToExcelInventory(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        response.setCharacterEncoding("UTF-8");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=ThongKeHangTon_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
        List<CayCanh> listcay = cayCanhService.showList();
        String x = "";
        // ExportExcel excelExporter = new ExportExcel(listcay,x);
        // excelExporter.exportInventory(response);
    }

    @GetMapping("/export/pdf/inventory")
    public void exportToPDF(HttpServletResponse response,int id) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        response.setCharacterEncoding("UTF-8");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        BaoCao bc = baoCaoService.findRPByID(id);
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename="+(String)bc.getNoidung()+"_TimeExportFile_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
        BaoCao baocao = baoCaoService.findRPByID(id);
        List<CTBaoCao> listCT = ctBaoCaoService.showListByIDReport(id);
        List<CayCanh> listcay = cayCanhService.findAll();
        BaoCaoDTO dto = new BaoCaoDTO(listCT,baocao,listcay);
        ExportPDF exportPDF = new ExportPDF(dto);
        exportPDF.exportReport(response);

    }

    @GetMapping("/export/pdf/inventoryCC")
    public void exportInventoryToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        response.setCharacterEncoding("UTF-8");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Thongkehangton_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
        List<CayCanh> listcay = cayCanhService.showList();
        ExportPDF exportPDF = new ExportPDF(listcay,"");
        exportPDF.exportInventory(response);
    }
}
