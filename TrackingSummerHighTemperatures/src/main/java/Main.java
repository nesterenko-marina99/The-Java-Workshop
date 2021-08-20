public class Main {
    static SummerHighs summerHighs = new SummerHighs();
    static SummerHigh high = null;

    private static void outputSummerHigh(String[] args) {
        switch (args[0]) {
            case ("-city"):
                high = summerHighs.getByCity(args[1]);
                break;
            case ("-country"):
                high = summerHighs.getByCountry(args[1]);
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {
        String wrongInput = "Input format is:\n" + "-city London OR -country United Kingdom";
        summerHighs.initialize();
        switch (args.length) {
            case (2):
                outputSummerHigh(args);
                System.out.println(high.format(false));
                break;
            case (3):
                if ("-f".equals(args[2])) {
                    TempConverter tempConverter = new TempConverter();
                    outputSummerHigh(args);
                    tempConverter.convertTemp(high);
                    System.out.println(high.format(true));
                } else
                    System.err.println(wrongInput);
                break;
            default:
                System.err.println(wrongInput);
                break;
        }
    }
}