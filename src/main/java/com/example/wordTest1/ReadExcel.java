package com.example.wordTest1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcel {

	Random rand = new Random();

	//ファイルのパスを指定
	String file = "C:\\Users\\fumika.shigemasa\\Desktop\\研修\\基本情報\\word.xlsx";

	//Excelファイルのシートを取得する
	//0→テクノロジ系　1→マネジメント系　2→ストラテジ系
	public Sheet readSheet(Integer page) {
		Workbook workbook = null;
		Sheet sheet = null;

		try {
			//excelのファイルをWorkbook型で取得
			workbook = WorkbookFactory.create(new File(file));
			//page番のシートを取得
			sheet = workbook.getSheetAt(page);

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

		return sheet;
	}

	//行番号のリストを取得
	public List<Integer> rowNum(Sheet sheet) {

		List<Integer> rowNumList = new ArrayList<Integer>();

		int end = sheet.getLastRowNum();

		for (int i = 0; i < 4; i++) {
			Integer test = -1;
			Integer rowNum = -1;

			while (rowNum == test) {
				rowNum = rand.nextInt(end + 1);

			}

		}

		return rowNumList;
	}

	//問題と答えになる行を取得
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

	//選択肢を取得
	public String getOption(Sheet sheet) {
		String option = "";

		if (sheet != null) {

			Cell cell = null;

			while (cell == null) {

				//sheetの最終行を取得
				int end = sheet.getLastRowNum();
				//0からendまでの範囲でランダムな数字を生成
				int optionNum = rand.nextInt(end + 1);

				//optionNum行の行を取得
				Row row = sheet.getRow(optionNum);

				//1列（単語の行）の値を取得
				cell = row.getCell(0);
				if (cell != null) {
					option = cell.getStringCellValue();
				}
			}
		}

		return option;
	}

}
