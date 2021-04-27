package com.excel.demo.controller;

import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.excel.demo.excelresponse.SheetResponse;
import com.excel.demo.excelresponse.TelecomAdSpendDto;
import com.excel.demo.model.TelecomAdSpend;
import com.excel.demo.service.ExcelService;
import com.mysql.cj.xdevapi.JsonArray;
import io.swagger.models.Response;

@RestController
@RequestMapping("/api")
public class ExcelController {
	
	@Autowired
	ExcelService excelService;
	
	@PostMapping("read/excel")
	public SheetResponse readExcel(MultipartFile multipartFile) {
		return excelService.readData(multipartFile);
		
	}
	
	@GetMapping
	public  String getPocData(){	
		JSONArray arr=excelService.getPocData();
		if(arr.isEmpty()) {
			System.out.println("test controller");
		}
		System.out.println("test "+excelService.getPocData().getJSONObject(0));
		  excelService.getPocData().getJSONObject(0);
		 
		  return excelService.getPocData().toString();
	}

}
