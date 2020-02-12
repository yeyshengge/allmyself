package com.zps;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class test01 {

    @Test
    public void demo01() throws Exception {
        //获取封装对象
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook("C:\\Users\\ymshe\\Desktop\\新建 Microsoft Excel 工作表.xlsx");
        //拿取第一张表封装成对象
        XSSFSheet sheetAt = xssfWorkbook.getSheetAt(0);
        //遍历每一行
        for (Row row : sheetAt) {
            //遍历每一列
            for (Cell cell : row) {
                System.out.println(cell.getStringCellValue());
            }
        }
        xssfWorkbook.close();
    }

    @Test
    public void demo02() throws Exception {
        //获取封装对象
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook("C:\\Users\\ymshe\\Desktop\\新建 Microsoft Excel 工作表.xlsx");
        //拿取第一张表封装成对象
        XSSFSheet sheet = xssfWorkbook.getSheetAt(0);

        //拿取最后一个单元格索引
        int lastRowNum = sheet.getLastRowNum();

        for (int i = 0; i <= lastRowNum; i++) {
            //拿到每一列
            XSSFRow row = sheet.getRow(i);

            //拿到每一列有多少个单元格
            short lastCellNum = row.getLastCellNum();
            for (int j = 0; j < lastCellNum; j++) {

                XSSFCell cell = row.getCell(j);

                System.out.println(cell.getStringCellValue());

            }
            xssfWorkbook.close();
        }
    }

    @Test
    public void demo013() throws IOException {
        //无参构造表示new一个新的excel表格对象
        XSSFWorkbook excel = new XSSFWorkbook();
        //创建一个表并取名
        XSSFSheet sheet = excel.createSheet("测试表");
        //创建标题列（第一行）
        XSSFRow title = sheet.createRow(0);
        title.createCell(0).setCellValue("姓名");
        title.createCell(1).setCellValue("年龄");
        title.createCell(2).setCellValue("地址");

        XSSFRow dataRow = sheet.createRow(1);
        dataRow.createCell(0).setCellValue("张三");
        dataRow.createCell(1).setCellValue("18");
        dataRow.createCell(2).setCellValue("长沙");

        FileOutputStream fileOutputStream = new FileOutputStream(new File("d:\\test.xlsx"));
        excel.write(fileOutputStream);
        fileOutputStream.flush();
        excel.close();

    }
}
