class Solution {
    public int countMajoritySubarrays(int[] nums, int t) {
        int ans = 0;
        int n = nums.length;
        for(int i=0; i<n; i++){
            int count = 0;
            int j=i;
            for(; j<n; j++){
                if(nums[j]==t) count++;
                if(2*count>(j-i+1)) ans++;
            }
        }
        return ans;
    }
}