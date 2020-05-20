// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3334/

#include <iostream>
#include <stack>

using namespace std;


class StockSpanner {
public:
    stack<pair<int, int>> s;
     StockSpanner() {
      ios::sync_with_stdio(false);
      cin.tie(0);
    }
    int next(int price) {
        int res = 1;
        while (!s.empty() && s.top().first <= price) {
            res += s.top().second;
            s.pop();
        }
        s.push({price, res});
        return res;
    }
};