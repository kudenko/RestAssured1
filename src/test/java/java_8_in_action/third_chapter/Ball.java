package java_8_in_action.third_chapter;

public class Ball {
    int b;
    public Ball(){

    }

    public Ball(int s){
        b=s;
    }

    public static Ball getBall(int i){
        return new Ball(i-2);
    }

    @Override
    public String toString() {
        return "Ball{" +
                "b=" + b +
                '}';
    }
}
