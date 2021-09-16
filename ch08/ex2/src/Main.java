import java.nio.file.*;
import java.util.*;
import java.io.*;

public class Main {
    public static Properties LoadProperties(String pathString) throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(pathString);
            properties.load(fileInputStream);
        } catch (FileNotFoundException fnfe) {
            System.out.println("WARNING: could not find the properties file");
        } catch (IOException ioe) {
            System.out.println("WARNING: problem processing the properties file");
        } finally {
            if (fileInputStream != null)
                fileInputStream.close();
        }
        return properties;
    }

    public static void WriteProperties(String pathString, Properties properties) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(pathString)) {
            properties.store(fileOutputStream, "# modified on: " + java.time.LocalDate.now());
        } catch (FileNotFoundException fnfe) {
            System.out.println("WARNING: could not find the properties file");
        } catch (IOException ioe) {
            System.out.println("WARNING: problem processing the properties file");
        }
    }

    public static void PrintOutProperties (Properties properties) {
        Enumeration keys = properties.keys();
        for (int i = 0; i< properties.size(); i++) {
            String key = keys.nextElement().toString();
            System.out.println(key + ": " + properties.getProperty(key));
        }
    }

    public static void main(String[] args) {
        // write your code here
        String pathString = System.getProperty("user.home") + "/javaTemp/" + args[0];
        Path pathFile = Paths.get(pathString);
        Properties properties = new Properties();
        if (Files.exists(pathFile)) {
            try {
                properties = LoadProperties(pathString);
            } catch (IOException ioe) {
                System.err.println();
            }
        }
        for (int i = 1; i < args.length; i++) {
            String[] keyValue = args[i].split("=");
            properties.setProperty(keyValue[0], keyValue[1]);
        }
        try {
            WriteProperties(pathString, properties);
        } catch (IOException ioe) {
            System.out.println("WARNING: problem while closing properties file");
        }
        PrintOutProperties(properties);
    }
}
