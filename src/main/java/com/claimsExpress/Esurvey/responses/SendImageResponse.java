package com.claimsExpress.Esurvey.responses;

import java.io.File;

public class SendImageResponse {
	
	private File inputfile;
	
	private String notification;

	public File getInputfile() {
		return inputfile;
	}

	public void setInputfile(File inputfile) {
		this.inputfile = inputfile;
	}

	public String getNotification() {
		return notification;
	}

	public void setNotification(String notification) {
		this.notification = notification;
	}

}
