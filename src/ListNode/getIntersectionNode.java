package ListNode;
/**
 * 面试题 02.07.链表相交
 * 给你两个单链表的头节点 headA 和 headB ，
 * 请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * **/
public class getIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA , ListNode headB){
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0 , lenB = 0;
        while(curA != null){ //求链表A长度
            lenA++;
            curA = curA.next;
        }
        while(curB != null){
            lenB++;
            curB = curB.next;
        }
        curA = headA;
        curB = headB;

        if(lenB > lenA){
            // 1. swap(lenA , lenB)
            int tempLen = lenA;
            lenA = lenB;
            lenB = tempLen;
            // 2. swap(curA , curB)
            ListNode tempNode = curA;
            curA = curB;
            curB = tempNode;
        }
        int gap = lenA - lenB;
        // 让curA和curB在同一起点上(末尾位置对齐)
        while(gap-- > 0) {
            curA = curA.next;
        }
        // 遍历curA和curB，遇到相同直接返回
        while(curA != null){
            if(curA == curB){
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
