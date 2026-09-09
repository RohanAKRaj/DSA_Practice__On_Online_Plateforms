class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=s.length()-1; i>=0; i--){
            char ch = s.charAt(i);
            if(st.isEmpty() || st.peek()!=s.charAt(i)){
                st.push(ch);
            }
            else{
                st.pop();
            }
        }
        StringBuilder result = new StringBuilder();
        while(!st.isEmpty()) {
            result.append(st.pop());
        }
        return result.toString();
    }
}