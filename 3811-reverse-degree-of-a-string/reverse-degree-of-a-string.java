class Solution {
    public int reverseDegree(String s) {
        int count=0;
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            count+= (26-(ch-'a'))*(i+1);
        }
        return count;
    }
}