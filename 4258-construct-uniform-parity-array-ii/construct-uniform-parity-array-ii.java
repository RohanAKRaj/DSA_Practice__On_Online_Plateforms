class Solution {
    public boolean uniformArray(int[] nums1) {
        int even = 0;
        int odd = 0;
        int minE = Integer.MAX_VALUE;
        int minO = Integer.MAX_VALUE;
        int n = nums1.length;

        for(int i : nums1){
            if(i%2==0){
                even++;
                if(i<minE) minE=i;
            }
            else{
                odd++;
                if(i<minO) minO=i;
            }
        }

        if(n==odd || n==even) return true;

        boolean allOdd = true;
        // trying to make all odd;
        for(int i : nums1){
            if(i%2==0){ // i is even;
                int temp = i-minO;
                if(temp<1){
                    allOdd = false;
                    break;
                }
            }
        }
        return allOdd;

        // boolean allEven = true;
        // //tring to make all even;
        // for(int i : nums1){
        //     if(i%2!=0){
        //         if(i-minO)
        //     }
        // }
    }
}