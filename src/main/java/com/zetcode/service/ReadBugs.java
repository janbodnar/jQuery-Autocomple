package com.zetcode.service;

import com.opencsv.CSVReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;

public class ReadBugs {

    public static List<String> readAll(ServletContext context) throws IOException {

        InputStream is = context.getResourceAsStream("/WEB-INF/bugs.csv");
        
        List<String> bugsList = new ArrayList<>();
        
        try (CSVReader reader = new CSVReader(new InputStreamReader(is))) {
            String[] nextLine;
            
            while ((nextLine = reader.readNext()) != null) {

                for (String e : nextLine) {
                    bugsList.add(e.trim());
                }
            }
        }
        
        return bugsList;
    }
}
