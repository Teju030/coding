// remove duplicates from the array

#include <iostream>

using namespace std;

void removeduplicates( int a[], int size)
{
    int c = 0;

    for(int i=1; i<size ; i++)
    {
        if(a[c] != a[i])
        {
            a[c+1] = a[i];
            c++;
        }
    }
    
    for( int j =0 ; j<size ; j++ )
    {
        cout << a[j] << " ";
    }
    cout << endl;

    cout << c;

}

int main()
{
    int a[] = {10,10,10,20, 30, 30, 40, 50};
    removeduplicates(a, sizeof(a)/sizeof(int) );
}