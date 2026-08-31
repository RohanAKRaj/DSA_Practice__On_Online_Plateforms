class Solution {

    public int countPrimes(int n) {
        if(n<=1) return 0;
        int count = 0;
        boolean ans [] = new boolean[n];
        Arrays.fill(ans, true);

        for(int i=2;(long)i*i<n; i++){
            
            if(ans[i]){
                for(int j=i*2; j<n; j+=i){ // anything smaller then i*i is already marked false by smaller factor
                    ans[j] = false;
                }
            }
        }

        for(int i=2; i<n; i++){
            if(ans[i]) count++;
        }

        return count;
    }
}