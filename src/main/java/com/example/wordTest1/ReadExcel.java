package com.example.wordTest1;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
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

	//問題と答えになる行を取得
	public Row question(Sheet sheet) {
		Row row = null;

		if (sheet != null) {
			//sheetの最終行の行数を取得
			int end = sheet.getLastRowNum();

			//0からendまでの範囲でランダムな数字を生成
			int questionNum = rand.nextInt(end + 1);
			System.out.println(questionNum);

			//questionNum行の行を取得
			row = sheet.getRow(questionNum);
		}

		return row;
	}

}
