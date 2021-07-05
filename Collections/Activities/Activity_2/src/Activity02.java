import java.util.*;

public class Activity02 {
    public static void main(String[] args) {
        Random random = new Random();
        int numSize = Math.abs(random.nextInt(10_000_000));
        List<Double> numbers = new ArrayList<Double>(numSize);
        for (int i = 0; i < numSize; i++)
            numbers.add(random.nextDouble() * 10000);
        Iterator iterator = numbers.listIterator();
        double average = 0.0;
        while (iterator.hasNext()) {
            average += (double) iterator.next() / numbers.size();
        }
        System.out.println("Total amount of numbers: " + numbers.size());
        System.out.println("Average: " + average);
    }
}
