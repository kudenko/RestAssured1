package java_8_in_action;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

public class PredicateExample {

    public static boolean isGreen(Apple a){
        return "green".equals(a.name);
    }

    public static boolean isGreen(){
       return true;
    }

    public static boolean isBig(Apple a){
        return 150 > a.weight;
    }

    static List<Apple> filterSomething(List<Apple> apples, Predicate<Apple> predicate){
        List<Apple> result = new ArrayList<>();
        for(Apple apple:apples){
            if(predicate.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

    static List<String> filterSomething2(List<String> apples, Predicate<String> predicate){
        List<String> result = new ArrayList<>();
        for(String apple:apples){
            if(predicate.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }



    public class Apple {
        int weight;
        String name;

        public Apple(Integer integer) {
            weight = integer;
        }

        public Apple() {

        }

        public int getWeight(){
            return weight;
        }

        public String getName() {
            return name;
        }



    }

    List<Apple> apples2 = new ArrayList<>();
    List<String> strings = new ArrayList<>();

    @Test
    public void gp(){
        List<Apple> apples3 = filterSomething(apples2, PredicateExample::isBig);
        List<Apple> apples4 = filterSomething(apples2, TestMyThoughts::isGenius);

        Comparator<Apple> c1 = (Apple a1, Apple a2)->a1.getWeight()-(a2.getWeight());

        Comparator<Apple> c2 = (Apple a1, Apple a2)->Integer.compare(a1.getWeight(), a2.getWeight());


        apples3.sort((Apple a1, Apple a2)
                -> a1.getName().compareTo(a2.getName()));

        List<String> apples5 = filterSomething2(strings, (String a)->a.equals("3"));

        List<Apple> apples6 = filterSomething(apples2, (Apple a) -> a.name.equals("333"));

        String s = "tetes";

        Integer iii = 33;

        Function<String, Integer> f = Integer::parseInt;

        System.out.println(testMethod("10", f));

        List<String> str = Arrays.asList("a","b","A","B");
        str.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
        str.sort(String::compareToIgnoreCase);

        Function<String, Integer> stringToInteger =
                Integer::parseInt;

        BiPredicate<List<String>, String> contains =
                List::contains;

        Apple a = new Apple();
        Supplier<Apple> b = Apple::new;
        Apple c = b.get();

        Function<Integer, Apple> b1 = Apple::new;
        Apple c11 = b1.apply(111);










    }

    public Integer testMethod(String s, Function<String, Integer> u){
        return  u.apply(s);

    }
}
