class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length()==0) return true;
        int i = 0, j = 0;
    
        while(j<t.length()){
            if(s.length()<=i) return true;

            while(j<t.length() && 
            t.charAt(j)!=s.charAt(i)) j++;
            
            if(j<t.length() && t.charAt(j)==s.charAt(i)){
                i++;
                j++;
            }

        }

        return (i==s.length());
    }
}