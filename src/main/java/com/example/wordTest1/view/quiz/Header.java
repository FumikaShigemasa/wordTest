package com.example.wordTest1.view.quiz;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.example.wordTest1.presenter.MainPresenter;

public class Header extends JPanel {

	public Header(MainPresenter presenter) {

		JButton selectFile = new JButton("ファイル選択");
		JButton selectMode = new JButton("モード選択");
		JButton selectGenre = new JButton("ジャンル選択");

	}

}
