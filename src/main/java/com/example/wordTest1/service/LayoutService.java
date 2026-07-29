package com.example.wordTest1.service;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class LayoutService {

	//ボタンのレイアウト設定
	public void btnLayout(JButton... btnList) {
		for (JButton btn : btnList) {
			btn.setFont(new Font("BIZ UDPゴシック", Font.PLAIN, 20));//フォント
			btn.setForeground(new Color(255, 255, 255));//背景色
			btn.setBackground(new Color(183, 40, 46));//文字の色
			btn.setMargin(new Insets(15, 15, 15, 15));//余白
		}
	}

	//ラジオボタンの設定
	public void radioBtnLayout(JRadioButton... radioList) {
		for (JRadioButton radio : radioList) {
			radio.setFont(new Font("BIZ UDPゴシック", Font.PLAIN, 20));//フォント
		}

		transparent(radioList);
	}

	//本文テキストエリアのレイアウト設定
	public void textLayout(JTextArea... textList) {
		for (JTextArea text : textList) {
			text.setFont(new Font("BIZ UDPゴシック", Font.PLAIN, 16));//フォント
			text.setMargin(new Insets(20, 10, 20, 10));
			text.setLineWrap(true);//端で折り返す
			text.setEditable(false);//編集を不可にする
		}

		transparent(textList);
	}

	//タイトルラベルのレイアウト設定
	public void titleLayout(JLabel... labelList) {
		for (JLabel label : labelList) {
			label.setFont(new Font("BIZ UDPゴシック", Font.PLAIN, 24));//フォント
			label.setBorder(BorderFactory.createEmptyBorder(40, 0, 10, 0));//上下の余白
		}

		transparent(labelList);
	}

	//パネルのサイズを設定する
	public void panelSize(JPanel panel) {
		panel.setPreferredSize(null);
	}

	//背景色の設定
	public void background(JPanel... panelList) {
		for (JPanel panel : panelList) {
			panel.setBackground(new Color(237, 228, 225));
		}
	}

	//背景色の設定（デバッグ用）
	public void debugBackground(JComponent... componentList) {
		for (JComponent component : componentList) {
			component.setBackground(new Color(255, 215, 0));
		}
	}

	//背景を透明にする
	public void transparent(JComponent... componentList) {
		for (JComponent component : componentList) {
			component.setOpaque(false);
		}
	}

	//パネルの中央に縦に配置
	public void positionVer(
			JPanel panel,
			JComponent... componentList) {
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();

		panel.setLayout(layout);

		for (int i = 0; i < componentList.length; i++) {
			gbc.gridx = 0;
			gbc.gridy = i;
			layout.setConstraints(componentList[i], gbc);
		}

	}

	//余白用の空のパネルを生成する(10px * 10px)
	public JPanel marginPanle() {
		JPanel margin = new JPanel();
		margin.setPreferredSize(new Dimension(10, 10));
		margin.setOpaque(false);

		return margin;
	}

}
