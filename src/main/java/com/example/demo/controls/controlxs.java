package com.example.demo.controls;
import com.example.demo.Tools;
import com.example.demo.entity.Xs;
import com.example.demo.entity.Xs_driver;
import com.example.demo.service.XsService;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class controlxs {
    @Autowired
    XsService xsService;
    @GetMapping("/excelDownloads")
    public  void OutToExcel(@RequestParam("month")Integer month,HttpServletResponse response) throws IOException {
        System.out.println("进入后端_车队");

        HSSFWorkbook workbook = new HSSFWorkbook();//创建HSSFWorkbook对象,  excel的文档对象
        HSSFSheet sheet = workbook.createSheet("车队出车统计表"); //excel的表单

        List<Xs> xsList =xsService.getXs(month);
        System.out.println(xsList);

        String fileName = "fleetCount" +".xls";//设置要导出的文件的名字
        //新增数据行，并且设置单元格数据
        int rowNum = 1;
        String[] headers = {"车队","出车次数"};
        //headers表示excel表中第一行的表头
        HSSFRow row = sheet.createRow(0);
        //在excel表中添加表头
        for(int i=0;i<headers.length;i++){
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        //在表中存放查询到的数据放入对应的列
        for (Xs xs : xsList) {
            HSSFRow row1 = sheet.createRow(rowNum);
            String vehicleTypeName = Tools.toABC(xs.getVehicleType());
            Integer count=xs.getCount();
            System.out.println("车队："+vehicleTypeName);
            System.out.println("次数："+count);
            row1.createCell(0).setCellValue(vehicleTypeName);
            row1.createCell(1).setCellValue(count);
            rowNum++;
        }
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.flushBuffer();
        workbook.write(response.getOutputStream());
    }

    @GetMapping("/excelDownloads_driver")
    public  void OutToExcel_driver(@RequestParam("month")Integer month,HttpServletResponse response) throws IOException {
        System.out.println("进入后端_司机");

        HSSFWorkbook workbook = new HSSFWorkbook();//创建HSSFWorkbook对象,  excel的文档对象
        HSSFSheet sheet = workbook.createSheet("司机出车统计表"); //excel的表单

        List<Xs_driver> xsList =xsService.getXs_driver(month);
        System.out.println(xsList);

        String fileName = "driverCount" +".xls";//设置要导出的文件的名字
        //新增数据行，并且设置单元格数据
        int rowNum = 1;
        String[] headers = {"司机","出车次数"};
        //headers表示excel表中第一行的表头
        HSSFRow row = sheet.createRow(0);
        //在excel表中添加表头
        for(int i=0;i<headers.length;i++){
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        //在表中存放查询到的数据放入对应的列
        for (Xs_driver xs : xsList) {
            HSSFRow row1 = sheet.createRow(rowNum);
            String arrangeDriverNum = xs.getArrangeDriverNum();
            Integer count=xs.getCount();
            System.out.println("司机："+arrangeDriverNum);
            System.out.println("次数："+count);
            row1.createCell(0).setCellValue(arrangeDriverNum);
            row1.createCell(1).setCellValue(count);
            rowNum++;
        }
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.flushBuffer();
        workbook.write(response.getOutputStream());
    }
}
