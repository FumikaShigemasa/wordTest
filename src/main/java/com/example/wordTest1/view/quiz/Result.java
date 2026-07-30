package com.example.wordTest1.view.quiz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.example.wordTest1.model.JodgeModel;
import com.example.wordTest1.model.QuizModel;
import com.example.wordTest1.presenter.MainPresenter;
import com.example.wordTest1.service.LayoutService;

public class Result extends JPanel {

	LayoutService layout = new LayoutService();

	public Result(
			MainPresenter controller,
			QuizModel quizModel,
			JodgeModel jodgeModel) {
		//結果表示
		JLabel result = new JLabel(jodgeModel.getResult());

		//画像
		ImageIcon image = new ImageIcon(
				getClass().getResource(jodgeModel.getImg()));
		JLabel img = new JLabel(image);

		//正解表示
		JTextArea question = new JTextArea(quizModel.getQuestionStr());
		JTextArea answer = new JTextArea(quizModel.getAnswer(), 5, 40);

		//次の行動を選択するボタン		
		//次へボタン

		JButton next = new JButton("次へ");
		next.addActionListener(e -> controller.next());

		//メインメニューへボタン
		JButton end = new JButton("終了する");
		end.addActionListener(e -> controller.mainMenu());

		//======レイアウト======
		//結果表示パネル
		JPanel resultPanel = new JPanel();
		layout.positionVer(resultPanel, result, img, question, answer);
		resultPanel.add(result);
		resultPanel.add(img);
		resultPanel.add(question);
		resultPanel.add(answer);

		//ボタンパネル
		JPanel select = new JPanel();
		select.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
		select.add(next);
		select.add(end);

		layout.titleLayout(result);
		layout.textLayout(question, answer);
		layout.btnLayout(next, end);
		layout.background(resultPanel, select);
		//--------------------

		//本体のパネルに各パネルを設定
		setLayout(new BorderLayout());
		add(resultPanel, BorderLayout.CENTER);
		add(select, BorderLayout.PAGE_END);

	}

}
