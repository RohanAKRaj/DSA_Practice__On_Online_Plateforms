class Solution {

    public static int helper(int i, int j, String s, String t, int dp[][]){
        // base case!
        if(j>=t.length()) return 1;
        if(i>=s.length() && j<t.length()) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        int pick = 0, skip = 0;
        if(s.charAt(i)!=t.charAt(j)){
        // if char at i and j are not equal;
            skip = helper(i+1, j, s, t, dp);
        } 
        else{
        //char at i and j are equal
            pick = helper(i+1, j+1, s, t, dp);
            skip = helper(i+1, j, s, t, dp);
        }

        return dp[i][j] = pick+skip;
    }

    public int numDistinct(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        if(slen==tlen){
            return s.equals(t)? 1:0;
        }
        if(tlen>slen) return 0;

        int [][] dp = new int[slen+1][tlen+1];
        for(int[] i: dp){
            Arrays.fill(i,-1);
        }
        return helper(0,0,s,t, dp);
    }
}