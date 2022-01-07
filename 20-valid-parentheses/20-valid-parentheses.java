class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack();
        for(int i = 0; i < s.length(); i++){
            char sub = s.charAt(i);
            if(sub == '(' || sub == '{' || sub == '[')
                st.push(sub);
            else if(st.size() == 0) return false;
            else if(sub == ']' && st.pop() != '[')  return false;
            else if(sub == '}' && st.pop() != '{')  return false;
            else if(sub == ')' && st.pop() != '(')  return false;
        }
        return st.size() == 0;
    }
}