// given a rope of length  n 
// given cuts values a,b,c 
// cut the rope into max pieces using the given cuts values

#include <iostream>
using namespace std;

int maxcuts( int n, int a, int b , int c)
{
    if ( n < 0)
    {
        return -1;
    }
    if ( n == 0 )
        return 0;

    int num = max( max(maxcuts( n-a, a, b,c ), maxcuts( n-b, a, b, c)), maxcuts( n-c, a, b, c));

    if( num == -1) return -1;
    return num+1;
}

int main()
{
    cout << maxcuts(5, 2, 1, 5);
}