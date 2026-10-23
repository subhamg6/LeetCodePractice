class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        genParan(0, 0, n, "", res);
        return res;
    }
    void genParan(int open, int close, int n, String tmp, List<String> res){
        if(open == n && close == n){
            res.add(tmp);
            return;
        }
        if(open<n){
            genParan(open+1, close, n, tmp + "(", res);
        }
        if(close<open){
            genParan(open, close+1, n, tmp + ")", res);
        }
        return;
    }
}