/**
 * 整体思路：cur指针指向要操作的节点的前一个节点
 *
 * 代码实现：
 * dummyhead->next = head
 * cur = dummyhead
 * while(cur->next != null && cur->next->next != null){
 *     temp = cur->next
 *     temp1 = cur->next->next->next
 *     cur->next = cur->next->next;
 *     cur->next = temp
 *     temp->next = temp1
 *     cur = cur->next->next
 * }
 * return dummyhead->next;
 **/

/**
 * 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 **/
package ListNode;

public class swapPairs {
    //递归版本
    public ListNode swapPairs(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode next = head.next;
        ListNode newNode = swapPairs(next.next);
        next.next = head;
        head.next = newNode;

        return next;
    }

    public ListNode swapParis1(ListNode head){
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;
        ListNode cur = dummyhead;
        ListNode temp;
        ListNode firstnode;
        ListNode secondnode;
        while(cur.next != null && cur.next.next != null){
            temp = cur.next.next.next;
            firstnode = cur.next;
            secondnode = cur.next.next;
            cur.next = secondnode;
            secondnode.next = cur.next.next;
            firstnode.next = temp;
            cur = firstnode;
        }
        return dummyhead.next;
    }

}
