import java.util.*;

class SSCRIPT{
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            sc.nextLine();
            char  []line = sc.nextLine().toCharArray();
           // System.out.println("Input :"+ Arrays.toString(line));
            int i = 0;
            boolean flag = false;
            while(i < n)
            {
                if(line[i] == '*')
                {
                    int j = i;
                    int cnt = 0;
                    while( j < n && line[j] == '*')
                    {
                        cnt ++;
                        if (cnt == k)
                        {
                            flag = true;
                            break;
                        }
                        j++;
                    }
                    if (!flag){
                        i = j;
                    }                
                }
                if (flag)
                {
                    break;
                }
                i++;
            }
            if(flag)
            {
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}