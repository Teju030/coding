#include <iostream>
#include <string>

using namespace std;

void palim( int n )
{
    if ( n < 1)
    {
        return ;
    }
    else
    {
        cout << n << " ";
        palim(n-1);
        cout << n << " ";

    }
    
}

bool palimdrome( string in , int s , int e )
{
    if ( s > e )
        return true;

    if ( in[s] == in[e])
        return palimdrome( in , s+1, e-1);
    return false;
}

int main()
{
    // palim(4);
    string in = "aabbbaaf";
    cout << palimdrome(in , 0, in.size() - 1 );
}