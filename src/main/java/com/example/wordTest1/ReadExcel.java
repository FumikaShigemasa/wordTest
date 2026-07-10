package com.example.wordTest1;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcel {

	public Workbook readWorkbook(String fileName) {

		Workbook workbook = null;

		try {
			//excelのファイルをWorkbook型で取得
			workbook = WorkbookFactory.create(new File(fileName));

		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (workbook != null) {
					// Excelを閉じる
					workbook.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return workbook;

	}

	//Excelファイルのシートを取得する
	//0→テクノロジ系　1→マネジメント系　2→ストラテジ系
	public Sheet readSheet(Workbook workbook, Integer page) {

		Sheet sheet = null;

		if (workbook != null) {
			sheet = workbook.getSheetAt(page);
		}

		return sheet;
	}

	//行を取得
	public Row questionRow(Sheet sheet, Integer rowNum) {
		Row row = null;

		if (sheet != null) {
			//questionNum行の行を取得
			row = sheet.getRow(rowNum);
		}

		return row;
	}

	//問題を取得
	public String getQuestion(Row row) {
		Cell cell = row.getCell(1);
		String question = "";

		if (cell != null) {
			question = cell.getStringCellValue();
		}

		return question;
	}

	//答えを取得
	public String getAnswer(Row row) {
		Cell cell = row.getCell(0);
		String answer = "";

		if (cell != null) {
			answer = cell.getStringCellValue();
		}

		return answer;
	}

}
