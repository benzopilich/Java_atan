import java.math.BigDecimal;
import java.math.RoundingMode;

public class Rad {
    private int k;
    private BigDecimal x;

    public Rad(BigDecimal x1, int k1) {
        this.k = k1;
        this.x = x1;
    }

    public BigDecimal Arctan() {
        double eps = Math.pow(10, -k);
        BigDecimal LongEps = new BigDecimal(eps);
        BigDecimal sum = x;
        int t = 3;
        BigDecimal predSum = x;

        for (int i = 1; ; i++) {
            BigDecimal tempX = x.pow(t);
            tempX = tempX.multiply(BigDecimal.valueOf(Math.pow(-1, i)));
            tempX = tempX.divide(BigDecimal.valueOf(t), k+1, RoundingMode.HALF_EVEN);
            sum = sum.add(tempX);

            BigDecimal diff = sum.subtract(predSum).abs();
            if (diff.compareTo(LongEps) == -1) {
                break;
            }

            t += 2;
            predSum = sum;
        }

        return sum;
    }
}
