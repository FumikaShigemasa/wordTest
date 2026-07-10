package com.example.wordTest1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class App extends JFrame implements ActionListener {
	public static void main(String[] args) {

		App frame = new App("基本情報技術者試験 単語テスト");
		frame.setVisible(true);
	}

	//自己呼び出しするコンストラクタにウィンドウの初期設定をする
	App(String title) {
		setTitle(title);//タイトルを設定
		setBounds(100, 100, 700, 700);//ウィンドウの位置とサイズを設定（x,y,width,hight）
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//×ボタンを押したときにプログラムを終了

		JPanel p = new JPanel();
		JButton btn = new JButton("PUSH");
		btn.addActionListener(this);

		p.add(btn);
		getContentPane().add(p, BorderLayout.CENTER);

		JFileChooser fileChooser = new JFileChooser();
		int selected = fileChooser.showOpenDialog(null);

		if (selected == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			System.out.println("選択されたファイル: " + file.getAbsolutePath());
		} else {
			System.out.println("キャンセルされました。");
		}
	}

	public void actionPerformed(ActionEvent e) {
		JLabel label = new JLabel("Pushu A Button!");

		JOptionPane.showMessageDialog(this, label);
	}
}
