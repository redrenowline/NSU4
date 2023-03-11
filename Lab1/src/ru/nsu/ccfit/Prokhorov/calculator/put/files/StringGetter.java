package ru.nsu.ccfit.Prokhorov.calculator.put.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public final class StringGetter {
	
	private File fl;
	private BufferedReader reader;
	
	public StringGetter(String str) throws FileNotFoundException {
		fl = new File(str);
		reader = new BufferedReader(new FileReader(fl));
	}
	
	public String getString() throws IOException {
		return reader.readLine();
	}
}
