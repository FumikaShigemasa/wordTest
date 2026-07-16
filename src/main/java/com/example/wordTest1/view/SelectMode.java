package com.example.wordTest1.view;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.example.wordTest1.controller.MainController;

public class SelectMode extends JPanel {

	public SelectMode(MainController mainController) {

		//継承したJPanelのコンストラクタ
		super();

		//クイズモードボタン
		JButton quizBtn = new JButton("クイズモード");
		quizBtn.addActionListener(e -> mainController.selectQuiz());

		//単語帳モードボタン
		JButton wordBookBtn = new JButton("単語帳モード");
		wordBookBtn.addActionListener(e -> mainController.selectWordBook());

		//ボタンを追加
		add(quizBtn);
		add(wordBookBtn);

	}

}
