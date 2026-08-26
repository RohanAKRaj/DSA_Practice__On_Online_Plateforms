class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int ones = 0;
        int n = s.length();
        int st = 0, end=0;
        boolean first = true;

        for(end=0; end<n; end++){
            char ch = s.charAt(end);
            if(ones==0 && ch=='0') continue;
            if(ch=='1'){
                if(first){
                    st = end;
                    first = false;
                }
                ones++;
                if(ones==k) break;
            }
        }

        if(end>=n) return "";

        int minIdx[] = {st, end};
    
        while(end<n){

            // moving st only if it is valid!
            while(ones==k){
                if(s.charAt(st)=='0'){
                    st++;
                }
                else if(s.charAt(st)=='1'){
                    int curr = end-st+1;
                    int minLen = minIdx[1]-minIdx[0]+1;

                    // Case 1: minLen string is greater then curr string length;
                    if(curr<minLen){
                        minIdx[0] = st;
                        minIdx[1] = end;
                    }

                    // Case 2: both length is equal, so updating minLen only if it is lexographyically greater
                    else if(curr==minLen){
                        String temp = s.substring(st,end+1);
                        String ans = s.substring(minIdx[0],minIdx[1]+1);
                        if(ans.compareTo(temp)>0){ // ans is greater, otherwise skip
                            minIdx[0] = st;
                            minIdx[1] = end;
                        }
                    }

                    ones--;
                    st++;
                }
            }

            // moving i to make substring valid!
            end++;
            while(end<n && ones<k){
                if(s.charAt(end)=='1') ones++;
                else end++;
            }
        }

        return s.substring(minIdx[0],minIdx[1]+1);
    }
}