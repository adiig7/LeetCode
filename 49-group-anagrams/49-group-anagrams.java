class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mp = new HashMap();
        for(String str : strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String temp = String.valueOf(ch);
            if(!mp.containsKey(temp))   mp.put(temp, new ArrayList<>());
            mp.get(temp).add(str);
        }
        return new ArrayList<>(mp.values());
    }
}