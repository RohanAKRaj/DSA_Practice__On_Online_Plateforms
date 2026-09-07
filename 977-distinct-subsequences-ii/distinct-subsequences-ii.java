class Solution {
    public int distinctSubseqII(String s) {
        int mod = 1_000_000_007;
        int dp [] = new int[26];
        int total  = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            int currTotal = (total+1-dp[ch-'a'] + mod)%mod;
            total = (total + currTotal)%mod;
            dp[ch-'a'] = (dp[ch-'a'] + currTotal)%mod;
        }
        return total;
    }
}