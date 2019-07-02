package Target2offer;

// 题目18-2 删除链表中重复的节点
// 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
// 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5

// 关键点：把当前节点前1节点和后面值比当前节点大的节点相连。
// 方法2 考虑递归

import java.util.List;

public class Solution18_2 {
//    public class ListNode{
//        int val;
//        ListNode next;
//
//        ListNode(int val){
//            this.val = val;
//        }
//    }

    // 常规方法
    public ListNode deleteDuplication (ListNode pHead){
        if (pHead == null || pHead.next == null)
            return pHead;
        ListNode cur = pHead;
        ListNode pre = null;
        while (cur != null){
            ListNode curNext = cur.next;
            if (curNext != null && cur.val == curNext.val){

                int value = cur.val;
                while (curNext != null && curNext.val == value ){
                    cur = cur.next;
                    curNext = curNext.next;

                }

                // 如果在头节点就开始重复(pre还没指向)
                if (pHead.val == value){
                    // 如果节点一直重复到尾结点
                    if (curNext == null){
                        pHead = null;
                    }else {
                        cur = curNext;
                        pHead = curNext;
                    }
                }else {
                    cur = curNext;
                    pre.next = cur;
                }
            }else {
                pre = cur;
                cur = cur.next;

            }
        }
        return pHead;
    }

    // 递归方法
    public ListNode deleteDuplication2 (ListNode pHead){
        if (pHead == null || pHead.next == null)
            return pHead;
        ListNode pNext = pHead.next;
        if (pHead.val == pNext.val){
            while (pNext != null && pHead.val == pNext.val){
                pNext = pNext.next;
            }
            return deleteDuplication2(pNext);
        }else {
            pHead.next = deleteDuplication2(pHead.next);
            return pHead;
        }
    }





    public void printList (ListNode pNode){
        while (pNode != null){
            System.out.println(pNode.val);
            pNode = pNode.next;
        }
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(5);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        Solution18_2 solution18_2 = new Solution18_2();
        ListNode pNode = solution18_2.deleteDuplication2(l1);
        solution18_2.printList(pNode);
//        ListNode l5 = l4.next;
////        l5 = null;
//        System.out.println(l5.val);
}



}
