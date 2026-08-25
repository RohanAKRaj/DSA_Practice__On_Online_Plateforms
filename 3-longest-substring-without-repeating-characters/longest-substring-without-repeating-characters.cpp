class Solution {

public:

    int lengthOfLongestSubstring(string s) {
        if(s.size()==0) return 0;
        unordered_set<int> hs;
        int maxLen = 1;
        int curr = 0;
        
        for(int i=0; i<s.size(); i++){
            int curr_ch = s[i];

            //expanding the window!
            if(!hs.contains(curr_ch)){
                hs.insert(curr_ch);
                curr++;
                if(maxLen<curr) maxLen = curr;
            }

            //srinking the window!
            else{
                int j = i-curr;
                while(s[j]!=curr_ch){
                    hs.erase(s[j]);
                    curr--;
                    j++;
                }
            }
        }
        return maxLen;
    }

};