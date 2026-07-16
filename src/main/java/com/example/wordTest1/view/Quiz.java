package com.example.wordTest1.view;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.example.wordTest1.controller.MainController;
import com.example.wordTest1.model.QuizModel;

public class Quiz extends JPanel {

	public Quiz(
			MainController controller,
			QuizModel quiz) {

		//======問題文======
		JLabel question = new JLabel(quiz.getQuestionStr());
		JPanel questionPanel = new JPanel();
		questionPanel.add(question);
		//------------------

		//======選択肢リスト======
		List<JLabel> labelList = new ArrayList<JLabel>();
		for (int i = 0; i < quiz.getOptionList().length; i++) {

			String[] optionList = quiz.getOptionList();
			int num = i + 1;
			labelList.add(new JLabel(num + optionList[i]));
		}

		JPanel optionPanel = new JPanel(new GridLayout(4, 1));
		for (JLabel label : labelList) {
			optionPanel.add(label);
		}
		//----------------------

		//======解答用ボタン======
		JButton button1 = new JButton("1");
		button1.addActionListener(e -> controller.checkAnswer());

		JButton button2 = new JButton("2");
		button2.addActionListener(e -> controller.checkAnswer());

		JButton button3 = new JButton("3");
		button3.addActionListener(e -> controller.checkAnswer());

		JButton button4 = new JButton("4");
		button4.addActionListener(e -> controller.checkAnswer());

		JPanel buttonPanel = new JPanel(new GridLayout(1, 4));
		buttonPanel.add(button1);
		buttonPanel.add(button2);
		buttonPanel.add(button3);
		buttonPanel.add(button4);
		//----------------------

		setLayout(new GridLayout(3, 1));
		add(questionPanel);
		add(optionPanel);
		add(buttonPanel);
	}

}
