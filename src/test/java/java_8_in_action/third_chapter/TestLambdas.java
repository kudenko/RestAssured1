package java_8_in_action.third_chapter;

import java_8_in_action.PredicateExample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestLambdas {
    public static void main(String[] args) throws IOException {
        Runnable r = () -> {
//            System.out.println("asd");
//            System.out.println("test 2");
            int i = 1;
//            System.out.println(i);
        };

        r.run();

      //  String result = processFile((BufferedReader br) -> br.readLine() + br.readLine());
        String res = makeMeHappy((String s) -> s.length() + 3);
        System.out.println(res);
        List<String> testList = new ArrayList<>();
        List<String> nonEmpry = testList.stream().filter(a->!a.isEmpty()).collect(Collectors.toList());
        testList.forEach((String s) -> System.out.println(s.length()));
        Function<String, Integer> f = (String a)-> a.length()+3;

        List<Integer>  nonEmpry2 = testList.stream().map(f).collect(Collectors.toList());

        Function<PredicateExample.Apple, Integer> f2 = (PredicateExample.Apple a)-> a.getWeight()+3;

        List<PredicateExample.Apple>  testList11 = new ArrayList<>();

        Predicate<List<String>> a = (List<String> testList111)->testList111.isEmpty();


        List<Integer>  nonEmpry23 = testList11.stream().map(f2).collect(Collectors.toList());

        List<Integer>  nonEmpry2333 = testList.stream().map(f).collect(Collectors.toList());



        List<Integer>  nonEmpry2331 = new ArrayList<>();



        Function<Integer, String> f23 = (Integer as)-> as+"";

        List<String>  nonEmpry233 = nonEmpry2331.stream().map(f23).collect(Collectors.toList());

        MyLambda myLambda = (String s)->{
            System.out.println(s);
        };

        MyLambda myLambda1 = (String s)->{
            System.out.println(s);
            System.out.println(12321321);
            System.out.println("aslkdjaskldj");
        };
//        print(myLambda);
//        print(myLambda1);
        print((String s)->{
            System.out.println("asdas");
            System.out.println("Interesting");
        });


    }

    private static String makeMeHappy(TestL l) {
        System.out.println( l.make("HOW"));
        return  l.make("pld1")+"";
    }

    private static String processFile(BufferedReaderProcessor pr) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))){
            return pr.process(br);
        }
    }

    private static void print(MyLambda m) {
        m.printMe("asdsa");
    }




}
