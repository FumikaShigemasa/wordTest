package com.example.wordTest1.view;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.example.wordTest1.controller.MainController;

public class SelectGenre extends JPanel {

	public SelectGenre(MainController controller) {

		//継承したJPanelのコンストラクタ
		super();

		//======ジャンルのラジオボタン======
		//テクノロジー系
		JRadioButton techRadio = new JRadioButton("テクノロジー系");
		techRadio.setActionCommand("technology");

		//マネジメント系
		JRadioButton manageRadio = new JRadioButton("マネジメント系");
		manageRadio.setActionCommand("management");

		//ストラテジー系
		JRadioButton straRadio = new JRadioButton("ストラテジー系");
		straRadio.setActionCommand("strategy");

		//ジャンルのラジオボタンをグループ化
		ButtonGroup genre = new ButtonGroup();
		genre.add(techRadio);
		genre.add(manageRadio);
		genre.add(straRadio);

		//ジャンル用のパネルに追加
		JPanel genrePanel = new JPanel();
		genrePanel.setLayout(new GridLayout(1, 3));
		genrePanel.add(techRadio);
		genrePanel.add(manageRadio);
		genrePanel.add(straRadio);

		//-----------------------------

		//======出題形式のラジオボタン======
		//単語→意味
		JRadioButton wordRadio = new JRadioButton("単語→意味");
		wordRadio.setActionCommand("word");

		//意味→単語
		JRadioButton meanRadio = new JRadioButton("意味→単語");
		meanRadio.setActionCommand("mean");

		//出題形式のラジオボタンをグループ化
		ButtonGroup format = new ButtonGroup();
		format.add(wordRadio);
		format.add(meanRadio);

		//出題形式用のパネルに追加
		JPanel formatPanel = new JPanel();
		formatPanel.setLayout(new GridLayout(1, 2));
		formatPanel.add(wordRadio);
		formatPanel.add(meanRadio);
		//-----------------------------

		//======決定ボタン======
		JButton startBtn = new JButton("開始");
		startBtn.addActionListener(e -> controller.start(genre, format));

		//ボタンをパネルに追加
		JPanel startPanel = new JPanel();
		startPanel.add(startBtn);
		//---------------------

		//各パネルを親のパネルに追加
		setLayout(new GridLayout(3, 1));
		add(genrePanel);
		add(formatPanel);
		add(startPanel);

	}

}
