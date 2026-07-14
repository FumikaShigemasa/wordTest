package com.example.wordTest1.view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SelectMode {

	public JPanel selectMode(ActionListener actionListner) {
		//panelを作成
		JPanel selectModePage = new JPanel();

		//クイズモードボタン
		JButton quizBtn = new JButton("クイズモード");
		quizBtn.addActionListener(actionListner);
		quizBtn.setActionCommand("quizMode");

		//単語帳モードボタン
		JButton wordBookBtn = new JButton("単語帳モード");
		wordBookBtn.addActionListener(actionListner);
		wordBookBtn.setActionCommand("wordBookMode");

		//ボタンを追加
		selectModePage.add(quizBtn);
		selectModePage.add(wordBookBtn);

		return selectModePage;
	}

}
