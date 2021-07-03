package ru.nesterlab;

import java.io.Console;
import java.util.*;

public class Exercise02 {
    public static void main(String[] args) {
        Console cons;
        String line = "";
        ArrayList<String> text = new ArrayList<String>();
        while (!line.equals("*") &&
                (cons = System.console()) != null
                && (line = cons.readLine()) != null) {
            List<String> lineList = new ArrayList<String>(Arrays.asList(line.split(" ")));
            text.addAll(lineList);
        }
        System.out.println("You typed: " + text);
        System.out.println("Word counted: " + text.size());

        Set<String> textSet = new HashSet<String>();
        textSet.addAll(text);
        Iterator iterator = textSet.iterator();
        while (iterator.hasNext())
        {
            String s = (String) iterator.next();
            int freq = Collections.frequency(text, s);
            System.out.println(s + " appears " + freq + " times.");
        }
    }
}
