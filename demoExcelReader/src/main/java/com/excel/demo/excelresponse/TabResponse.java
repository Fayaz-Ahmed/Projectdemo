package com.excel.demo.excelresponse;

import java.util.List;

import com.excel.demo.model.TelecomAdSpend;

public class TabResponse {
	
	private List<TelecomAdSpend> listAdSpend;

	public TabResponse() {
		super();
	}

	public TabResponse(List<TelecomAdSpend> listAdSpend) {
		super();
		this.listAdSpend = listAdSpend;
	}

	public List<TelecomAdSpend> getListAdSpend() {
		return listAdSpend;
	}

	public void setListAdSpend(List<TelecomAdSpend> listAdSpend) {
		this.listAdSpend = listAdSpend;
	}

}
