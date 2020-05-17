// find the sum of subset 

#include <iostream>
using namespace std;


int subsetsum(int s[], int i, int sum)
{
    if( i == 0)
    {
        if ( sum == 0 ) return 1;
        return 0;
    }

    return subsetsum( s , i-1, sum - s[i-1]) + subsetsum(s, i-1, sum);
 
}

int main()
{
    int a[] = { 5, 3, 2, 1 };
    cout<< subsetsum( a, sizeof(a)/sizeof(int) , 5 );
}