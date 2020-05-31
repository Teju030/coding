/*
Calculate the lexicographic rank of STRING 
S T R I N G
for every char
   tot+= num of smaller char * permutation of remaining positions
res = tot+1

STRING =( 4 x 5! + 4 x 4! + 3 x 3! + 1 x 2! + 1 x 1! ) + 1

Not working solution yet 
Exception to be handled
*/
class Lexicographic 
{
    static int factorial(int n)
    {
        int res = 1;
        for( int i = 1; i <=n; i++)
            res*=i;
        return res;
    }
    static int getRank( String s) 
    {
        int fact = factorial(s.length());
        int len = s.length();
        int rank = 1;
        int count[] = new int[256];
        // Calculate the count of each character in the string
        for( int i =0; i < s.length(); i++)
            count[s.charAt(i)]++;

        // Find the cumulative count
        for( int i =1; i < 256; i++)
        {
            count[i] = count[i]+count[i-1];
        }

        for(int i =0; i <= s.length(); i++)
        {   // number of characters less than the current
            int mul = fact / (len - i);
            rank = rank + count[s.charAt(i) - 1]*mul;
            for( int j = s.charAt(i); j<256; j++)
            {
                count[j]--;
            }
        }
        return rank;
    }
    public static void main(String []args) throws Exception
    {
        String s  = "bda";
        System.out.println(getRank(s));
    }
}