//import question.linklist.ListNode;


public class SwapPairs24 {



     //这种方法不太优雅，可以用更加优雅的递归
    public ListNode swapPairs(ListNode head) {

        ListNode resultHead = head.next;

        ListNode tempHead =head;
        ListNode tempTail = null;
//        ListNode tempTail =null;
        while (tempHead!=null){

            ListNode tempNext = tempHead.next;
            if(tempNext ==null) break;
            ListNode nextNextTail = tempNext.next;
            tempNext.next = tempHead;
            tempHead.next = nextNextTail;
            if(tempTail!=null){
                tempTail.next = tempNext;
            }
            tempTail=tempHead;

            tempHead = nextNextTail;
        }
        return resultHead;
    }

    public static void main(String[] args) {
        SwapPairs24 swapPairs24 = new SwapPairs24();

        ListNode of = ListNode.of("[1,2,3,4,5,6,7,8]");

        System.out.println(swapPairs24.swapPairs(of));

    }

//    public ListNode reverseKGroup(ListNode node,int n){
//        ListNode resultHead = null;
//        ListNode tempHead = node;
//        ListNode tempTail = null;
//        while (tempHead!=null){
//            Group group = reverseKGroupInner(tempHead, n);
//            if(resultHead == null){
//                resultHead = group.head;
//            }
//            if (tempTail == null) {
//                tempTail = group.tempHead;
//            } else {
//                tempTail.next = group.head;
//                tempTail = group.tempHead;
//            }
//            tempHead = group.nextPoint;
//        }
//        return resultHead;
//    }
//
////    public Group reverseKGroupInner(ListNode node,int n){
////
////    }
//
//
//    static class Group{
//       public ListNode head;
//       public ListNode tempHead;
//       public ListNode nextPoint;
//
//        public Group(ListNode head, ListNode tempHead, ListNode nextPoint) {
//            this.head = head;
//            this.tempHead = tempHead;
//            this.nextPoint = nextPoint;
//        }
//    }
//
//
}
