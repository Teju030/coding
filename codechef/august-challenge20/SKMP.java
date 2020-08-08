import java.util.*;

class SKMP
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0)
        {
            String str = sc.next();
            String p = sc.next();

            int []freq = new int[26];

            for(int i =0; i<str.length(); i++)
            {
                int c = str.charAt(i) - 'a';
                freq[c]++;
            }
            for(int i = 0; i<p.length(); i++)
            {
                int c = p.charAt(i) - 'a';
                freq[c]--;
            }
            int first = p.charAt(0) - 'a';
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i<=first; i++)
            {
                char c = (char)('a' + i);
                while(freq[i] > 0)
                {
                    sb.append(c);
                    freq[i]--;
                }
            }
            // apend pattern 
            sb.append(p);
            for(int i = first+1; i<freq.length; i++)
            {
                char c = (char)('a' + i);
                while(freq[i] > 0)
                {
                    sb.append(c);
                    freq[i]--;
                }
            }
            System.out.println(sb);
        }
    }
}

