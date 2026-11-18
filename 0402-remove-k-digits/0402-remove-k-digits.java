class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        int n = num.length();
        for(int i=0; i<n; i++){
            char c = num.charAt(i);
            while(!st.isEmpty() && k>0 && st.peek() > c){
                st.pop();
                k=k-1;
            }
            st.push(c);
        }
        while(k>0){
            st.pop();
            k--;
        }


        StringBuilder res=new StringBuilder();

        while(!st.isEmpty()){
            res.append(st.pop());
        }

        res.reverse();

        int i = 0;

        while (i < res.length() && res.charAt(i) == '0') {
            i++;
        }

        res.delete(0, i);

        if (res.length() == 0) {
            return "0";
        }

        return res.toString();
    }
}