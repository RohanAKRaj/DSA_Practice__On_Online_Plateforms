class Solution {
    public String longestCommonPrefix(String[] strs) {
        int i = 0;
        for(; i<strs[0].length(); i++){
            char ch = strs[0].charAt(i);
            
            for(int j=1; j<strs.length; j++){
                if(strs[j].length()<=i || ch!=strs[j].charAt(i)){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
}