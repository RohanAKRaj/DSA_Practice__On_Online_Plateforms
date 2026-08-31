class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int firstIdx = -1;
        int lastIdx = -1;
        ListNode prev = head;
        ListNode curr = prev.next;
        ListNode ford = curr.next;
        int min = Integer.MAX_VALUE;
        int idx = 2;
        boolean first = true;

        while(ford!=null){
            int a = prev.val;
            int b = curr.val;
            int c = ford.val;

            if((b>a)&&(b>c) || (b<a)&&(b<c)){ // critical point!
            
                if(firstIdx==-1) firstIdx = idx; // 1st CP
                else if(lastIdx==-1) lastIdx = idx; // 2nd CP

                if(first && firstIdx!=-1 && lastIdx!=-1){
                    min = lastIdx-firstIdx; // 1st min
                    first = false;
                }
                else if(firstIdx!=-1 && lastIdx!=-1){ // both have!
                    int tempMin = idx-lastIdx;
                    if(min>tempMin) min = tempMin;
                    lastIdx = idx;
                }
            }

            prev = curr;
            curr = ford;
            ford = ford.next;
            idx++;
        }

        int max = -1;
        if(lastIdx==-1){ // only one critical point
            return new int[]{-1, -1};
        }else{
            max = lastIdx-firstIdx;
        }

        return new int[]{min, max};
    }
}