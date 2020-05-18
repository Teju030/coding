#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
struct point
{
    int x, y;
};

bool myComparator( point a, point b)
{
    return ( a.x < b.x);
}

int main()
{
    // arrays
    int arr[] = {10, 20, 5, 8, 2};
    int n  = sizeof(arr)/sizeof(int);
    sort(arr, arr+n);
    for( int a: arr )
    {
        cout << a << " ";
    }
    cout << endl;

    // sort(arr, arr+n, comparator function)
    //  for vector 
    vector<int> v = { 5,7, 2,2,1};
    sort(v.begin(), v.end());
    for( int x: v)
    {
        cout << x << " ";
    }
    cout << endl;
    
    // for struct how sorting works 
    point p[] = {
        { 3, 9}, { 2 ,8}, {1,8}
    };

    sort(p, p+(sizeof(p)/sizeof(point)), myComparator);

    for( auto x: p )
    {
        cout << x.x << " " << x.y << endl;
    }
}