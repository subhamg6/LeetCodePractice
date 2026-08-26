class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        
        for(int i = 0; i < n; i++){
            
            if(!st.isEmpty() && st.peek()==s.charAt(i)){
                st.pop();
            }
            else{
                st.push(s.charAt(i));
            }
        }

        StringBuilder res=new StringBuilder();

        while(!st.isEmpty()){
            res.append(st.pop());
        }
        return res.reverse().toString();
    }
}