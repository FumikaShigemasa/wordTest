package com.example.wordTest1;

import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class App {
	public static void main(String[] args) {
		System.out.println("動いててえらいね");

		ReadExcel excel = new ReadExcel();
		Question question = new Question();

		//ファイルのパスを指定
		String fileName = "C:\\Users\\fumika.shigemasa\\Desktop\\研修\\基本情報\\word.xlsx";

		Workbook workbook = excel.readWorkbook(fileName);
		Sheet sheet = excel.readSheet(workbook, 0);

		List<Integer> rowNumList = question.rowNum(sheet);

		List<String> questionList = question.question(sheet, rowNumList);

	}
}
