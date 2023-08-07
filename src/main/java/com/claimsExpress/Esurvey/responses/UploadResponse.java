package com.claimsExpress.Esurvey.responses;

import java.io.File;

public class UploadResponse {
	
	private String notification;

	private String fileType;

	private  File  file;

	public String getNotification() {
		return notification;
	}

	public void setNotification(String notification) {
		this.notification = notification;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

}
