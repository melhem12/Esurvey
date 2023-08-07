package com.claimsExpress.Esurvey.responses;

public class FileDataPartResponse {

	private String Filename;
	
	 private byte[] data ;
	 
		private String type;

		public String getFilename() {
			return Filename;
		}

		public void setFilename(String filename) {
			Filename = filename;
		}

		public byte[] getData() {
			return data;
		}

		public void setData(byte[] data) {
			this.data = data;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}
}
