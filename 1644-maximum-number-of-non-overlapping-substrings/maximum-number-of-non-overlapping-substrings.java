class Solution {

    public static int getEnd(int st, String s,HashMap<Character,int[]> map){
        int end = map.get(s.charAt(st))[1];
        for(int i=st; i<=end; i++){
            char ch = s.charAt(i);
            if(map.get(ch)[0]<st) return -1;
            if(map.get(ch)[1]>end) end = map.get(ch)[1];
        }
        return end;
    }

    public List<String> maxNumOfSubstrings(String s) {
        List<String> ans = new ArrayList<>();
        HashMap<Character,int[]> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                map.get(ch)[1] = i;
            }else{
                map.put(ch,new int[]{i,i});
            }
        }

        int subStrStart = -1;
        for(int j=0; j<s.length(); j++){
            char curr = s.charAt(j);

            if(map.get(curr)[0]==j){ // checking if it is its 1st ocr
                int subStrEnd = getEnd(j, s, map);
                if(subStrEnd!=-1){
                    if(subStrStart<subStrEnd) ans.add("");
                    subStrStart = subStrEnd;
                    ans.set(ans.size()-1,s.substring(j,subStrEnd+1));
                }
            }
        }

        return ans;
    }
}