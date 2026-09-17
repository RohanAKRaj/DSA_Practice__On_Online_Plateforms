class Solution {
    public boolean findSubarrays(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        int sum = nums[0] + nums[1];
        hs.add(sum);
        for(int i=2; i<nums.length; i++){
           sum+=nums[i]; // window move from left
           sum-=nums[i-2]; // window srink from right;
           if(hs.contains(sum)) return true;
           else hs.add(sum);
        }
        return false;
    }
}