package com.example.restservice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Collection;

@Component
public class Bd {
    private static final Logger logger = LogManager.getLogger(GreetingController.class);
    public void buildExcel(Collection<Greeting> greetingList) {

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Greeting List");
        sheet.setDefaultColumnWidth(20);
        HSSFRow header = sheet.createRow(0);
        int rowCount = 1;

        header.createCell(0).setCellValue("String");
        header.createCell(1).setCellValue("Symbol");
        header.createCell(2).setCellValue("Counter");

        for (Greeting greeting : greetingList) {
            HSSFRow row = sheet.createRow(rowCount++);
            row.createCell(0).setCellValue(greeting.getString());
            row.createCell(1).setCellValue(greeting.getSymbol());
            row.createCell(2).setCellValue(greeting.getCounter());
        }
        try {
            FileOutputStream out = new FileOutputStream("File.xls");
            workbook.write(out);
            out.close();
            logger.info("Excel sheet is created");
        } catch (IOException e) {
            logger.error("Creating error");
            e.printStackTrace();
        }
    }
}

