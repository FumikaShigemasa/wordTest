package com.example.wordTest1.view;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SelectFile {

	public SelectFile(
	//ActionListener actionListner
	) {
		//panelを作成
		JPanel selectFilePage = new JPanel();

		//ファイル選択ボタン
		JButton selectFileBtn = new JButton("ファイルを選択する");
		//		selectFileBtn.addActionListener(actionListner);
		selectFileBtn.setActionCommand("selectFile");

		//ファイル選択ボタンをpanelに追加
		selectFilePage.add(selectFileBtn);

	}

}
