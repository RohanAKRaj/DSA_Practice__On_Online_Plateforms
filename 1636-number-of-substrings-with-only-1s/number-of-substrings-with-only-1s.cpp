class Solution {
public:
    int numSub(string s) {
        int n = s.length();
        long long res = 0;
        int i = 0;
        while(i<n){
            if(s[i]=='1'){
                long long ct = 0;
                while(i<n && s[i]=='1'){
                    i++;
                    ct++;
                }
                res+= ct * (ct+1)/2;
            }
            else i++;
        }
        return (int) (res%1000000007);
    }
};