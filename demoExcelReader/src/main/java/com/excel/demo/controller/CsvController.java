
package com.excel.demo.controller;

import java.util.List;
import com.excel.demo.model.TelecomAdSpend;
import com.excel.demo.repository.TeleComRepository;
import com.excel.demo.service.TelComService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/fl")
@RestController
public class CsvController {
	public TelComService telComService;
	public TeleComRepository teleComRepository;

	public CsvController(TelComService telComService, TeleComRepository teleComRepository) {
		this.telComService = telComService;
		this.teleComRepository = teleComRepository;
	}

	@GetMapping(path = "/generate/csv")
	public ResponseEntity<?> getCsvById() throws Exception {
		return telComService.generateCSV();

	}

	@GetMapping(path = "/csvget/all")
	public List<TelecomAdSpend> getAllCSV() {
		return teleComRepository.findAll();

	}

}
