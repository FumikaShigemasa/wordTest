package com.example.wordTest1.view;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.example.wordTest1.presenter.MainPresenter;
import com.example.wordTest1.service.LayoutService;

public class SelectFile extends JPanel {

	public SelectFile(MainPresenter mainController) {

		//継承したJPanelのコンストラクタ
		super();

		//ファイル選択ボタン
		JButton selectFileBtn = new JButton("ファイルを選択する");
		selectFileBtn.addActionListener(e -> mainController.selectFile());

		//レイアウト
		LayoutService layout = new LayoutService();
		layout.btnLayout(selectFileBtn);
		layout.positionVer(this, selectFileBtn);
		layout.background(this);

		//ボタンを追加
		add(selectFileBtn);

	}

}
