/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package egovframework.com.main.service;

import egovframework.com.common.SearchDefaultVO;

/**
 * @Class Name : MainVO.java
 * @Description : MainVO Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2009.03.16           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2009. 03.16
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */
public class MainVO extends SearchDefaultVO {

	private static final long serialVersionUID = 1L;

	/** 디바이스 번호 */
	private String deviceId;
	/** 극초미세먼지 */
	private int pm10;
	/** 초미세먼지 */
	private int pm25;
	/** 미세먼지 */
	private int pm100;
	/** 섭씨온도 */
	private float tempc;
	/** 화씨온도 */
	private float tempf;
	/** 습도 */
	private float humi;
	/** 이산화탄소 */
	private float co2;
	/** 휘발성유기화합물 */
	private float tvoc;
	/** 공기질 */
	private int score;
	/** 측정시간 */
	private String date;
	
	
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public int getPm10() {
		return pm10;
	}
	public void setPm10(int pm10) {
		this.pm10 = pm10;
	}
	public int getPm25() {
		return pm25;
	}
	public void setPm25(int pm25) {
		this.pm25 = pm25;
	}
	public int getPm100() {
		return pm100;
	}
	public void setPm100(int pm100) {
		this.pm100 = pm100;
	}
	public float getTempCy() {
		return tempc;
	}
	public void setTempC(float tempc) {
		this.tempc = tempc;
	}
	public float getTempF() {
		return tempf;
	}
	public void setTempF(float tempf) {
		this.tempf = tempf;
	}
	public float getHumi() {
		return humi;
	}
	public void setHumi(float humi) {
		this.humi = humi ;
	}
	public float getCo2() {
		return co2;
	}
	public void setCo2(float co2) {
		this.co2 = co2 ;
	}
	public float getTvoc() {
		return tvoc;
	}
	public void setTvoc(int tvoc) {
		this.tvoc = tvoc ;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score ;
	}
	
	
	
	public String getdate() {
		return date;
	}
	public void setdate(String date) {
		this.date = date;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
