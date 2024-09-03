import java.math.BigDecimal;
import java.math.RoundingMode;

public class Rad {
    private int k;
    private double x;

    public Rad(double x1, int k1) {
        this.k = k1;
        this.x = x1;
    }

    public double Arctan_d(){
        double eps = Math.pow(10,-k);
        double sum = x;
        int t=3;
        double predSum=x;
        for(int i=1; ;i++)
        {
            sum+=Math.pow(-1,i)*Math.pow(x,t)/t;
            if(Math.abs(sum-predSum)<eps) {
                BigDecimal res=new BigDecimal(sum);
                res=res.setScale(k+1,RoundingMode.HALF_UP);
                sum=res.doubleValue();
                break;
            }
            t+=2;
            predSum=sum;
        }
        return sum;
    }

    public BigDecimal Arctan_Bd() {
        double eps = Math.pow(10, -k);
        BigDecimal LongEps = new BigDecimal(eps);
        BigDecimal sum = new BigDecimal(x);
        int t = 3;
        BigDecimal predSum = new BigDecimal(x);

        for (int i = 1; ; i++) {
            BigDecimal tempX = BigDecimal.valueOf(Math.pow(x,t));
            tempX = tempX.multiply(BigDecimal.valueOf(Math.pow(-1, i)));
            tempX = tempX.divide(BigDecimal.valueOf(t), k+1, RoundingMode.HALF_UP);
            sum = sum.add(tempX);

            BigDecimal diff = sum.subtract(predSum).abs();
            if (diff.compareTo(LongEps) < 0) {
                sum=sum.setScale(k+1,RoundingMode.HALF_UP);
                break;
            }

            t += 2;
            predSum = sum;
        }

        return sum;
    }
}
