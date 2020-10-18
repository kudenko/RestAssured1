package java_8_in_action;

public class TestMyThoughts {
    static boolean isGenius(PredicateExample.Apple a){
        return false;
    }

    static boolean isStupid(PredicateExample.Apple a){
        return true;
    }


    static boolean isStupid(){
        return true;
    }

    public static boolean isStupid(Object o) {
        if(o.equals(3)){
            return false;
        }
        return true;
    }
}
