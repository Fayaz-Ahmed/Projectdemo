package com.excel.demo.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Component;

import com.excel.demo.excelresponse.SheetResponse;
import com.excel.demo.excelresponse.TabResponse;
import com.excel.demo.model.TelecomAdSpend;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ExcelUtil {

	public void getSheetDetails(String excelPath)
			throws EncryptedDocumentException, InvalidFormatException, IOException {

		// Creating a Workbook from an Excel file (.xls or .xlsx)
		Workbook workbook = WorkbookFactory.create(new File(excelPath));

		// Retrieving the number of sheets in the Workbook
		System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");

		System.out.println("Retrieving Sheets using for-each loop");

		for (Sheet sheet : workbook) {
			System.out.println("=> " + sheet.getSheetName());
		}
	}

	public SheetResponse readExcelSheet(String excelPath)
			throws EncryptedDocumentException, InvalidFormatException, IOException {

	

		// Creating a Workbook from an Excel file (.xls or .xlsx)
		Workbook workbook = WorkbookFactory.create(new File(excelPath));

		int x = workbook.getNumberOfSheets();

		SheetResponse response = new SheetResponse();
		List<TabResponse> listoftabs = new ArrayList<TabResponse>();

		// Getting the Sheet at index zero
		for (int i = 0; i < x; i++) {
			String header=null;
			List<String> headerList=new ArrayList<String>();
			TabResponse tabresponse = new TabResponse();
			
			List<TelecomAdSpend> jsonValueList=new ArrayList<TelecomAdSpend>();

			Sheet sheet1 = workbook.getSheetAt(i);

			int noOfColumns = sheet1.getRow(2).getLastCellNum();

			// Create a DataFormatter to format and get each cell's value as String
			DataFormatter dataFormatter = new DataFormatter();

			System.out.println("The sheet number is " + i + 1);
			// 2. Or you can use a for-each loop to iterate over the rows and columns
			System.out.println("\n\nIterating over Rows and Columns using for-each loop\n");

			for (Row row : sheet1) {
				TelecomAdSpend jsonValue = null;
				List<String> list = new ArrayList<String>();
				System.out.println(row.getRowNum());
				if (row.getRowNum() == 0) {
					continue; // just skip the rows if row number is 0 or 1
				}
 
				for (Cell cell : row) {
					cell.setCellType(CellType.STRING);

					if (row.getRowNum() == 1) {
						 header = dataFormatter.formatCellValue(cell);
						 headerList.add(header); System.out.println(header);
					}
					else {
					String cellValue = dataFormatter.formatCellValue(cell);
					//System.out.print(cellValue + "\t");
					list.add(cellValue);
					}

				}
				System.out.println();
				if (row.getRowNum() != 1) {
					jsonValue = createList(list, headerList);
					jsonValueList.add(jsonValue);				
				}
				
			} // loop
			// adSpendList = createList(list, noOfColumns);System.out.println(list.get(0)+"
			// "+list.get(1));
			
			 tabresponse.setListAdSpend(jsonValueList);
			 listoftabs.add(tabresponse);
		}

		 response.setListSheetAdSpend(listoftabs);
		 
		return response;
	}

	private TelecomAdSpend createList(List<String> excelData, List<String> headerList) throws JsonProcessingException {

	TelecomAdSpend telAdSpend = new TelecomAdSpend();
		HashMap<String, String> map=new HashMap<String, String>();

		int i = 0;
		
			
		for(String cellvalue : excelData) {
			map.put(headerList.get(i), cellvalue);
			i++;
		}
		
		
		String json = new ObjectMapper().writeValueAsString(map);
		telAdSpend.setJsonString(json);
		System.out.println(json);
		
		
		return telAdSpend;
	}
}
