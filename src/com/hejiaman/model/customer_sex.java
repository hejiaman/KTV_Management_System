package com.hejiaman.model;

public enum customer_sex {
	MAN("男",0),WOMAN("女",1);
	private String sex;
	private int index;
	private customer_sex(String sex,int index) {
		this.sex = sex;
		this.index = index;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public String toString() {
		return this.sex;
	}
}

