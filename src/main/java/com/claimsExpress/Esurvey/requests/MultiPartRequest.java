package com.claimsExpress.Esurvey.requests;

public class MultiPartRequest {

	private String fileName ;
	
	private byte[] data ;

	private String type ;
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public MultiPartRequest() {
		// TODO Auto-generated constructor stub
	}


	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

}
