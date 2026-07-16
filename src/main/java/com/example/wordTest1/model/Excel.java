package com.example.wordTest1.model;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Excel {

	private Workbook workBook;
	private Sheet sheet;

	//ゲッターとセッター
	public Workbook getWorkBook() {
		return workBook;
	}

	public void setWorkBook(Workbook workBook) {
		this.workBook = workBook;
	}

	public Sheet getSheet() {
		return sheet;
	}

	public void setSheet(Sheet sheet) {
		this.sheet = sheet;
	}

}
