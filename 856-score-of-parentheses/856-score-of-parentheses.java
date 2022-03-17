class Solution {
    public int scoreOfParentheses(String s) {
        LinkedList<Integer> st = new LinkedList<>();
        st.addFirst(0);
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') st.addFirst(0);
            else st.push(Math.max(2 * st.removeFirst(), 1) + st.removeFirst());
        }
        return st.pop();
    }
}