package java_8_in_action.firs_chepter;

public class HeavyApplePrinter implements ApplePrinter {
    @Override
    public String print(Apple apple) {
        String weight;
        if(apple.weight > 150) {
            weight = "heavy";
        }else {
            weight = "light";
        }
        return "Apple weight is: " +  weight;
    }
}
