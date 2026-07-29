package com.example.wordTest1.view.quiz;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.example.wordTest1.model.QuizModel;
import com.example.wordTest1.presenter.MainPresenter;
import com.example.wordTest1.service.LayoutService;

public class Quiz extends JPanel {

	public Quiz(
			MainPresenter controller,
			QuizModel quizModel) {

		LayoutService layout = new LayoutService();

		//======問題文======
		JTextArea question = new JTextArea(quizModel.getQuestionStr());
		JPanel questionPanel = new JPanel();
		questionPanel.add(question);
		//------------------

		//======選択肢リスト======
		String[] optionList = quizModel.getOptionList();
		JTextArea[] textList = new JTextArea[optionList.length];

		for (int i = 0; i < optionList.length; i++) {
			int num = i + 1;
			textList[i] = new JTextArea(num + ", " + optionList[i]);
		}

		JPanel optionPanel = new JPanel(new GridLayout(4, 1));
		for (JTextArea text : textList) {
			optionPanel.add(text);
		}
		//----------------------

		//======解答用ボタン======
		JButton button1 = new JButton("1");
		button1.addActionListener(e -> controller.checkAnswer(button1));

		JButton button2 = new JButton("2");
		button2.addActionListener(e -> controller.checkAnswer(button2));

		JButton button3 = new JButton("3");
		button3.addActionListener(e -> controller.checkAnswer(button3));

		JButton button4 = new JButton("4");
		button4.addActionListener(e -> controller.checkAnswer(button4));

		JPanel buttonPanel = new JPanel(new GridLayout(1, 4));
		buttonPanel.add(button1);
		buttonPanel.add(button2);
		buttonPanel.add(button3);
		buttonPanel.add(button4);
		//----------------------

		//======レイアウト======
		layout.textLayout(question);
		layout.textLayout(textList);
		layout.btnLayout(button1, button2, button3, button4);

		//-------------------

		setLayout(new GridLayout(3, 1));
		add(questionPanel);
		add(optionPanel);
		add(buttonPanel);
	}

}
