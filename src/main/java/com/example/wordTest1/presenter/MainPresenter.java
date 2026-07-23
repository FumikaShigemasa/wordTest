package com.example.wordTest1.presenter;

import java.awt.CardLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.example.wordTest1.model.ExcelModel;
import com.example.wordTest1.model.QuizModel;
import com.example.wordTest1.service.MakeQuestionService;
import com.example.wordTest1.service.ReadExcelService;
import com.example.wordTest1.view.Correct;
import com.example.wordTest1.view.Incorrect;
import com.example.wordTest1.view.Quiz;
import com.example.wordTest1.view.SelectGenre;
import com.example.wordTest1.view.SelectMode;

public class MainPresenter {

	private final ReadExcelService readExcel = new ReadExcelService();
	private final MakeQuestionService makeQuestion = new MakeQuestionService();

	private final ExcelModel excel = new ExcelModel();
	private final QuizModel quizModel = new QuizModel();

	private JPanel cardPanel;
	private CardLayout cardLayout;

	public ReadExcelService getReadExcel() {
		return readExcel;
	}

	public QuizModel getQuiz() {
		return quizModel;
	}

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
		//エクスプローラを開いてファイルを読み取る
		readExcel.readWorkbook(readExcel.fileChoose(), excel);

		//selectModeの画面に遷移
		JPanel selectMode = new SelectMode(this);
		cardPanel.add(selectMode, "selectMode");
		cardLayout.show(cardPanel, "selectMode");
	}

	//SelectMode quizBtn
	//クイズモードを選択
	public void selectQuiz() {
		//SelectGenreの画面に遷移
		JPanel selectGenre = new SelectGenre(this);
		cardPanel.add(selectGenre, "selectGenre");
		cardLayout.show(cardPanel, "selectGenre");
	}

	public void selectWordBook() {

	}

	//SelectGenre startBtn
	//ジャンルと出題形式を選択して単語テストを開始する
	public void start(
			ButtonGroup genre,
			ButtonGroup format) {

		//各ラジオボタンの選択されたActionCommandを取得
		String genreStr = genre.getSelection().getActionCommand();
		String formatStr = format.getSelection().getActionCommand();

		//ジャンル選択
		if (genreStr.equals("technology")) {
			readExcel.readSheet(0, excel);
		} else if (genreStr.equals("management")) {
			readExcel.readSheet(1, excel);
		} else if (genreStr.equals("strategy")) {
			readExcel.readSheet(2, excel);
		}

		//出題形式選択
		if (formatStr.equals("word")) {
			makeQuestion.setWordQuestion(excel, quizModel);

		} else if (formatStr.equals("mean")) {
			makeQuestion.setMeanQuestion(excel, quizModel);

		}

		//Quiz画面に遷移
		JPanel quiz = new Quiz(this, quizModel);
		cardPanel.add(quiz, "quiz");
		cardLayout.show(cardPanel, "quiz");
	}

	//Quiz button1-button4
	//正誤判定
	public void checkAnswer(
			JButton selectBtn) {
		//選択したボタンのテキストをInteger型で取得
		Integer selectNum = Integer.parseInt(selectBtn.getText());
		//正誤判定
		boolean judge = makeQuestion.judge(selectNum, quizModel);

		//正解→Correct 不正解→Incorrectに画面遷移
		if (judge) {
			JPanel correct = new Correct(this);
			cardPanel.add(correct, "correct");
			cardLayout.show(cardPanel, "correct");
		} else {
			JPanel incorrect = new Incorrect(this);
			cardPanel.add(incorrect, "incorrect");
			cardLayout.show(cardPanel, "incorrect");

		}

	}

	public void next() {

		String format = quizModel.getFormat();

		if (format.equals("word")) {
			makeQuestion.setWordQuestion(excel, quizModel);

		} else if (format.equals("mean")) {
			makeQuestion.setMeanQuestion(excel, quizModel);

		}

		//Quiz画面に遷移
		JPanel quiz = new Quiz(this, quizModel);
		cardPanel.add(quiz, "quiz");
		cardLayout.show(cardPanel, "quiz");

	}

	public void mainMenu() {
		//SelectMode画面に遷移
		JPanel selectMode = new SelectMode(this);
		cardPanel.add(selectMode, "selectMode");
		cardLayout.show(cardPanel, "selectMode");
	}

}
