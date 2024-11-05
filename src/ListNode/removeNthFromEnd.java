/**
 * 思路：
 * 定义快慢指针，快指针先移动n+1步，再快慢一起移动，直到快指针指向空
 *
 * 代码实现：
 * newnode = dummyhead;
 * fast = dummyhead;
 * slow = dummyhead;
 * n++;
 * while( n-- && fast != null){
 *     fast = fast->next;
 *     while(fast != null){
 *         fast = fast->next;
 *         slow = slow->next;
 *     }
 *     slow->next = slow->next->next;
 * }
 * return dummyhead->next;
 **/

/**
 * 19.删除链表的倒数第N个节点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 **/
package ListNode;

public class removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head , int n){
        ListNode dummyhead = new ListNode(0);
        dummyhead.next = head;
        ListNode fastIndex = dummyhead;
        ListNode slowIndex = dummyhead;

        for(int i = 0 ; i <= n ; i++){
            fastIndex = fastIndex.next;
        }
        while(fastIndex != null){
            fastIndex = fastIndex.next;
            slowIndex = slowIndex.next;
        }
        if(slowIndex.next != null){
            slowIndex.next = slowIndex.next.next;
        }
        return dummyhead.next;
    }
}
