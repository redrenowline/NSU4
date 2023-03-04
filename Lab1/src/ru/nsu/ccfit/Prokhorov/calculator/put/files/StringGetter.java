package ru.nsu.ccfit.Prokhorov.calculator.put.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public final class StringGetter {
	
	private File fl;
	private BufferedReader reader;
	
	public StringGetter(String str) {
		fl = new File(str);
		try {
			reader = new BufferedReader(new FileReader(fl));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public String getString() {
		try {
			return reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
