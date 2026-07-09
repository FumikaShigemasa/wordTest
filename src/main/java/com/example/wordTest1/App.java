package com.example.wordTest1;

import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;

public class App {
	public static void main(String[] args) {
		System.out.println("動いててえらいね");

		ReadExcel excel = new ReadExcel();
		Question question = new Question();

		Sheet sheet = excel.readSheet(1);

		List<Integer> rowNumList = question.rowNum(sheet);

		List<String> questionList = question.question(sheet, rowNumList);

	}
}
