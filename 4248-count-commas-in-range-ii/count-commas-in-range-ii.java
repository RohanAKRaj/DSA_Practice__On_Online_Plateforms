class Solution {
    public long countCommas(long n) {
        long count = 0;

        long one_comas = 999_000 * 1;
        long two_comas = 999_000_000 * 2;
        long three_comas = 999_000_000_000L * 3;
        long four_comas = 999_000_000_000_000L * 4;

        if(n<=999) return 0;
        if(n>=1000 && n<=999_999){
            count += n-999;
            return count;
        }
        if(n>=1_000_000 && n<=999_999_999){
            count+=(n-999_999)*2 + one_comas;
            return count;
        }
        if(n>=1_000_000_000L && n<=999_999_999_999L){ 
            count+=(n-999_999_999L)*3 + one_comas + two_comas;
            return count;
        }
        if(n>=1_000_000_000_000L && n<=999_999_999_999_999L){
            count+=(n-999_999_999_999L)*4 + one_comas + two_comas + three_comas;
            return count;
        }
        if(n==1_000_000_000_000_000L){
            count+= 5 + one_comas + two_comas + three_comas + four_comas;
            return count;
        }
        return count;
    }
}