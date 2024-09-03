import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.Formatter;

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
        double res=Calc.Arctan_d();
        System.out.println("Double atan = " + res + "\n");
        BigDecimal Big_res = Calc.Arctan_Bd();
        System.out.println("BigDecimal atan = " + Big_res + "\n");
        BigDecimal LongRes1= new BigDecimal(Math.atan(x));
        System.out.println("Встроенный atan = " + LongRes1 + "\n");

        System.out.println("Форматы:");
        Formatter formatter = new Formatter();
        formatter.format("Восьмеричное представление k: %#o%n",k);
        formatter.format("Шестнадцатеричное представление k: %#x%n",k);
        StringBuilder sb=new StringBuilder("+010.");
        sb.append(Integer.valueOf(k+1).toString());
        formatter.format("Число с минимальной шириной поля %"+ sb +"f%n",res);
        System.out.println(formatter);
        formatter.close();
        in.close();
    }
}