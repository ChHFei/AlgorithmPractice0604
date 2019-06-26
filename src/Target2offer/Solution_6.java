package Target2offer;

import java.util.ArrayList;
import java.util.Stack;


//题目6：
//输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。


public class Solution_6 {

    //定义节点
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    //方法1：栈实现
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList<Integer>();
        }
        Stack<Integer> stack = new Stack<>();
        while (listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (!stack.empty()){
            arrayList.add(stack.pop());
        }
        return arrayList;
    }

    //方法2：递归
    public ArrayList<Integer> printListFromTaiToTead2(ListNode listNode){
        ArrayList<Integer> arrayList = new ArrayList<>();
        print(arrayList,listNode);
        return arrayList;
    }
    public void print(ArrayList<Integer> arrayList, ListNode listNode){
        if (listNode != null){
            if (listNode.next != null){
                print(arrayList, listNode.next);
            }
            arrayList.add(listNode.val);
        }
    }
    //方法3：使用头插法




    public static void main(String[] args) {

    }

}


