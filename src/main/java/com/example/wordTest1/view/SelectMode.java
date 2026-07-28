package com.example.wordTest1.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.example.wordTest1.presenter.MainPresenter;
import com.example.wordTest1.service.LayoutService;

public class SelectMode extends JPanel {

	public SelectMode(MainPresenter controller) {

		//継承したJPanelのコンストラクタ
		super();

		LayoutService layout = new LayoutService();

		//説明
		JLabel label = new JLabel("モードを選んでください。");

		//クイズモードボタン
		JButton quizBtn = new JButton("クイズモード");
		quizBtn.addActionListener(e -> controller.selectQuiz());

		//単語帳モードボタン
		JButton wordBookBtn = new JButton("単語帳モード");
		wordBookBtn.addActionListener(e -> controller.selectWordBook());

		//レイアウト設定
		layout.titleLayout(label);
		layout.btnLayout(quizBtn, wordBookBtn);

		JPanel margin = layout.marginPanle();
		layout.positionVer(this, label, quizBtn, margin, wordBookBtn);

		layout.background(this);

		//ボタンを追加
		add(label);
		add(quizBtn);
		add(margin);
		add(wordBookBtn);

	}

}
