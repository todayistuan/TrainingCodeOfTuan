package ListNode;
/**
 * 双指针写法：
 * 头节点指针cur cur前一位指针pre
 * cur = head;
 * pre = null;
 * while(cur [!= null]){ //直接写while(cur)一个意思
 *     temp = cur->next;
 *     cur->next = pre;
 *     pre = cur;
 *     cur = temp;
 * }
 *
 * return pre;
 *
 **/



/**
 * 206.翻转链表 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 **/
public class reverseList {
    //双指针
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        ListNode temp = null;
        while(cur != null){
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    //递归
    public ListNode reverseList1(ListNode head){
        return reverse(null,head);
    }

    private ListNode reverse(ListNode prev, ListNode cur){
        if(cur == null){
            return prev;
        }
        ListNode temp = null;
        temp = cur.next;
        cur.next = prev;
        return reverse(cur, temp);
    }
}
