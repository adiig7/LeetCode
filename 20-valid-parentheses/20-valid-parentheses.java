class Solution {
    public boolean isValid(String s) {
       Stack<Character> st = new Stack<>();
        if(s.charAt(0) == ']' || s.charAt(0) == '}' || s.charAt(0) == ')')
            return false;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[')
                st.push(ch);
            if(st.size() == 0)  return false;
            else if((ch == ')' && st.pop() != '(') || (ch == '}' && st.pop() != '{') || (ch == ']' && st.pop() != '['))
                return false;
        }
        return st.size() == 0;
    }
}