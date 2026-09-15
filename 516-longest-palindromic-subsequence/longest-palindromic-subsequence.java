class Solution {

    public static String reverse(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    public static int lps(int i, int j, String s, String r, int[][]dp){
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];

        if(s.charAt(i)==r.charAt(j)){
            return dp[i][j] = 1 + lps(i-1, j-1, s,r, dp);
        }
        else return dp[i][j]=Math.max(lps(i-1, j, s,r, dp),lps(i,j-1,s,r,dp));
    }

    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int [][] dp = new int[len][len];
        for(int [] i: dp) Arrays.fill(i,-1);
        return lps(len-1,len-1,s,reverse(s), dp); 
    }
}