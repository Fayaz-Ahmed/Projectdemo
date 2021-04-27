package com.excel.demo.excelresponse;

import org.json.JSONObject;

public class TelecomAdSpendDto {
	
	private int id;
	private JSONObject jsonObj;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public JSONObject getJsonObj() {
		return jsonObj;
	}
	public void setJsonObj(JSONObject jsonObj) {
		this.jsonObj = jsonObj;
	}
	public TelecomAdSpendDto(int id, JSONObject jsonObj) {
		super();
		this.id = id;
		this.jsonObj = jsonObj;
	}
	public TelecomAdSpendDto() {
		super();
	}
	
	

}
