

class MergeTwoLists {
    //合并两个有序列表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 ==null){
            return l2;
        }else if(l2 == null){
            return l1;
        }
         ListNode tempHead = null;
        if (l1.val > l2.val) {
            tempHead = l2;
            l2 = l2.next;
        } else {
            tempHead = l1;
            l1 = l1.next;
        }
        ListNode head = tempHead;
        while( l1!=null && l2!=null){
            if (l1.val > l2.val) {
                tempHead.next = l2;
                l2 = l2.next;
            } else {
                tempHead.next = l1;
                l1 = l1.next;
            }
            tempHead = tempHead.next;
        }
        if(l1 == null){
            tempHead.next = l2;
        }else{
            tempHead.next = l1;
        }
        return head;

    }
}