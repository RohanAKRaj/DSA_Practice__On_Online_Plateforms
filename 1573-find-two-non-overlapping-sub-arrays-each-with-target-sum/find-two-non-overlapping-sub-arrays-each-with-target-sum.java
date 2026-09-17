class Solution {
    public int minSumOfLengths(int[] arr, int t) {
        int n = arr.length;
        int inf = n+1;

        int [] best = new int[n];
        Arrays.fill(best,inf);

        int left = 0;
        int sum = 0;
        int ans = inf;
        int minPrev = inf;

        for(int i=0; i<n; i++){
            sum+=arr[i];

            while(sum>t){
                sum-=arr[left++];
            }

            //Carry forward the best previous subarray
            if(i>0) best[i] = best[i-1];

            if(sum==t){
                int len = i-left+1;

                // Any previous subArray ending before left;
                // is non overlapping with [left, i]
                if(left>0 && best[left-1]!=inf){
                    ans = Math.min(ans, len+best[left-1]);
                }

                best[i] = Math.min(best[i],len);
            }
        }
        return ans==inf?-1:ans;
    }

}