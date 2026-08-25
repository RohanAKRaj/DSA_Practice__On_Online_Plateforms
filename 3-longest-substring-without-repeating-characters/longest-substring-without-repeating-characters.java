class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        HashSet<Character> hs = new HashSet<>();
        int maxLen = 1;
        int curr_len = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(!hs.contains(ch)){
                hs.add(ch);
                curr_len++;
                if(maxLen<curr_len) maxLen = curr_len;
            }else{
                int j = i-curr_len;
                while(s.charAt(j)!=ch){
                    hs.remove(s.charAt(j));
                    curr_len--;
                    j++;
                }
                // hs.clear();
                // hs.add(ch);
                // curr_len = 1;
            }
        }
        if(maxLen<curr_len) maxLen = curr_len;
        return maxLen;
    }
}