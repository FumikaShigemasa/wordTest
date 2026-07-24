package com.example.wordTest1.view.quiz;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.BoxLayout;
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
		correct.setAlignmentX(Component.CENTER_ALIGNMENT);
		correct.setAlignmentY(Component.CENTER_ALIGNMENT);

		JPanel result = new JPanel();
		result.setLayout(new BoxLayout(result, BoxLayout.Y_AXIS));
		result.add(correct);

		//ボタンパネル
		next.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainMenu.setAlignmentX(Component.CENTER_ALIGNMENT);

		JPanel select = new JPanel();
		select.setLayout(new BoxLayout(select, BoxLayout.X_AXIS));
		select.add(next);
		select.add(mainMenu);

		//本体のパネルに各パネルを設定
		setLayout(new BorderLayout());

		add(result, BorderLayout.CENTER);
		add(select, BorderLayout.PAGE_END);

	}

}
