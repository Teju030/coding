class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        generate(n, n, new char[2*n], 0, result);
        return result;
        
    }
    public void generate(int open, int close, char []sofar, int pos, List<String> result){
        //System.out.println("Open : " + open + " Close: " + close + " sofar : " + Arrays.toString(sofar));
        if(open == 0 && close == 0){
            result.add(new String(sofar));
            return;
        }
        if(open == 0){
            sofar[pos] = ')';
            generate(open, close-1, sofar, pos+1, result);
        }
        if(open > 0 && open < close){
            sofar[pos] = ')';
            generate(open, close-1, sofar, pos+1, result);
            sofar[pos] = '(';
            generate(open-1 , close, sofar, pos+1, result);
        }
        if(open == close){
            sofar[pos] = '(';
            generate(open-1 , close, sofar, pos+1, result);
        }
        
    }
}