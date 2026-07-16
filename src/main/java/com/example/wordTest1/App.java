package com.example.wordTest1;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.example.wordTest1.controller.MainController;
import com.example.wordTest1.view.Quiz;
import com.example.wordTest1.view.SelectFile;
import com.example.wordTest1.view.SelectGenre;
import com.example.wordTest1.view.SelectMode;

public class App extends JFrame {

	private final MainController controller = new MainController();

	JPanel cardPanel;
	CardLayout cardLayout;

	public static void main(String[] args) {

		JFrame frame = new App("基本情報技術者試験 単語テスト");
		frame.setVisible(true);
	}

	//自己呼び出しするコンストラクタにウィンドウの初期設定をする
	App(String title) {
		setTitle(title);//タイトルを設定
		setBounds(100, 100, 700, 700);//ウィンドウの位置とサイズを設定（x,y,width,hight）
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//×ボタンを押したときにプログラムを終了

		//各画面をオブジェクト化
		SelectFile selectfile = new SelectFile(controller);
		SelectMode selectMode = new SelectMode(controller);
		SelectGenre selectGenre = new SelectGenre(controller);
		Quiz quiz = new Quiz(controller, controller.getQuiz());

		//CardLayoutが設定されたpanelに各panelを追加する
		cardPanel = new JPanel();
		cardLayout = new CardLayout();
		cardPanel.setLayout(cardLayout);

		cardPanel.add(selectfile);
		cardPanel.add(selectMode, "selectMode");
		cardPanel.add(selectGenre, "selectGenre");
		cardPanel.add(quiz, "quiz");

		//MainControllerのフィールドにあるcardLayoutとcardPanelを更新
		controller.setCardLayout(cardLayout);
		controller.setCardPanel(cardPanel);

		//contentPaneにコンポーネントを追加する
		Container contentPane = getContentPane();
		contentPane.add(cardPanel, BorderLayout.CENTER);

	}
}
