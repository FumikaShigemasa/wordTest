package com.example.wordTest1.view.quiz;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.example.wordTest1.presenter.MainPresenter;

public class Incorrect extends JPanel {

	public Incorrect(MainPresenter controller) {
		//不正解
		JLabel label = new JLabel("不正解...");

		//次へボタン
		JButton next = new JButton("次へ");
		next.addActionListener(e -> controller.next());

		//メインメニューへボタン
		JButton mainMenu = new JButton("メインメニューへ");
		mainMenu.addActionListener(e -> controller.mainMenu());

		ImageIcon image = new ImageIcon("./../../image/incorrect.png");

		JLabel img = new JLabel(image);

		add(label);
		add(next);
		add(mainMenu);
		add(img);
	}

}
