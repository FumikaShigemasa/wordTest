package com.example.wordTest1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class App extends JFrame implements ActionListener {

	View view = new View();
	ReadExcel excel = new ReadExcel();

	public static void main(String[] args) {

		App frame = new App("基本情報技術者試験 単語テスト");
		frame.setVisible(true);
	}

	//自己呼び出しするコンストラクタにウィンドウの初期設定をする
	App(String title) {
		setTitle(title);//タイトルを設定
		setBounds(100, 100, 700, 700);//ウィンドウの位置とサイズを設定（x,y,width,hight）
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//×ボタンを押したときにプログラムを終了

		//		JPanel p = new JPanel();
		//		JButton btn = new JButton("PUSH");
		//		btn.addActionListener(this);
		//
		//		p.add(btn);
		//		getContentPane().add(p, BorderLayout.CENTER);

		JPanel selectFile = view.SelectFile(this);
		getContentPane().add(selectFile, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e) {

		excel.fileChoose();

		//		System.out.println(e.getActionCommand());
		//		JLabel label = new JLabel("Pushu A Button!");
		//
		//		JOptionPane.showMessageDialog(this, label);
	}
}
