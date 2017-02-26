package utility;


public class SquareRoot2 {

    public static void main(String[] args) {
        double a = 3;
        double b = 2.5;
        double c = -0.5;

        double D = b * b - 4 * a * c;
        double x1;
        double x2;


        System.out.println(D);
        if (D > 0.0)
        {
            x1 = ((-b + Math.sqrt(D)) / (2 * a));
            x2 = ((-b - Math.sqrt(D)) / (2 * a));

            if ((x1 >= 0 | x1 < 0) & (x2 >= 0 | x2 < 0))
            {
                System.out.println("x1="+x1);
                System.out.println("x2="+x2);
            }

            else
            {
                System.out.println("x1=0.0");
                System.out.println("x2=0.0");
            }
        }

        else if (D == 0)
        {
            x1 = (- b)/(2*a);
            x2 = x1;

            if ((x1 >= 0 | x1 < 0) & (x2 >= 0 | x2 < 0))
            {
                System.out.println("x1="+x1);
                System.out.println("x2="+x2);
            }

            else
            {
                System.out.println("x1=");
                System.out.println("x2=");
            }
        }

        else
        {
            System.out.println("x1=");
            System.out.println("x2=");
        }
    }}
		