class Solution {
    public int countMajoritySubarrays(int[] nums, int t) {
        int ans = 0, i=0;
        int n = nums.length;
        for(; i<n; ){
            int count = 0;
            int j=i;
            for(; j<n; ){
                if(nums[j]==t) count++;
                if(2*count>(j-i+1)) ans++;
                j++;
            }
            i++;
        }
        return ans;
    }
}