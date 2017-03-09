package utility;


public class SquareRoot2 {

     public static void main(String args[]){

              for (int i = 1; i < 26; i++) {

        switch (i) {
            case 1:  System.out.print(" *"+ " " );
                continue;
            case 5:  {System.out.print(" *"+ " ");
                System.out.println();
                continue;}
            case 6:  {System.out.print(" "+i+ " ");
                continue;}
            case 7:  System.out.print(" *"+ " ");
                continue;
            case 9:  System.out.print(" *"+ " ");
                continue;
            case 10:  {System.out.print(i+ " ");
                System.out.println();
                continue;}
            case 13:  System.out.print(" *"+ " ");
                continue;
            case 15:  {System.out.print(i+ " ");
                System.out.println();
                continue;}
            case 17:  System.out.print(" *"+ " ");
                continue;
            case 19:  System.out.print(" *"+ " ");
                continue;
            case 20:  {System.out.print(i+ " ");
                System.out.println();
                continue;}

            case 21:  System.out.print(" *"+ " ");
                continue;
            case 25:  System.out.print(" *"+ " ");
                continue;
            default: {
                if (i<10) System.out.print(" " + i + " ");
                else System.out.print(i + " ");
                continue;
            }
        }

    }

    //PUT YOUR CODE HERE
}
}



