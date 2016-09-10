package ui;

import ftp.FtpUploder;
import html.HtmlGenerator;

public class Main {

	public static void main(String[] args) {
		HtmlGenerator generator = new HtmlGenerator();
		FtpUploder uploader = new FtpUploder();
		
		
		generator.setTitle("hola mundo");
		generator.setContent("hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo hola mundo ");
		generator.setPhotoFolder("D:/ali.jpg");
		generator.setAltText("hola Mundo");
		generator.setFooter("este es el footer");
		generator.setPhotoMessege("hola mundo");
		generator.generate();
		
		uploader.setServer("ftp.alialmandoz.hol.es");
		uploader.setPort(21);
		uploader.setUser("u326125313");
		uploader.setPass("hostinger159753");
		
	}

}
