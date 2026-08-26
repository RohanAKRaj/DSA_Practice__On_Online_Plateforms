class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        HashSet<Integer> hs = new HashSet<>();

        long sum = 0, max = 0;

        int left = 0;

        for(int rt = 0; rt<n; rt++){
            while(hs.contains(nums[rt])){
                hs.remove(nums[left]);
                sum-=nums[left];
                left++;
            }

            hs.add(nums[rt]);
            sum += nums[rt];

            if((rt-left+1)==k){
                if(sum>max) max = sum;
                hs.remove(nums[left]);
                sum-=nums[left];
                left++;
            }
        }
        return max;
    }
}