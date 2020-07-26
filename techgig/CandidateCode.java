import java.text.DecimalFormat;
import java.util.Scanner;

class CandidateCode
{

    String max_profit(double L, double F, double P, double F1, double P1, double F2, double P2, double S1, double S2)
    {
        // wheat
        double wheat_profit = 0;
        double total_wheat_area = 0;

        double rice_profit = 0;
        double total_rice_area = 0;

        double total_profit = 0;
        while(true)
        {
            if((total_rice_area+total_rice_area)== L || P == 0 || L == 0 || F == 0)
                break;
            // get total profit 
            wheat_profit = Math.min(F/F1, P/P1)*S1;
            rice_profit = Math.min(F/F2, P/P2)*S2;
            
            if(wheat_profit > rice_profit)
            {
                // wheat prof is max
                double tmp_wheat_area = Math.min(L, Math.min(F/F1, P/P1));
                L = L - tmp_wheat_area;
                F = F - F1*tmp_wheat_area;
                P = P - P1*tmp_wheat_area;
                total_wheat_area += tmp_wheat_area;
            }
            else
            {
                // rice profit is max
                double tmp_rice_area = Math.min(L, Math.min(F/F2, P/P2));
                L = L - tmp_rice_area;
                F = F - F2*tmp_rice_area;
                P = P - P2*tmp_rice_area;
                total_rice_area += tmp_rice_area;
            }
            // System.out.println(String.format("\nL: %.3f , F: %.3f, P: %.3f", L, F, P));
            // System.out.println(String.format("\n[wheat]\narea: %.3f, profit: %.3f ", total_wheat_area, wheat_profit));
            // System.out.println(String.format("\n[Rice]\narea: %.3f, profit: %.3f ", total_rice_area, rice_profit));
        }
        total_profit = total_wheat_area*S1 + total_rice_area*S2;
        
        return String.format("%.2f %.2f %.2f", total_profit, total_wheat_area, total_rice_area);
    }
    public static void main(String []args)
    {
        Scanner in = new Scanner(System.in);
        double L = in.nextInt();

        double F = in.nextInt();

        double P = in.nextInt();
        
        double F1 = in.nextInt();
        double P1 = in.nextInt();
        
        
        double F2 = in.nextInt();
        double P2 = in.nextInt();

        double S1 = in.nextInt();

        double S2 = in.nextInt();
        CandidateCode c = new CandidateCode();

        System.out.print(c.max_profit(L, F, P, F1, P1, F2, P2, S1, S2));
    }

    
}