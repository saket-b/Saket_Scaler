package Generic;

public class Pair <T, U>{

    T x;
    U y;

    T getFirst(){
        return x;
    }

    U getSecond(){
        return  y;
    }
    void setFirst( T x)
    {
        this.x = x;
    }
}
