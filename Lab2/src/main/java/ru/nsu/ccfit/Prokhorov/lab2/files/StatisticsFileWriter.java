package ru.nsu.ccfit.Prokhorov.lab2.files;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class StatisticsFileWriter {

    private String filePath = "resources/main/stat.txt";
    private String mask = "%s %s\n";
    private FileWriter writter;
    public StatisticsFileWriter(){
        try {
            writter = new FileWriter(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeList(Map<String, Long> list) throws IOException {
        for(Map.Entry<String, Long> iter: list.entrySet()){
            writter.write(String.format(mask, iter.getKey(),iter.getValue()));
        }
        writter.close();
    }
}
