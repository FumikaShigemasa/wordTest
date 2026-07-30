package com.example.wordTest1.model;

public class ResultModel {

	private int count;//正解数
	private int questionCount;//問題数

	private String coment;
	private String img;

	public ResultModel() {
		this.count = 0;
		this.questionCount = 0;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getQuestionCount() {
		return questionCount;
	}

	public void setQuestionCount(int questionCount) {
		this.questionCount = questionCount;
	}

	public String getComent() {
		return coment;
	}

	public void setComent(String coment) {
		this.coment = coment;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

}
