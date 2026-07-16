package com.example.wordTest1.controller;

import java.awt.CardLayout;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;

import com.example.wordTest1.model.ExcelModel;
import com.example.wordTest1.model.QuizModel;
import com.example.wordTest1.service.MakeQuestionService;
import com.example.wordTest1.service.ReadExcelService;

public class MainController {

	private final ReadExcelService readExcel = new ReadExcelService();
	private final MakeQuestionService makeQuestion = new MakeQuestionService();

	private final ExcelModel excel = new ExcelModel();
	private final QuizModel quiz = new QuizModel();

	private JPanel cardPanel;
	private CardLayout cardLayout;

	public void setCardPanel(JPanel cardPanel) {
		this.cardPanel = cardPanel;
	}

	public void setCardLayout(CardLayout cardLayout) {
		this.cardLayout = cardLayout;
	}

	//====================ここからが処理======================	

	//SelectFile selectFileBtn
	//ファイル選択
	public void selectFile() {

		readExcel.readWorkbook(readExcel.fileChoose(), excel);

		cardLayout.show(cardPanel, "selectMode");
	}

	public void selectQuiz() {

		cardLayout.show(cardPanel, "selectGenre");
	}

	public void selectWordBook() {

	}

	//SelectGenre startBtn
	//ジャンルと出題形式を選択して単語テストを開始する
	public void start(
			ButtonGroup genre,
			ButtonGroup format) {

		String genreStr = genre.getSelection().getActionCommand();
		String formatStr = format.getSelection().getActionCommand();

		if (genreStr.equals("technology")) {
			readExcel.readSheet(0, excel);
		} else if (genreStr.equals("management")) {
			readExcel.readSheet(1, excel);
		} else if (genreStr.equals("strategy")) {
			readExcel.readSheet(2, excel);
		}

		if (formatStr.equals("word")) {
			makeQuestion.setWordQuestion(excel, quiz);

		} else if (formatStr.equals("mean")) {
			makeQuestion.setMeanQuestion(excel, quiz);

		}

		cardLayout.show(cardPanel, "quiz");
	}

	//Quiz button1-button4
	//正誤判定
	public void checkAnswer() {

	}

}
