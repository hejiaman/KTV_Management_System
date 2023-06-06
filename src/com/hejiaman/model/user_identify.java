package com.hejiaman.model;

public enum user_identify {
    ADMIN("管理员",0),CUSTOMER("顾客",1),WAITER("服务员",2);
	private String name;
	private int index;
	private user_identify(String name,int index) {
		this.name = name;
		this.index = index;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	@Override
	public String toString() {
		return this.name;
	}
}
