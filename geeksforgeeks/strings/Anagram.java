class Anagram
{
    static boolean isAnagram(String a, String b)
    {
        if(a.length() != b.length())
        {
            return false;
        }

        int alpha[] =  new int[256];
        for(int i = 0; i< a.length(); i++)
        {
            char c  = a.charAt(i);
            alpha[c]++;
        }
        for(int i = 0; i< b.length(); i++)
        {
            char c  = b.charAt(i);
            alpha[c]--;
        }

        for(int i=0; i<256 ;i++)
        {
            if(alpha[i] != 0 )
            {
                return false;
            }
        }
        return true;

    }
    public static void main(String []args)
    {
        System.out.println(isAnagram("abdss","sssba"));
    }
}