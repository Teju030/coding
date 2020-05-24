#include <iostream>
#include <map>

using namespace std;

class Solution {
public:
    int numJewelsInStones(string J, string S) {
        map<char,int> stones;
        int total = 0;
        
        for( char c: S)
        {
            stones[c]++;
        }
        for( char c : J)
        {
            if ( stones.count(c)) total+= stones[c];
        }
        return total;
    }
};