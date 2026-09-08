class Solution {
    public int countCommas(int n) {
        int count = 0;
        if(n>999 && n<=999_999){ // only 1 comas
            count = n-999;
        }
        return count;
    }
}