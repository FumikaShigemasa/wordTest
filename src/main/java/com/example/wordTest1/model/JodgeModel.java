package com.example.wordTest1.model;

public class JodgeModel {

	private String result;//結果（正解or不正解）
	private String img;//画像のURL

	private Integer count;//正解数
	private Integer continuous;//連続正解数

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getContinuous() {
		return continuous;
	}

	public void setContinuous(Integer continuous) {
		this.continuous = continuous;
	}

}
