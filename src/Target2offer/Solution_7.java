package Target2offer;


import java.util.HashMap;

public class Solution_7 {

    // Definition for binary tree
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public HashMap<Integer,Integer> inmap =new HashMap<>();

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        for (int i = 0 ; i<in.length;i++){
            inmap.put(in[i],i);
        }
        if ((pre.length==0) || (in.length==0))
            return null;
        return BuildTree(pre,0,pre.length-1,0);

    }
    public TreeNode BuildTree(int[] pre,int preStart, int preEnd, int inStart){
        if (preStart>preEnd)
            return null;
        TreeNode root = new TreeNode(pre[preStart]);
        int Index = inmap.get(pre[preStart]);
        int lefiSize =Index - inStart;
        root.left = BuildTree(pre,preStart+1,preStart+lefiSize,inStart);
        root.right = BuildTree(pre,preStart+1+lefiSize,preEnd,Index+1);
        return root;
    }

    public static void main(String[] args) {
        int predata[] = {1,2,4,7,3,5,6,8};
        int indata[] = {4,7,2,1,5,3,8,6};
        Solution_7 solution_7 = new Solution_7();
        TreeNode root = solution_7.reConstructBinaryTree(predata,indata);
        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
    }

}
