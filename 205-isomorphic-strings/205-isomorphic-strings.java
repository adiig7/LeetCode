class Solution {
    public boolean isIsomorphic(String s, String t) {
       HashMap<Character, Character> hm = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char a = s.charAt(i), b = t.charAt(i);
            if(hm.containsKey(a)){
                if(hm.get(a).equals(b))
                    continue;
                else
                    return false;
            }else{
                if(!hm.containsValue(b))
                    hm.put(a, b);
                else
                    return false;
            }
        }
        return true;
    }
}