package com.excel.demo.model;

import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class TelecomAdSpend {
	@Id
	@GeneratedValue
	private int id;
	
	private String jsonString;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJsonString() {
		return jsonString;
	}

	public void setJsonString(String jsonString) {
		this.jsonString = jsonString;
	}

	public TelecomAdSpend(int id, String jsonString) {
		super();
		this.id = id;
		this.jsonString = jsonString;
	}

	public TelecomAdSpend() {
		super();
	}

}
