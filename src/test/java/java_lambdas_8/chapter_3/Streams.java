package java_lambdas_8.chapter_3;

import java.util.*;
import java.util.stream.Collectors;

public class Streams {


    public static void main(String[] args) {
        List<String> listFortest = new ArrayList<>();
        listFortest.add("asda");
        listFortest.add("asdasd");
        listFortest.add("a");
        listFortest.add("s");
        listFortest.add("1s");

        List<String> listFortest2 = new ArrayList<>();
        listFortest.add("asda11");
        listFortest.add("1asdasd11");


        long cc = listFortest.stream().filter(test-> {
            System.out.println(test);
            return test.contains("a");
        }).count();
        System.out.println(cc);

        List<String> col = listFortest.stream().filter(str->str.contains("a")).collect(Collectors.toList());
        System.out.println(col);

        List<String> mapExample = listFortest.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(mapExample);

        List<String> anotherFilter = listFortest.stream().filter(str->Character.isDigit(str.charAt(0))).collect(Collectors.toList());
        System.out.println(anotherFilter);
        String[][] data = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

        List<String> together = Arrays.stream(data).flatMap(str-> Arrays.stream(str).filter(a->a.contains("a"))).collect(Collectors.toList());

        System.out.println(together);

        Optional<String> min = listFortest.stream().min(Comparator.comparing(String::length));

        System.out.println(min.get());

        String sum = listFortest.stream().reduce("", (acc, elem) -> acc+elem);
        System.out.println(sum);


        int sum2 = listFortest.stream().map(String::length).reduce(0, (Integer firstEl, Integer secondElem) -> firstEl+secondElem);

        System.out.println(sum2);

    }
}
