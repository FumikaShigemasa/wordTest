package com.example.wordTest1.view.quiz;

import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.example.wordTest1.presenter.MainPresenter;
import com.example.wordTest1.service.LayoutService;

public class SelectGenre extends JPanel {

	public SelectGenre(MainPresenter controller) {

		LayoutService layout = new LayoutService();

		//======ジャンルのラジオボタン======
		//説明
		JLabel genreLabel = new JLabel("ジャンルを選んでください");

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
		JPanel genreRadioPanel = new JPanel();
		genreRadioPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
		genreRadioPanel.add(techRadio);
		genreRadioPanel.add(manageRadio);
		genreRadioPanel.add(straRadio);

		JPanel genrePanel = new JPanel();
		layout.positionVer(genrePanel, genreLabel, genreRadioPanel);
		genrePanel.add(genreLabel);
		genrePanel.add(genreRadioPanel);

		//-----------------------------

		//======出題形式のラジオボタン======
		//説明
		JLabel formatLabel = new JLabel("出題形式を選んでください");

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

		//出題形式ボタン用のパネルに追加
		JPanel formatRadioPanel = new JPanel();
		formatRadioPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
		formatRadioPanel.add(wordRadio);
		formatRadioPanel.add(meanRadio);

		//ラベルと合わせて1つのパネルにする
		JPanel formatPanel = new JPanel();
		layout.positionVer(formatPanel, formatLabel, formatRadioPanel);
		formatPanel.add(formatLabel);
		formatPanel.add(formatRadioPanel);
		//-----------------------------

		//======決定ボタン======
		JButton startBtn = new JButton("開始");
		startBtn.addActionListener(e -> controller.start(genre, format));

		//ボタンをパネルに追加
		JPanel startPanel = new JPanel();
		startPanel.add(startBtn);
		//---------------------

		//======レイアウト======
		layout.radioBtnLayout(
				techRadio, manageRadio, straRadio, wordRadio, meanRadio);
		layout.btnLayout(startBtn);
		layout.titleLayout(genreLabel, formatLabel);
		layout.background(this, genrePanel, formatPanel, startPanel);
		layout.transparent(genreRadioPanel, formatRadioPanel);
		//------------------

		//各パネルを親のパネルに追加
		layout.positionVer(this, genrePanel, formatPanel, startPanel);
		add(genrePanel);
		add(formatPanel);
		add(startPanel);

	}

}
