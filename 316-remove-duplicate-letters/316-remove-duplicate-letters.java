class Solution{
public String removeDuplicateLetters(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        int[] count = new int[26];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
        }
        
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            while(!stack.isEmpty() && !stack.contains(ch) && ch < stack.peek() && count[stack.peek()-'a'] > 0)
               stack.pop(); 
            
            if(!stack.contains(ch))stack.push(ch);
            count[ch-'a']--;
        }
             
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        
        sb.reverse();
        return sb.toString();
}
    }