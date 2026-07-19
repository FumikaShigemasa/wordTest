package com.example.wordTest1;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.example.wordTest1.presenter.MainPresenter;
import com.example.wordTest1.view.SelectFile;

public class App extends JFrame {

	//Gitてすと！！

	private final MainPresenter controller = new MainPresenter();

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

		//最初の画面をオブジェクト化
		SelectFile selectfile = new SelectFile(controller);

		//CardLayoutが設定されたpanelに初期画面のpanelを追加する
		cardPanel = new JPanel();
		cardLayout = new CardLayout();
		cardPanel.setLayout(cardLayout);

		cardPanel.add(selectfile);

		//MainControllerのフィールドにあるcardLayoutとcardPanelを更新
		controller.setCardLayout(cardLayout);
		controller.setCardPanel(cardPanel);

		//contentPaneにコンポーネントを追加する
		Container contentPane = getContentPane();
		contentPane.add(cardPanel, BorderLayout.CENTER);

	}
}
