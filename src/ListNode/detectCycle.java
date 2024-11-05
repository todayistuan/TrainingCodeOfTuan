/**
 * 判断环：
 * 快慢指针相遇说明有环
 * 快指针每次2个节点 慢指针每次1个节点
 *
 * 找出环的入口：
 * 相遇后
 * 起始到入口：x
 * 入口到相遇：y
 * 相遇到入口：z
 * slow=x+y
 * fast=x+y+n(y+z)
 *
 * 2(x+y)=x+y+n(y+z)
 * x+y=n(y+z) (n>=1)
 * x = n(y+z)-y
 * x = (n-1)(y+z)+z
 * x=z (n=1)
 *
 * 代码实现：
 * fast = head
 * slow = head
 * while(fast != null && fast->next != null){
 *     fast = fast->next->next
 *     slow = slow->next
 *     if(fast == slow){
 *         index1 = fast
 *         index2 = head
 *         while(index1 != index2){
 *             index1 = index1->next
 *             index2 = index2->next
 *         }
 *         return index1
 *     }
 *     return null
 * }
 **/

/**
 * 142.环形链表II 题意： 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 **/

package ListNode;

public class detectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                ListNode index1 = fast;
                ListNode index2 = head;
                while(index1 != index2){
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}
