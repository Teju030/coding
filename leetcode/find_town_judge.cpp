// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3325/

#include <iostream>
#include <vector>
#include <cstring>
using namespace std;

class Solution {
public:
    int findJudge(int N, vector<vector<int>>& trust) {
        int matrix[N][N];
        memset(matrix, 0, sizeof(matrix)*N*N);
        // for(int i=0; i<N; i++)
        // {
        //     for (int j=0; j<N; j++)
        //     {
        //         matrix[i][j] = 0;
        //     }
        // }
        for(auto i : trust){
            matrix[i[0]-1][i[1]-1] = 1;
        }
        int csum = 0;
        int rsum = 0;
        int judge = -1;
        for( int i=0; i<N; i++)
        {
            rsum = 0 ;
            for(int j=0; j<N; j++)
            {
                rsum+= matrix[i][j];
            }
            if (rsum == 0 )
            {
                //find the column sum 
                csum =0 ;
                for( int k =0; k<N; k++)
                {
                    csum += matrix[k][i];
                }
                if (csum == (N-1))
                {
                    judge = i+1;
                }
                else
                {
                    break;
                }
                
            }
        }
        return judge;
    }
};


int main()
{
    int N = 2;
    Solution s;
    vector<vector<int>> trust = {
        { 1, 2}
    };

    cout << s.findJudge(N, trust);
    
}