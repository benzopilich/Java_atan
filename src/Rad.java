public class Rad {
    private int k;
    private double x;
    public Rad(double x1,int k1)
    {
        this.k=k1;
        this.x=x1;
    }
    public double Arctan(){
        double eps = Math.pow(10,-k);
        double sum = x;
        int t=3;
        double predSum=x;
        for(int i=1; ;i++)
        {
            sum+=Math.pow(-1,i)*Math.pow(x,t)/t;
            if(Math.abs(sum-predSum)<eps) {
                break;
            }
            t+=2;
            predSum=sum;
        }
        return sum;
    }
}
