class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n==1) return true;
        if(nums[0]==0) return false;
        int maxReach = 0;

        for(int i=0; i<n-1; i++){
            if(i>maxReach) break;
            int greedy = 0;
            greedy = i+nums[i];
            if(greedy>maxReach) maxReach = greedy;
            if(maxReach >= n-1) return true;
        }

        return false;
    }
}