package com.company.main;

import com.company.main.loggercomponent.Pipe;
import com.company.main.loggercomponent.SeverityLevel;

public class Main {
	
	public static void main(String[] args) {

		Pipe.open();
		for (int i = 0; i < 1000; i++) {
			Pipe.print(SeverityLevel.FINE, "Hello!!! Welcome!!!");
			Pipe.print(SeverityLevel.WARNING, "Error has been found");
			Pipe.print(SeverityLevel.CONFIG, "Setting up!");
			Pipe.print(SeverityLevel.SEVERE, "Process crashed");
			Pipe.print(SeverityLevel.INFO, "This is Info");
		}
		Pipe.close();
	}
}
