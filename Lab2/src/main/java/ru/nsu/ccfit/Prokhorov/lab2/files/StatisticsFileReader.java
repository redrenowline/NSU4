package ru.nsu.ccfit.Prokhorov.lab2.files;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StatisticsFileReader {

    private String filePath = "resources/main/stat.txt";
    private FileReader reader;

    public StatisticsFileReader(){
        try {
            reader = new FileReader(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Map<String, Long> getList(){
        Map<String, Long> res = new HashMap<>();
        Scanner scan = new Scanner(reader);
        String strl;
        while(scan.hasNext()){
            strl = scan.nextLine();
            String[] args = strl.split(" ");
            res.put(args[0], Long.valueOf(args[1]));
        }
        return res;
    }
}
