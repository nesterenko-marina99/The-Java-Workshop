import java.nio.file.*;
import java.util.logging.*;

public class Activity1 {
    public static void issuePointerException() throws NullPointerException {
        throw new NullPointerException("Exception: file not found");
    }
    public static void issueFileException() throws NoSuchFileException {
        throw new NoSuchFileException("Exception: file not found");
    }

    private static Logger logger = Logger.getLogger(Activity1.class.getName());
    public static void main(String[] args) {
        int number = Integer.valueOf(args[0]);
        switch (number) {
            case 1:
                try {
                    issuePointerException();
                }
                catch (NullPointerException npe) {
                    logger.log(Level.SEVERE, "Exceptions happened", npe);
                }
                break;
            case 2:
                try {
                    issueFileException();
                }
                catch (NoSuchFileException nfe) {
                    logger.log(Level.WARNING, "Exceptions happened", nfe);
                }
                break;
            case 3:
                try {
                    issueFileException();
                }
                catch (NoSuchFileException nfe) {
                    logger.log(Level.INFO, "Exceptions happened", nfe);
                }
                break;
        }
    }
}
