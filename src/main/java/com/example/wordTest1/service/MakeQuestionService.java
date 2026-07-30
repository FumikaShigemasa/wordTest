package com.example.wordTest1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.example.wordTest1.model.ExcelModel;
import com.example.wordTest1.model.JodgeModel;
import com.example.wordTest1.model.QuizModel;

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
				Integer rowNum = rand.nextInt(end - 1) + 1;

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
	public List<Row> getRowList(ExcelModel excel, Integer[] rowNumList) {

		List<Row> rowList = new ArrayList<Row>();
		for (Integer rowNum : rowNumList) {
			Row row = readExcel.readRow(rowNum, excel);
			rowList.add(row);
		}

		return rowList;
	}

	//==========意味→単語==========
	//問題と選択肢のリストを作成
	public QuizModel makeMeanQuestion(
			List<Row> rowList,
			QuizModel quiz) {

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
		quiz.setQuestionStr(questionStr);
		quiz.setAnswer(answer);
		quiz.setOptionList(optionList);

		System.out.println(quiz.getQuestionStr());

		for (String option : quiz.getOptionList()) {
			System.out.println(option);
		}

		System.out.println(quiz.getAnswer());

		return quiz;
	}

	public void setMeanQuestion(
			ExcelModel excel,
			QuizModel quiz) {

		quiz.setFormat("mean");

		Integer[] rowNumList = rowNum(excel.getSheet());
		List<Row> rowList = getRowList(excel, rowNumList);
		makeMeanQuestion(rowList, quiz);
	}

	//----------------------------

	//==========単語→意味==========
	//問題と選択肢のリストを作成
	public QuizModel makeWordQuestion(
			List<Row> rowList,
			QuizModel quiz) {

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
				questionStr = readExcel.getWord(row);
				answer = readExcel.getMean(row);
				optionList[i] = answer;

			} else {
				//誤答択を取得
				String option = readExcel.getMean(row);
				optionList[i] = option;
			}
		}

		//quizに渡す
		quiz.setQuestionStr(questionStr);
		quiz.setAnswer(answer);
		quiz.setOptionList(optionList);

		System.out.println(quiz.getQuestionStr());

		for (String option : quiz.getOptionList()) {
			System.out.println(option);
		}

		System.out.println(quiz.getAnswer());

		return quiz;
	}

	public void setWordQuestion(
			ExcelModel excel,
			QuizModel quiz) {

		quiz.setFormat("word");

		Integer[] rowNumList = rowNum(excel.getSheet());
		List<Row> rowList = getRowList(excel, rowNumList);
		makeWordQuestion(rowList, quiz);
	}
	//----------------------------

	//==========正誤判定==========
	public void judge(
			Integer btnNum,
			QuizModel quizModel,
			JodgeModel jodgeModel) {
		//選択した解答と正答のStringを取得
		String correct = quizModel.getAnswer();
		String select = quizModel.getOptionList()[btnNum - 1];

		System.out.println("正誤判定");
		System.out.println("解答：" + btnNum + select + "正解：" + correct);

		//正誤判定
		if (correct.equals(select)) {
			jodgeModel.setResult("正解!!");
			jodgeModel.setImg(
					image("correct"));
			System.out.println("正解");
		} else {
			jodgeModel.setResult("残念...");
			jodgeModel.setImg(
					image("incorrect"));
			System.out.println("不正解");
		}

	}

	//画像の決定
	public String image(String result) {
		Integer imgNum = rand.nextInt(3);
		String fileName = "img" + (imgNum + 1);

		String filePass = "/images/" + result + "/" + fileName + ".png";

		return filePass;
	}
	//---------------------------

}
