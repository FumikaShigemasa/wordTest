package com.example.wordTest1.view.quiz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.example.wordTest1.model.QuizModel;
import com.example.wordTest1.presenter.MainPresenter;

public class Correct extends JPanel {

	public Correct(
			MainPresenter controller,
			QuizModel quizModel) {
		//結果表示
		JLabel correct = new JLabel("正解！！");

		//正解表示
		JLabel question = new JLabel(quizModel.getQuestionStr());
		JLabel answer = new JLabel(quizModel.getAnswer());

		//次の行動を選択するボタン		
		//次へボタン
		JButton next = new JButton("次へ");
		next.addActionListener(e -> controller.next());

		//メインメニューへボタン
		JButton mainMenu = new JButton("メインメニューへ");
		mainMenu.addActionListener(e -> controller.mainMenu());

		//======レイアウト======
		//結果表示パネル
		JPanel result = new JPanel();
		GridBagLayout resultLayout = new GridBagLayout();
		result.setLayout(resultLayout);
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 0;
		resultLayout.setConstraints(correct, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		resultLayout.setConstraints(question, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		resultLayout.setConstraints(answer, gbc);

		result.add(correct);
		result.add(question);
		result.add(answer);

		//ボタンパネル
		JPanel select = new JPanel();
		select.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
		select.add(next);
		select.add(mainMenu);
		//--------------------

		//本体のパネルに各パネルを設定
		setLayout(new BorderLayout());

		add(result, BorderLayout.CENTER);
		add(select, BorderLayout.PAGE_END);

	}

}
