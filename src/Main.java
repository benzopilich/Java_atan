import java.math.BigDecimal;
import java.math.BigInteger;
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
        BigDecimal LongX=new BigDecimal(x);
        Rad Calc = new Rad(LongX, k);
        BigDecimal res = Calc.Arctan();
        System.out.println("Мой atan = " + res + "\n");
        BigDecimal LongRes1= new BigDecimal(Math.atan(x));
        System.out.println("Встроенный atan = " + LongRes1 + "\n");
        in.close();
    }
}