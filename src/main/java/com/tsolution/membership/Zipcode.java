package com.care.membership;

//우편번호 검색 
public class Zipcode {
	private String zipcode;
	private String sido;
	private String sigungu;
	private String ubmyeun;
	private String doro;
	private String dong1;
	private String ri;
	private String dong2;

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getSido() {
		return sido;
	}

	public void setSido(String sido) {
		this.sido = sido;
	}

	public String getSigungu() {
		return sigungu;
	}

	public void setSigungu(String sigungu) {
		this.sigungu = sigungu;
	}

	public String getUbmyeun() {
		return ubmyeun;
	}

	public void setUbmyeun(String ubmyeun) {
		this.ubmyeun = ubmyeun;
	}

	public String getDoro() {
		return doro;
	}

	public void setDoro(String doro) {
		this.doro = doro;
	}

	public String getDong1() {
		return dong1;
	}

	public void setDong1(String dong1) {
		this.dong1 = dong1;
	}

	public String getRi() {
		return ri;
	}

	public void setRi(String ri) {
		this.ri = ri;
	}

	public String getDong2() {
		return dong2;
	}

	public void setDong2(String dong2) {
		this.dong2 = dong2;
	}

	// Zipcode 모델 복사
	public void CopyData(Zipcode param) {
		this.zipcode = param.getZipcode();
		this.sido = param.getSido();
		this.sigungu = param.getSigungu();
		this.ubmyeun = param.getUbmyeun();
		this.doro = param.getDoro();
		this.dong1 = param.getDong1();
		this.ri = param.getRi();
		this.dong2 = param.getDong2();
	}
}
