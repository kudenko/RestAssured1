package java_8_in_action.third_chapter;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class ConstructorRefeernce {
    static List<Integer> weights = Arrays.asList(7,3,4,8);
    static List<Ball> apples = map(weights, Ball::getBall);

    private static List<Ball> map(List<Integer> list, Function<Integer, Ball> f) {
        List<Ball> result = new ArrayList<>();
        for(Integer e:list){
            result.add(f.apply(e));
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(apples);
    }
}
