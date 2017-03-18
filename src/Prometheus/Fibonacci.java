package Prometheus;



/**
 * Created by Император on 13.03.2017.
 */
public class Fibonacci {

    public long getNumber(int position) {
        if (position <= 0) { return -1; }
        else if (position == 1) { return 1; }
        else if (position == 2) { return 1; }
        else { return getNumber(position-1 ) + getNumber(position -2); }

    }

}