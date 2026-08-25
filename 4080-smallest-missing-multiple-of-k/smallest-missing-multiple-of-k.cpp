class Solution {
public:
    int missingMultiple(vector<int>& nums, int k) {
        int len = (100+k-1)/k +1; // Math.ceilDiv(100,k);
        vector<int> mul(len);
        for(int i=0; i<nums.size(); i++){
            if(nums[i]%k!=0) continue;
            mul[nums[i]/k] = true;
        }

        for(int i=1; i<len; i++){
            if(!mul[i]) return i*k;
        }
        return len*k;
    }
};