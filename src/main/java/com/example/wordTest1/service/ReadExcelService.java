package com.example.wordTest1.service;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.example.wordTest1.model.ExcelModel;

public class ReadExcelService {

	//エクスプローラーを開いてFileオブジェクトを取得する
	public File fileChoose() {

		File file = null;

		JFileChooser fileChooser = new JFileChooser();
		int selected = fileChooser.showOpenDialog(null);

		if (selected == JFileChooser.APPROVE_OPTION) {
			file = fileChooser.getSelectedFile();
			System.out.println("選択されたファイル: " + file.getAbsolutePath());
		} else {
			System.out.println("キャンセルされました。");
		}

		return file;
	}

	//ExcelファイルをWorkbookオブジェクトとして取得
	public void readWorkbook(
			File file,
			ExcelModel excel) {

		Workbook workbook = null;

		try {
			//excelのファイルをWorkbook型で取得
			workbook = WorkbookFactory.create(file);
			System.out.println("完了");

		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		} finally {
			try {
				if (workbook != null) {
					// Excelを閉じる
					workbook.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(0);
			}
		}

		//Excelモデルに渡す
		excel.setWorkBook(workbook);

	}

	//Excelファイルのシートを取得する
	//0→テクノロジ系　1→マネジメント系　2→ストラテジ系
	public void readSheet(Integer page, ExcelModel excel) {

		Workbook workbook = excel.getWorkBook();

		Sheet sheet = null;

		if (workbook != null) {
			sheet = workbook.getSheetAt(page);
		}

		//Excelモデルに渡す
		excel.setSheet(sheet);
	}

	//行を取得
	public Row readRow(Integer rowNum, ExcelModel excel) {

		Sheet sheet = excel.getSheet();

		Row row = null;

		if (sheet != null) {
			//questionNum行の行を取得
			row = sheet.getRow(rowNum);
		}

		return row;
	}

	//意味を取得
	public String getMean(Row row) {

		//rowから単語のcellを取得
		Cell cell = null;
		if (row != null) {
			cell = row.getCell(1);
		}

		//取得したcellの値(単語)を取得
		String mean = "";
		if (cell != null) {
			mean = cell.getStringCellValue();
		}

		return mean;
	}

	//単語を取得
	public String getWord(Row row) {

		//rowから単語のcellを取得
		Cell cell = null;
		if (row != null) {
			cell = row.getCell(0);
		}

		//取得したcellの値(単語)を取得
		String word = "";
		if (cell != null) {
			word = cell.getStringCellValue();
		}

		return word;
	}

}
