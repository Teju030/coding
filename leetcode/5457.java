class Solution {
    public int numOfSubarrays(int[] arr) {
        boolean [][]odd = new boolean[arr.length][arr.length];
        int num =0;
        if(arr[0]%2 !=0)
        {
            num++;
            odd[0][0] = true;
        }
        for(int i = 0; i<arr.length; i++)
        {
            for(int j = i; j< arr.length; j++)
            {
                if(j==0) continue;
                if(arr[j]%2 !=0)
                {
                    if(odd[i][j-1] == false)
                    {
                        odd[i][j] = true;
                        num++;
                    }
                }
                else
                {
                    if(odd[i][j-1] == true)
                    {
                        odd[i][j] = true;
                        num++;
                    }
                }
            }
            // for(boolean[] t: odd)
            //     System.out.println(Arrays.toString(t));
            // System.out.println();
        }
        return num;
    }
}