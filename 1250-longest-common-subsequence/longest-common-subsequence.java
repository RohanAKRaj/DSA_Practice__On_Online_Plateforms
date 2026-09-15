class Solution {

    public static int lcsMemo(int i, int j, String s1, String s2, int[][] dp){
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)) return dp[i][j] = 1 + lcsMemo(i-1, j-1, s1,s2,dp);
        else{



            return dp[i][j] = Math.max(lcsMemo(i,j-1,s1,s2,dp), lcsMemo(i-1, j, s1,s2, dp));
        }
    }

    public int longestCommonSubsequence(String s1, String s2) {
        int i = s1.length();
        int j = s2.length();
        int [][] dp = new int[i][j];
        for(int [] t : dp ) Arrays.fill(t,-1);

        return lcsMemo(i-1,j-1,s1,s2,dp);
        }
}