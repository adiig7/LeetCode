class Solution {
    public int numSplits(String s) {
        HashMap<Character, Integer> left = new HashMap<>();
        HashMap<Character, Integer> right = new HashMap<>();
        int res = 0;
        
        for(int i = 0; i < s.length(); i++)
            right.put(s.charAt(i), right.getOrDefault(s.charAt(i), 0) + 1);
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            left.put(ch, left.getOrDefault(ch, 0) + 1);
            right.put(ch, right.get(ch) - 1);
            
            if(right.get(ch) == 0)
                right.remove(ch);
            
            if(left.size() == right.size())
                res++;
        }
        return res;
    }
}