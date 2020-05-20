// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3333/

#include <iostream>
#include <vector>
#include <map>

using namespace std;

class Solution {

    int temp[26] = {0};

    // length of query string and input string 
    int len_q = 0, len_in = 0;

public:
    
    bool checkInclusion(string s1, string s2)
    {
        len_q = s1.length();
        len_in = s2.length();
        
        // query string length must be <=  input string length
        if( len_q > len_in )
            return false;

        // calculate the letters count in s1 
        for( char c: s1)
        {
            temp[ c-97 ] +=1;
        }
        // substract count from temp frequecy
        for (int i = 0; i < len_q ; i++)
        {
            temp[ s2[i] - 97 ] -=1;
        }
        // Calculate number of zeros 
        int num_zeros = num_of_zeros();
        int start = 0;
        int end = len_q;

        while (end < len_in && num_zeros < 26)
        {
            // from left we exlude that letter, therefore increase the count 
            temp[ s2[ start ] - 97 ] += 1 ;
            // from right we include new letter, therefore reduce the frequency of letter
            temp[ s2[ end ] - 97 ] -= 1;
            // then calculate number of 0s
            num_zeros = num_of_zeros();
            start++;
            end++;
        }
        
        if (num_zeros == 26 )
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    int num_of_zeros()
    {
        int sum = 0;
        for (int i = 0; i < 26; i++)
        {
            if (temp[i] == 0)
            {
                sum++;
            }
            
        }
        return sum;
    }
};

int main()
{
    Solution s;
    /*
    "hello"
    "ooolleoooleh"
"abc"
"bbbca"
    "adc"
    "dcda"
     */
    string in1 = "abc";
    string in2 = "bbbca";
    if (s.checkInclusion(in1, in2 ))
    {
        cout << "True";
    }
    else  cout << "False";
}

 