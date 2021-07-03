import java.util.*;
public class Example14 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("No");
        list.add("matter");
        list.add("what");
        list.add("you");
        list.add("do");
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
        Collections.rotate(list,3);
        System.out.println(list);
    }
}