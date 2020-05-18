#include <iostream>

using namespace std;

int binary_search( int a[], int s , int l, int element)
{
    if ( s > l)
    {
        return -1;
    }
    
    int mid  = s+ (l-s)/2 ;//(l + s)/2;

    if (a[mid] == element )
    {
        return mid;
    }

    if (a[mid] > element) return binary_search(a, s, mid-1, element);
    if (a[mid] < element) return binary_search(a, mid+1, l, element);
    return -1;
}
int main()
{
    int a[] = { 10, 20, 30, 50, 60, 70};
    cout << binary_search(a, 0, sizeof(a)/sizeof(int), 60) ;
}