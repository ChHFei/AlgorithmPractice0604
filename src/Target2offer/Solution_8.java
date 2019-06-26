package Target2offer;

public class Solution_8 {
    //树节点定义
    public class TreeLinkNode{
        int val ;
        TreeLinkNode left = null;
        TreeLinkNode right = null ;
        TreeLinkNode next = null;
        TreeLinkNode(int val){
            this.val = val;
        }
    }


    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null)
            return null;
        //有右孩子，找 右孩子的最左
        //没右孩子，且自己是左孩子返回父节点
        //没右孩子，且自己右孩子，向上找第一个是左孩子的父节点
        if (pNode.right != null) {
            TreeLinkNode temp = pNode.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            return temp;
        } else {
            while (pNode.next != null) {
                TreeLinkNode father = pNode.next;
                if (father.left == pNode) {
                    return father;
                }
                pNode = pNode.next;
            }
            return null;
        }
    }

    public static void main(String[] args) {

    }
}
