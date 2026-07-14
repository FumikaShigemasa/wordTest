package com.example.wordTest1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class Question {

	//行番号のリストをランダムで取得
	public List<Integer> rowNum(Sheet sheet) {

		Random rand = new Random();

		List<Integer> rowNumList = new ArrayList<Integer>();

		int end = sheet.getLastRowNum();

		for (int i = 0; i < 4; i++) {

			//while判定用
			boolean check = true;

			while (check) {
				//endまでの数字をランダムで生成
				Integer rowNum = rand.nextInt(end);

				//rowNumListが0のときに無限ループに入るのを防止
				if (rowNumList.size() == 0) {
					check = false;
				} else {
					for (Integer test : rowNumList) {
						//rowNumListの要素に被ってるものがあったらランダム生成をしなおす
						if (rowNum == test) {
							check = true;
							break;
						} else {
							check = false;
						}
					}
				}

				//checkがfalseだったらrwoNumListに追加
				if (!check) {
					rowNumList.add(rowNum);
				}

			}
		}

		for (Integer num : rowNumList) {
			System.out.print(num + ",");
		}

		return rowNumList;
	}

	//問題と選択肢のリストを作成
	public List<String> question(Sheet sheet, List<Integer> rowNumList) {

		ReadExcel excel = new ReadExcel();

		//行を取得
		List<Row> rowList = new ArrayList<Row>();
		for (Integer rowNum : rowNumList) {
			Row row = excel.questionRow(sheet, rowNum);
			rowList.add(row);
		}

		//問題と選択肢のリストを生成
		//リストはString型で(問題, 正答, 誤答1, 誤答2, 誤答3)で格納される
		List<String> questionList = new ArrayList<String>();

		for (int i = 0; i < rowNumList.size(); i++) {
			Row row = rowList.get(i);
			if (i == 0) {
				//問題を取得してリストに追加
				String question = excel.getQuestion(row);
				questionList.add(question);

				//答えを取得してリストに追加
				String answer = excel.getAnswer(row);
				questionList.add(answer);

			} else {
				//誤答択を取得
				String option = excel.getAnswer(row);
				questionList.add(option);
			}
		}

		for (String str : questionList) {
			System.out.println(str);
		}

		return questionList;
	}

}
