package com.example.wordTest1;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class View {

	//ファイル選択画面
	public JPanel SelectFile(ActionListener actionListner) {
		JPanel selectFilePage = new JPanel();
		JButton selectFileBtn = new JButton("ファイルを選択する");
		selectFileBtn.addActionListener(actionListner);
		selectFileBtn.setActionCommand("selectFile");
		selectFilePage.add(selectFileBtn);

		return selectFilePage;
	}

}
