package com.example.wordTest1;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.example.wordTest1.service.Question;
import com.example.wordTest1.service.ReadExcel;
import com.example.wordTest1.view.View;

public class App extends JFrame implements ActionListener {

	View view = new View();
	ReadExcel excel = new ReadExcel();
	Question question = new Question();

	JPanel cardPanel;
	CardLayout cardLayout;

	public static void main(String[] args) {

		App frame = new App("基本情報技術者試験 単語テスト");
		frame.setVisible(true);
	}

	//自己呼び出しするコンストラクタにウィンドウの初期設定をする
	App(String title) {
		setTitle(title);//タイトルを設定
		setBounds(100, 100, 700, 700);//ウィンドウの位置とサイズを設定（x,y,width,hight）
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//×ボタンを押したときにプログラムを終了

		JPanel selectFile = view.selectFile(this);
		JPanel selectMode = view.selectMode(this);

		//CardLayoutが設定されたpanelに各panelを追加する
		cardPanel = new JPanel();
		cardLayout = new CardLayout();
		cardPanel.setLayout(cardLayout);

		cardPanel.add(selectFile);
		cardPanel.add(selectMode, "selectMode");

		//contentPaneにコンポーネントを追加する
		Container contentPane = getContentPane();
		contentPane.add(cardPanel, BorderLayout.CENTER);

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("selectFile")) {
			String fileName = excel.fileChoose();
			Workbook workbook = excel.readWorkbook(fileName);
			Sheet sheet = excel.readSheet(workbook, 0);
			question.question(sheet, question.rowNum(sheet));

			cardLayout.show(cardPanel, "selectMode");
		}
	}
}
