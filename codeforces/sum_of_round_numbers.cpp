// https://codeforces.com/contest/1352/problem/A
#include <iostream>
#include <set>
using namespace std;

void solution()
{
    int num, tot = 0;
    set <int> result;
    cin >> num;
    int rem = 10, d = 10 ;
    int mul = 1;

    while(num >0)
    {
        rem  = num % d;
        if(rem != 0)
        {
            rem *=mul;
            result.insert(rem);
            tot++;
        }
        num /=10;
        mul *=10;
    }
    cout << tot << "\n";
    // cout << "Solution";
    set <int> :: iterator itr;
    for( itr= result.begin(); itr!= result.end(); ++itr)
    {
        cout<< *itr << " ";
    }
    cout << "\n";
}
void testcases()
{
    int t;
    cin >> t;
    while (t-->0)
    {
        solution();
    }

}

int main()
{
    testcases();
}