package utility;


import java.util.InputMismatchException;
import java.util.Scanner;

public class SquareRoot {

        public static void main(String[] args) {
            int d = 0;
            for (int i=1; i<=25; i++){
                if(d%5==0){
                    System.out.println();
                }

                if(i==1||i==5||i==7||i==9||i==13||i==17||i==19||i==21|i==25){
                    System.out.print(" * ");
                    d++;
                }
                else if(i==24){
                    System.out.printf("24 ");

                }

                else if(i==25){
                    System.out.printf("*  ");

                }
                else if (i<10){
                    System.out.print(" "+i+" ");
                    d++;
                }
                else if(i>=10) {
                    System.out.print(i + " ");
                    d++;
                }



                }
            }}
		