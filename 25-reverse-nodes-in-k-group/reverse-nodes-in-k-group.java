
class Solution {

    public static ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode ford = curr;
        ListNode prev = null;
        while(curr!=null){
            ford = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ford;
        }
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode dummy = new ListNode(-1);
        ListNode ptr = dummy;
        
        while(temp!=null){
            int i=1;
            ListNode nextTail = temp;
        
            for(; i<=k-1 && nextTail!=null; i++){
                nextTail = nextTail.next;
            }

            // not have enough nodes to form another k grp!
            if(nextTail==null){
                ptr.next = temp;
                break;
            }

            ListNode nextHead = nextTail.next;
            nextTail.next = null;
            ptr.next = reverse(temp);
            //final dummy.next =
            while(ptr.next!=null) ptr = ptr.next;
            temp = nextHead;
        }

        return dummy.next;
    }
}