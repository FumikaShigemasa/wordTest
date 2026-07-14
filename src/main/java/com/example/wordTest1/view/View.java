package com.example.wordTest1.view;

import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class View {

	//ファイル選択画面
	public JPanel selectFile(ActionListener actionListner) {
		//panelを作成
		JPanel selectFilePage = new JPanel();

		//ファイル選択ボタン
		JButton selectFileBtn = new JButton("ファイルを選択する");
		selectFileBtn.addActionListener(actionListner);
		selectFileBtn.setActionCommand("selectFile");

		//ファイル選択ボタンをpanelに追加
		selectFilePage.add(selectFileBtn);

		return selectFilePage;
	}

	//モード選択画面
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

	//クイズ方式選択画面
	public JPanel selectGenre(ActionListener actionListner) {
		JPanel selectGenrePage = new JPanel();

		//======ジャンル選択のラジオボタン======
		//テクノロジー系ボタン

		//マネジメント系ボタン

		//ストラテジー系ボタン

		//全ジャンルボタン

		//-------------------------------

		//======出題形式選択のラジオボタン======
		//単語→意味

		//意味→単語

		//---------------------------------

		//======開始ボタン======
		JButton startBtn = new JButton();
		startBtn.addActionListener(actionListner);
		startBtn.setActionCommand("start");
		//--------------------

		return selectGenrePage;
	}

	//単語帳方式選択画面
	public JPanel selectWordBookMode(ActionListener actionListner) {
		JPanel selectWordBookModePage = new JPanel();

		//======出題形式選択のラジオボタン======
		JRadioButton[] radio = new JRadioButton[2];

		radio[0] = new JRadioButton("単語→意味");
		radio[1] = new JRadioButton("意味→単語");

		ButtonGroup bgroup = new ButtonGroup();
		bgroup.add(radio[0]);
		bgroup.add(radio[1]);
		//---------------------------------

		//======開始ボタン======
		JButton startBtn = new JButton();
		startBtn.addActionListener(actionListner);
		startBtn.setActionCommand("start");
		//--------------------

		return selectWordBookModePage;
	}

}
