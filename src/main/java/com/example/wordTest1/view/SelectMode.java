package com.example.wordTest1.view;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.example.wordTest1.presenter.MainPresenter;

public class SelectMode extends JPanel {

	public SelectMode(MainPresenter controller) {

		//継承したJPanelのコンストラクタ
		super();

		//クイズモードボタン
		JButton quizBtn = new JButton("クイズモード");
		quizBtn.addActionListener(e -> controller.selectQuiz());

		//単語帳モードボタン
		JButton wordBookBtn = new JButton("単語帳モード");
		wordBookBtn.addActionListener(e -> controller.selectWordBook());

		//ボタンを追加
		add(quizBtn);
		add(wordBookBtn);

	}

}
