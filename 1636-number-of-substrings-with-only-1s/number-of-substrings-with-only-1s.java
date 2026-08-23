class Solution {
    public int numSub(String s) {
        int n = s.length();
        long res = 0;
        int i=0;
        while(i<n){
            if(s.charAt(i)=='1'){
                int ct = 0;
                int j = 0;
                for(j=i; j<n; j++){
                    if(s.charAt(j)=='1') ct++;
                    else break;
                }
                i=j;
                res+=(long)ct* (ct+1)/2;
            }
            else i++;
        }
        return (int)(res%1_000_000_007);
    }
}