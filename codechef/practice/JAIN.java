import java.util.*;
// using bit masking approach
class JAIN
{
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            sc.nextLine();

            long freq[] = new long[32];
            for(int i =0; i<n ; i++)
            {
                int mask = 0;
                String dish = sc.nextLine();
                for(char c : dish.toCharArray())
                {
                    if(c == 'a') mask = mask | (1 << 0 );
                    if(c == 'e') mask = mask | (1 << 1 );
                    if(c == 'i') mask = mask | (1 << 2 );
                    if(c == 'o') mask = mask | (1 << 3 );
                    if(c == 'u') mask = mask | (1 << 4 );
                }
                freq[mask]++;
            }
            long total = 0;
            for(int i=1; i < 32; i++)
            {
                for(int j = i+1; j<32 ; j++)
                {
                    if((i|j) == 31)
                        total+= freq[i] * freq[j];
                }
            }

            total += (freq[31] * (freq[31]-1))/2;
            System.out.println(total); 
        }
    }
}