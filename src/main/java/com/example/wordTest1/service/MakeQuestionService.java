package com.example.wordTest1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.example.wordTest1.model.Excel;
import com.example.wordTest1.model.Question;

public class MakeQuestionService {

	ReadExcelService readExcel = new ReadExcelService();
	Random rand = new Random();

	//行番号のリストをランダムで取得
	public Integer[] rowNum(Sheet sheet) {

		Integer[] rowNumList = new Integer[4];

		int end = sheet.getLastRowNum();

		for (int i = 0; i < rowNumList.length; i++) {

			//while判定用
			boolean check = true;

			while (check) {
				//endまでの数字をランダムで生成
				Integer rowNum = rand.nextInt(end);

				//rowNumListが0のときに無限ループに入るのを防止
				if (rowNumList[0] == null) {
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
					rowNumList[i] = rowNum;
				}

			}
		}

		for (Integer num : rowNumList) {
			System.out.print(num + ",");
		}

		return rowNumList;
	}

	//行のリストを取得
	public List<Row> getRowList(Excel excel, Integer[] rowNumList) {

		List<Row> rowList = new ArrayList<Row>();
		for (Integer rowNum : rowNumList) {
			Row row = readExcel.readRow(rowNum, excel);
			rowList.add(row);
		}

		return rowList;
	}

	//問題と選択肢のリストを作成
	public Question setQuestion(
			List<Row> rowList,
			Question question) {

		//rowNumListから問題とする番号をランダムに取る
		Integer index = rand.nextInt(4);

		//問題と選択肢を生成
		String questionStr = "";
		String answer = "";
		String[] optionList = new String[4];

		for (int i = 0; i < rowList.size(); i++) {
			Row row = rowList.get(i);
			if (i == index) {
				//問題と正答を取得
				questionStr = readExcel.getMean(row);
				answer = readExcel.getWord(row);
				optionList[i] = answer;

			} else {
				//誤答択を取得
				String option = readExcel.getWord(row);
				optionList[i] = option;
			}
		}

		//questionに渡す
		question.setQuestionStr(questionStr);
		question.setAnswer(answer);
		question.setOptionList(optionList);

		System.out.println(question.getQuestionStr());

		for (String option : question.getOptionList()) {
			System.out.println(option);
		}

		System.out.println(question.getAnswer());

		return question;
	}

}
