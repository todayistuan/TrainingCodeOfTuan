package ListNode;
/**
 * 第0个节点：head
 * 第n个节点：cur->next
 * 获取第n个节点的值
 * cur = dummyhead->next;
 * while(n){
 *     cur = cur->next;
 *     n--;
 * }
 * return cur->val;
 *
 * 头部插入节点
 * newnode = new node();
 * newnode->next = dummyhead->next;
 * dummyhead->next = newnode;
 * size++;
 *
 * 尾部插入节点
 * cur = dummyhead;
 * while(cur->next != null){
 *     cur = cur->next;
 * }
 * cur->next = newnode;
 * size++
 *
 * 第n个节点前插入节点
 * cur = dummyhead;
 * while(n){
 *     cur = cur->next;
 *     n--;
 * }
 * newnode->next = cur->next;
 * cur->next = newnode;
 * size++;
 *
 * 删第n个节点
 * cur = dummyhead;
 * while(n){
 *     cur = cur->next;
 *     n--;
 * }
 * cur->next = cur->next->next
 * size--;
 **/

/**
 * 707.设计链表
 * 实现 MyLinkedList 类：
 * MyLinkedList() 初始化 MyLinkedList 对象。
 * int get(int index) 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1 。
 * void addAtHead(int val) 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。
 * void addAtTail(int val) 将一个值为 val 的节点追加到链表中作为链表的最后一个元素。
 * void addAtIndex(int index, int val) 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。如果 index 等于链表的长度，那么该节点会被追加到链表的末尾。如果 index 比长度更大，该节点将 不会插入 到链表中。
 * void deleteAtIndex(int index) 如果下标有效，则删除链表中下标为 index 的节点。
 **/


public class MyLinkedList {
    int size; //size存储链表元素的个数
    ListNode head;

    public MyLinkedList(){
        size = 0;
        head = new ListNode(0);
    }

    //获取第index个节点的数值
    public int get(int index){
        if(index < 0 || index >= size){
            return -1;
        }
        ListNode currentNode = head;
        for(int i = 0; i <= index; i++){
            currentNode = currentNode.next;
        }
        return currentNode.val;
    }

    public void addAtHead(int val){
        ListNode newNode = new ListNode(val);
        newNode.next = head.next;
        head.next = newNode;
        size++;

        //在链表最前面插入一个节点，等价于在第0个元素前添加
        //addAtIndex(0, val);
    }

    public void addAtTail(int val){
        ListNode newNode = new ListNode(val);
        ListNode cur = head;
        while(cur.next != null){
            cur = cur.next;
        }

        cur.next = newNode;
        size++;
        //在链表的最后插入一个节点，等价于在(末尾+1)个元素前添加
        //addAtIndex(size, val)
    }

    public void addAtIndex(int index,int val){
        if(index > size){
            return;
        }
        if(index < 0){
            index = 0;
        }
        size++;

        ListNode pred = head;
        for(int i = 0; i < index; i++){
            pred = pred.next;
        }
        ListNode toAdd = new ListNode(val);
        toAdd.next = pred.next;
        pred.next = toAdd;
    }

    public void deleteAtIndex(int index){
        if(index < 0 || index >= size){
            return;
        }
        size--;

        ListNode pred = head;
        for(int i = 0; i < index; i++){
            pred = pred.next;
        }
        pred.next = pred.next.next;
    }
}
