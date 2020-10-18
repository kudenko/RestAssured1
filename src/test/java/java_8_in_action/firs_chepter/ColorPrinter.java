package java_8_in_action.firs_chepter;

public class ColorPrinter implements ApplePrinter {
    @Override
    public String print(Apple apple) {
        return "Appcle color is: " + apple.color;
    }
}
