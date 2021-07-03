package ru.nesterlab;

import java.io.Console;
import java.util.*;

class DataPoint {
    String key = "";
    Integer value = 0;

    public DataPoint(String key, Integer value) {
        this.key = key;
        this.value = value;
    }
}

class SortByValue implements Comparator<DataPoint> {

    @Override
    public int compare(DataPoint a, DataPoint b) {
        return a.value - b.value;
    }
}

public class Exercise03 {
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
        List<DataPoint> frequencies = new ArrayList<DataPoint>();
        while (iterator.hasNext()) {
            String s = (String) iterator.next();
            int freq = Collections.frequency(text, s);
            System.out.println(s + " appears " + freq + " times.");
            DataPoint dataPoint = new DataPoint(s, freq);
            frequencies.add(dataPoint);
        }
        Collections.sort(frequencies, new SortByValue());
        System.out.println("Results sorted");
        for (int i = 0; i < frequencies.size(); i++)
            System.out.println(frequencies.get(i).value
                    + " times for word "
                    + frequencies.get(i).key);
    }
}
