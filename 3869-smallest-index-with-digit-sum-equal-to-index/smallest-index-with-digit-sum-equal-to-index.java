class Solution {

    public static boolean equal(int a, int b){
        if(b<10 && a==b) return true;
        int sum = 0;
        while(b>0){
            int ld = b%10;
            sum+=ld;
            b/=10;
            if(sum>a) return false;
        }
        return sum==a;
    }

    public int smallestIndex(int[] nums) {
        for(int i=0; i<nums.length; i++){
            if(equal(i,nums[i])) return i;
        }
        return -1;
    }
}