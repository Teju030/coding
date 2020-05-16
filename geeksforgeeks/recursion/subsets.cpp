// given a string , print all the substr of it 

#include <iostream>
using namespace std;

void substring( string s, string curr, int i)
{
    if ( i == s.length())
    {
        cout << curr << " ";
        return ;
    }
    substring(s, curr, i+1);
    substring(s, curr+s[i], i+1 );
}

int main()
{
    substring("abc", "", 0);
}