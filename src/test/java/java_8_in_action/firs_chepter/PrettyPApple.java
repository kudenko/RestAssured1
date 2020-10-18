package java_8_in_action.firs_chepter;

import java.util.ArrayList;
import java.util.List;

public class PrettyPApple {
    public static void main(String[] args) {
        Apple a = new Apple();
        a.weight = 153;
        a.color = "Red";

        Apple b = new Apple();
        b.weight = 11;
        b.color = "yellow";

        List<Apple> apples = new ArrayList<>();
        apples.add(a);
        apples.add(b);

        prettyPrintApple(apples, new HeavyApplePrinter());

        prettyPrintApple(apples, new ColorPrinter());
    }

    public static void prettyPrintApple(List<Apple> inventory, ApplePrinter printer) {
        for (Apple apple : inventory) {
            String output = printer.print(apple);
            System.out.println(output);

        }
    }


}
