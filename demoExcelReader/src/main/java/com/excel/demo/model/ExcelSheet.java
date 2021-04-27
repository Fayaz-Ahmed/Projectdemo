package com.excel.demo.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ExcelSheet {
	
	@Id
	private int id;
	private String name;
	private Date uploadedAt;
	
}
