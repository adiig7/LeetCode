public class Pair{
    char ch;
    int freq;
    public Pair(char ch, int freq){
        this.ch = ch;
        this.freq = freq;
    }
}
class Solution {
    public String reorganizeString(String s) {
        int[] map = new int[26];
        for(int i = 0; i < s.length(); i++)
            map[s.charAt(i) - 'a']++;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (b.freq - a.freq));
        for(int i = 0; i < 26; i++){
            if(map[i] > 0)
                pq.add(new Pair((char)( i + 'a'), map[i]));
        }
        String res = "";
        Pair block = pq.poll();
        res += block.ch;
        block.freq--;
        while(!pq.isEmpty()){
            Pair temp = pq.poll();
            res += temp.ch;
            temp.freq--;
            if(block.freq > 0)
                pq.add(block);
            block = temp;
        }
        if(block.freq > 0)
            res = "";
        return res;
    }
}