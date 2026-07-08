package com.example.wordTest1;

public class App {
	public static void main(String[] args) {
		System.out.println("動いててえらいね");

		ReadExcel excel = new ReadExcel();
		excel.readSheet(1);
	}
}
