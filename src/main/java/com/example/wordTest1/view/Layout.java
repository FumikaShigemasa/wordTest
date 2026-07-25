package com.example.wordTest1.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Layout {

	public void btnLayout(JButton... btnList) {
		for (JButton btn : btnList) {
			btn.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
		}
	}

	public void textLayout(JLabel... labelList) {
		for (JLabel label : labelList) {
			label.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
		}
	}

	public void titleLayout(JLabel... labelList) {
		for (JLabel label : labelList) {
			label.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
		}
	}

	public void background(JPanel panel) {
		//		panel.setBackground();
	}

}
