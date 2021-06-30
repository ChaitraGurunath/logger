package com.logger.loggerapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.FilterInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoggerComponent {
	
	static Logger logger = Logger.getLogger(LoggerComponent.class.getName());
	
	public static void main(String[] args) {

		String fileName = new SimpleDateFormat("yyyy-MM-dd HH:mm'.txt'").format(new Date());
		String path = "/" + fileName;
		System.out.println(fileName);
		System.out.println(path);
		String message = "Hello!!! Welcome!!!";
		
		try {
			createNewFile(path, message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void createNewFile(String fileName, String message) throws IOException {
		
			File file = new File(fileName);
			file.createNewFile();
			
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(message);
			fileWriter.close();
		
//		LogManager.getLogManager().readConfiguration(file);
//		logger.setLevel(Level.SEVERE);
//		logger.log(Level.SEVERE, message);
	}
}
