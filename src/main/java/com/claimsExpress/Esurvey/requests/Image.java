package com.claimsExpress.Esurvey.requests;

import javassist.bytecode.ByteArray;

public class Image {
	private String	 fileName  ;
	 
	private ByteArray data ;
			 
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public ByteArray getData() {
		return data;
	}

	public void setData(ByteArray data) {
		this.data = data;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	private String type ;
}
