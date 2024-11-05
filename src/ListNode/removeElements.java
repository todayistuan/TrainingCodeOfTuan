package ListNode;

/**
 * 两种方法：
 * 判断是不是头节点（1.不是：next——>head
 *               2.是：head = head.next）
 * 可有一个统一的方法：创建一个虚拟头节点，直接用next
 *
 * 原链表删除元素：
 * while（head != null && head->val == target){
 *     head = head->next
 * }
 * cur = head;
 * while( cur != null && cur->next != null){
 *     if(cur->next == target){
 *         cur->next = cur->next->next
 *     }
 *     else{
 *         cur = cur->next
 *     }
 * }
 * return head;
 *
 * 使用虚拟头节点：
 * dummyhead = new();
 * dummyhead->next = head
 * cur = dummyhead
 *
 * while(cur->next != null){
 *     if(cur->next->val == target){
 *         cur->next = cur->next->next
 *     }
 *     else{
 *         cur = cur->next
 *     }
 * }
 * return dummyhead->next
 **/

/**
 * 203.给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 **/


public class removeElements {
    public ListNode removeElements(ListNode head, int val){
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode cur = dummy;
        while(cur.next != null){
            if(cur.next.val == val){
                cur.next = cur.next.next;
            }
            else{
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
