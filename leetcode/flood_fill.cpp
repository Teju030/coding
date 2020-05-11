// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3326/

#include <iostream>
#include <vector>

using namespace std;

class Solution {
private:
    int sr = 0, sc = 0, scolor = 0;
    int ROW =0 , COL = 0;
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        this->sr = sr;
        this->sc = sc;
        this-> scolor = image[sr][sc];
        this-> ROW = image.size();
        this-> COL  = image[0].size();
        image[sr][sc] = -1;
        fillColors(image, sr, sc);
        return replace_scolor(image, newColor);
        
    }

    void fillColors(vector<vector<int>>& image, int r, int c)
    { 
        //cout <<"\n Fill Colors" << r << " "<< c;
        // check left  r c-1
        if( isValid(r,c-1) && image[r][c-1] == scolor)
        {
            image[r][c-1] = -1;
            fillColors(image, r, c-1);
        }
        // check Up r-1 c
        if( isValid(r-1,c) && image[r-1][c] == scolor)
        {
            image[r-1][c] = -1;
            fillColors(image, r-1, c);
        }
        // check right r c+1
        if( isValid(r,c+1) && image[r][c+1] == scolor)
        {
            image[r][c+1] = -1;
            fillColors(image, r, c+1);
        }
        // check down r+1 c
        if( isValid(r+1,c) && image[r+1][c] == scolor)
        {
            image[r+1][c] = -1;
            fillColors(image, r+1, c);
        }

        return;
    }
    bool isValid(int r, int c)
    {
        
        if( r < 0 || c < 0 || r >= ROW || c >= COL)
            return 0;
        return 1;
    }
    vector<vector<int>> replace_scolor(vector<vector<int>>& vec, int ncolor)
    {
        for (int i = 0; i < vec.size(); i++) { 
            for (int j = 0; j < vec[i].size(); j++) 
            {
                if ( vec[i][j] == -1 )
                    vec[i][j] = ncolor;
            }
        }
        return vec;
    }
};

void print_vector(vector<vector<int>>& vec)
{
    for (int i = 0; i < vec.size(); i++) { 
        for (int j = 0; j < vec[i].size(); j++) 
            cout << vec[i][j] << " ";

        cout << endl; 
    } 
}

int main()
{
    Solution s;
    vector<vector<int>> image = {
        { 1, 1, 0, 1},
        { 1, 0, 1, 1},
        { 1, 1, 1, 0},
        { 0, 0, 0, 1}
    };
    // {
    //     { 1, 1, 1},
    //     { 1, 1, 0},
    //     { 1, 0, 1}
    // };
    s.floodFill(image, 2, 1, 2);
    print_vector(image);
    
}