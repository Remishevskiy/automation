package Prometheus;



/**
 * Created by Император on 13.03.2017.
 */
public class FibonacciTest {

    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();
        System.out.println("Последовательность Фибоначчи:");
        for (int i = 0; i < 20; i++)
        {
            System.out.print("" + fib.getNumber(i) + " ");
        }
        System.out.println();
        System.out.println("fib.getNumber(-1) = " + fib.getNumber(-1));
        System.out.println("fib.getNumber(2) = " + fib.getNumber(4));
    }

}