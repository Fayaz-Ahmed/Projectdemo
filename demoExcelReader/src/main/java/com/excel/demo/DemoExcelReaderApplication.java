package com.excel.demo;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoExcelReaderApplication {
	
	public static final String SAMPLE_XLSX_FILE_PATH = "/Users/fatech98/Desktop/ProjectUK/POC data.xlsx";

	public static void main(String[] args) throws InvalidFormatException, IOException {
		SpringApplication.run(DemoExcelReaderApplication.class, args);
		
//		 // Creating a Workbook from an Excel file (.xls or .xlsx)
//        Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));
//
//        // Retrieving the number of sheets in the Workbook
//        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
//        
//        
//        System.out.println("Retrieving Sheets using for-each loop");
//        for(Sheet sheet: workbook) {
//            System.out.println("=> " + sheet.getSheetName());
//        }
        
        
//        int x=workbook.getNumberOfSheets();
//        
//   		
//    	// Getting the Sheet at index zero
//        for(int i=0;i<x;i++) {
//       Sheet sheet1 = workbook.getSheetAt(0);
//    	
//   System.out.println("The sheet number is "+i);
//
//        // Create a DataFormatter to format and get each cell's value as String
//        DataFormatter dataFormatter = new DataFormatter();
//        
//        
//        // 2. Or you can use a for-each loop to iterate over the rows and columns
//        System.out.println("\n\nIterating over Rows and Columns using for-each loop\n");
//        for (Row row: sheet1) {
//            for(Cell cell: row) {
//                String cellValue = dataFormatter.formatCellValue(cell);
//                System.out.print(cellValue + "\t");
//            }
//            System.out.println();
//        }
    	  
        }//loop
        //getsheetsname(workbook);
       // getsheetsdata(workbook);
           
   

//	}
	

}
