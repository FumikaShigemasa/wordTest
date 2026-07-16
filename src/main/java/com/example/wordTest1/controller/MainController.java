package com.example.wordTest1.controller;

import java.awt.CardLayout;
import java.util.List;

import javax.swing.JPanel;

import org.apache.poi.ss.usermodel.Row;

import com.example.wordTest1.model.Excel;
import com.example.wordTest1.model.Question;
import com.example.wordTest1.service.MakeQuestionService;
import com.example.wordTest1.service.ReadExcelService;

public class MainController {

	private final ReadExcelService readExcel = new ReadExcelService();
	private final MakeQuestionService makeQuestion = new MakeQuestionService();

	private final Excel excel = new Excel();
	private final Question question = new Question();

	private JPanel cardPanel;
	private CardLayout cardLayout;

	public void setCardPanel(JPanel cardPanel) {
		this.cardPanel = cardPanel;
	}

	public void setCardLayout(CardLayout cardLayout) {
		this.cardLayout = cardLayout;
	}

	//====================ここからが処理======================	

	//SelectFile SelectFileBtn
	//ファイル選択
	public void selectFile() {

		readExcel.readWorkbook(readExcel.fileChoose(), excel);
		readExcel.readSheet(0, excel);

		Integer[] rowNumList = makeQuestion.rowNum(excel.getSheet());

		List<Row> rowList = makeQuestion.getRowList(excel, rowNumList);
		makeQuestion.setQuestion(rowList, question);

		cardLayout.show(cardPanel, "selectMode");
	}

	public void selectQuiz() {

	}

	public void selectWordBook() {

	}

}
