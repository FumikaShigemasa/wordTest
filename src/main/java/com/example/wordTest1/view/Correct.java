package com.example.wordTest1.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.example.wordTest1.presenter.MainPresenter;

public class Correct extends JPanel {

	public Correct(MainPresenter controller) {
		//正解
		JLabel label = new JLabel("正解！！");

		//次へボタン
		JButton next = new JButton("次へ");
		next.addActionListener(e -> controller.next());

		//メインメニューへボタン
		JButton mainMenu = new JButton("メインメニューへ");
		mainMenu.addActionListener(e -> controller.mainMenu());

		add(label);
		add(next);
		add(mainMenu);
	}

}
