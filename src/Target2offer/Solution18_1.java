package Target2offer;

// 题目18-1 删除链表节点
// 给定单向链表的头指针和一个节点指针，定义一个函数在O(1)时间内删除该节点。链表节点与函数的定义如下

// 思路：将后一节点的值复制到当前节点，再删除后一节点。
// 情况：1.要删除的节点不是尾结点。2.链表只有一个节点，删除后头结点设置为null。3.链表有多个节点删除尾结点，只能遍历。

public class Solution18_1 {
    public class ListNode{
        int val;
        ListNode next = null;

        ListNode (int val){
            this.val = val;
        }
    }

    public void DeleteNode(ListNode pListHead, ListNode pToBeDelete){
        if (pToBeDelete.next != null){
            ListNode temp = pToBeDelete.next;
            pToBeDelete.val = temp.val;
            pToBeDelete.next = temp.next;
        }else {
            if (pListHead == pToBeDelete){
                pListHead = null;
            }else {
                ListNode cur = pListHead;
                while (cur.next != pToBeDelete){
                    cur =cur.next;
                }
                cur.next = null;
            }
        }
    }


}
