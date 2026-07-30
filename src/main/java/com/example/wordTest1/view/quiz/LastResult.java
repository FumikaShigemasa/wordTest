package com.example.wordTest1.view.quiz;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.example.wordTest1.model.ResultModel;
import com.example.wordTest1.presenter.MainPresenter;
import com.example.wordTest1.service.LayoutService;

public class LastResult extends JPanel {

	public LastResult(MainPresenter presenter,
			ResultModel resultModel) {

		LayoutService layout = new LayoutService();

		//タイトル
		JLabel title = new JLabel("単語テスト 結果");

		//正解数とコメント
		JLabel correctCount = new JLabel(resultModel.getQuestionCount() + "問中 " + resultModel.getCount() + "問 正解");
		JLabel coment = new JLabel(resultModel.getComent());
		JLabel img = new JLabel(new ImageIcon(getClass().getResource(resultModel.getImg())));

		JPanel result = new JPanel();
		layout.positionVer(result, correctCount, coment, img);
		result.add(correctCount);
		result.add(coment);
		result.add(img);

		//戻るボタン
		JButton toGenre = new JButton("ジャンル選択へ");
		toGenre.addActionListener(e -> presenter.toGenre());
		JButton toMode = new JButton("モード選択へ");

		JPanel selectPanel = new JPanel();
		selectPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
		selectPanel.add(toGenre);
		selectPanel.add(toMode);

		//レイアウト
		layout.titleLayout(title, correctCount, coment);
		layout.btnLayout(toGenre, toMode);
		layout.background(this, result, selectPanel);

		layout.positionVer(this, title, result, selectPanel);
		add(result);
		add(title);
		add(selectPanel);

	}

}
