public class CycledLL {
    //func that checks for intersection of two pointers
    public ListNode intersection(ListNode head) {
        //set both pointers to head of LL
        ListNode slow = head;
        ListNode fast = head;
        //check if LL has at least 2 elements
        while (fast != null & fast.next!= null) {
            //move slow pointer by 1 index
            slow = slow.next;
            //move fast pointer by 2 indices
            fast = fast.next.next;
            //check if both pointers point to the same position
            if (slow == fast) {
                //return position of intersection
                return slow;
            }
        }
        //if not, return null (no cycle found)
        return null;
    }
    public ListNode cycle(ListNode head) {
        //check if there are at least 2 elements in LL
        if (head == null || head.next == null) {
            return null;
        }
        ListNode intersect = intersection(head);
        //check if there is a cycle found
        if (intersect == null) {
            return null;
        }
        //if so, set top to head
        ListNode top = head;
        //check index where both pointers are pointing at
        while (intersect != top) {
            top = top.next;
            intersect = intersect.next;
        }
        return top;
    }
}
