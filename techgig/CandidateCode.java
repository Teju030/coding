import java.text.DecimalFormat;
import java.util.Scanner;

    class Pair
    {
        double x1, x2;
        Pair()
        {
            x1 = 0.0;
            x2 = 0.0;
        }
        Pair(double x1, double x2)
        {
            this.x1 = x1;
            this.x2 = x2;
        }
        @Override
        public String toString()
        {
            return "Pair : "+ x1+ " , "+ x2+"\n";
        }
    }
    class Crop
    {
        double ferti;
        double insect;
        double price;
        double total_price(double area)
        {
            return area*price;
        }
        @Override
        public String toString()
        {
            return "Crop : "+ ferti+ " , "+ insect+" , "+ price+"\n";
        }
    }
class CandidateCode {

    //a + b = e and c + d = f
    public  Pair solveSimultaneousEquations(double a, double b, double c, double d, double e, double f) {
        double det = ((a) * (d) - (b) * (c));  //instead of 1/
        double x = ((d) * (e) - (b) * (f)) / det;
        double y = ((a) * (f) - (c) * (e)) / det;
        return new Pair(x,y);
    }
    public String max_profit(double L,double F,double P, Crop wheat, Crop rice) {
        
        Pair intersect = solveSimultaneousEquations(wheat.ferti, rice.ferti, wheat.insect, rice.insect, F, P);
       // System.out.println("intersect"+ intersect);
       
        Pair pointOnY = new Pair();
        pointOnY.x2 = Math.min((F/rice.ferti), (P/rice.insect));
        
        Pair pointOnX = new Pair();
        pointOnX.x1 = Math.min((F/wheat.ferti), (P/wheat.insect));
        Pair res = new Pair();
        
        double max_pro = Double.MIN_VALUE;

        for(Pair temp : new Pair[] {intersect, pointOnY, pointOnX})
        {
            double wp = wheat.total_price(temp.x1);
            double rp = rice.total_price(temp.x2);
            if(wp > max_pro || rp > max_pro)
            {
                res = temp;
                max_pro = Math.max(max_pro, Math.max(wp, rp));
            }
        }
        
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(2);
        return df.format(max_pro) + " " + df.format(res.x1) + " " + df.format(res.x2);

    }

    // Driver method
    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        double L = in.nextInt();

        double F = in.nextInt();

        double P = in.nextInt();
        Crop wheat = new Crop();
        wheat.ferti = in.nextInt();
        wheat.insect = in.nextInt();
        
        Crop rice = new Crop();
        rice.ferti = in.nextInt();
        rice.insect = in.nextInt();

        wheat.price = in.nextInt();

        rice.price = in.nextInt();
       // System.out.println("wheat"+ wheat);
       // System.out.println("rice"+ rice);
        CandidateCode c = new CandidateCode();

        System.out.print(c.max_profit(L, F, P, wheat, rice));
    }
}