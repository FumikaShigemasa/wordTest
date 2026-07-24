package com.example.wordTest1.view.quiz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.example.wordTest1.presenter.MainPresenter;

public class Correct extends JPanel {

	public Correct(MainPresenter controller) {
		//結果表示
		JLabel correct = new JLabel("正解！！");

		//次の行動を選択するボタン		
		//次へボタン
		JButton next = new JButton("次へ");
		next.addActionListener(e -> controller.next());

		//メインメニューへボタン
		JButton mainMenu = new JButton("メインメニューへ");
		mainMenu.addActionListener(e -> controller.mainMenu());

		//レイアウト
		//結果表示パネル
		JPanel result = new JPanel();
		result.setLayout(new FlowLayout(FlowLayout.CENTER));
		result.add(correct);

		//ボタンパネル
		JPanel select = new JPanel();
		select.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
		select.add(next);
		select.add(mainMenu);

		//本体のパネルに各パネルを設定
		setLayout(new BorderLayout());

		add(result, BorderLayout.CENTER);
		add(select, BorderLayout.PAGE_END);

	}

}
