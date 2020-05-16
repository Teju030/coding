// print numbers from n to 1 without using loops
#include <iostream>

using namespace std;

void nToOne( int n)
{
    if ( n < 1 )
        return;
    cout << n << " ";
    nToOne(n-1);
}

void oneToN( int n )
{
    if ( n < 1 )
        return;

    oneToN( n-1);
    cout << n << " ";

}
int main()
{
    nToOne(5);
    cout << endl;
    oneToN(5);
}