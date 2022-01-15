class Solution {
    public String countAndSay(int n) {
        if(n == 1)  return "1";
        if(n == 2)  return "11";
        String res = "11";
        for(int i = 3; i <= n; i++){
            String temp = "";
            res += "&";
            int count = 1;
            for(int j = 1; j < res.length(); j++){
                if(res.charAt(j) != res.charAt(j-1)){
                    temp = temp + String.valueOf(count);
                    temp += res.charAt(j-1);
                    count = 1;
                }else
                    count++;
            }
            res = temp;
        }
        return res;
    }
}