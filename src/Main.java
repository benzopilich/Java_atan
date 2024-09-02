import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите x E (-1,1): ");
        double x=in.nextDouble();
        if(x<=-1||x>=1)
        {
            System.out.println("Неправильное значение x.");
            return;
        }
        System.out.println("Введите k (точность): ");
        int k = in.nextInt();
        Rad Calc = new Rad(x, k);
        double res = Calc.Arctan();
        System.out.println("Мой atan = " + res + "\n");
        double res1 = Math.atan(x);
        System.out.println("Встроенный atan = " + res1 + "\n");
        in.close();
    }
}