package com.example.wordTest1.model;

public class Question {

	private String questionStr;//問題
	private String answer;//正答
	private String[] optionList = new String[4];//選択肢

	//ゲッターとセッター
	public String getQuestionStr() {
		return questionStr;
	}

	public void setQuestionStr(String question) {
		this.questionStr = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String[] getOptionList() {
		return optionList;
	}

	public void setOptionList(String[] optionList) {
		this.optionList = optionList;
	}

}
