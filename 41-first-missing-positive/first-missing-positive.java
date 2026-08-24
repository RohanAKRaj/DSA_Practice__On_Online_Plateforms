class Solution {
    public int firstMissingPositive(int[] nums) {

        int n = nums.length;

        int i = 0;

        while (i < n) {

            if (nums[i] <= 0 || nums[i] > n) {
                i++;
            }
            else {

                int correctIndex = nums[i] - 1;

                if (nums[correctIndex] == nums[i]) {
                    i++;
                }
                else {
                    int temp = nums[correctIndex];
                    nums[correctIndex] = nums[i];
                    nums[i] = temp;
                }
            }
        }

        for (int j = 0; j < n; j++) {
            if (nums[j] != j + 1) {
                return j + 1;
            }
        }

        return n + 1;
    }
}