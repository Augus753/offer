package niuke;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author atom.hu
 * @version V1.0
 * @Package niuke
 * @date 2020/9/30 21:08
 * @Description TreeSolution
 */
public class TreeSolution {

    /**
     * @param root TreeNode类
     * @return int整型
     */
    public int maxDepth(TreeNode root) {
        // write code here
        if (root == null) {
            return 0;
        }
        return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));
    }

    public int sumNumbers(TreeNode root) {
        return sumNumber(root, 0);
    }

    public int sumNumber(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = 10 * sum + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return sumNumber(root.left, sum) + sumNumber(root.right, sum);
    }

    public static void preOrderTraverse1(TreeNode root) {
        if (root != null) {
            preOrderTraverse1(root.left);
            preOrderTraverse1(root.right);
            System.out.print(root.val + "->");
        }
    }


    /**
     * 二叉树层次遍历
     *
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList <>>
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> result = new ArrayList();
        if (root == null) return result;
        //借助Queue存放每一层的节点
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            ArrayList<Integer> levelResult = new ArrayList();
            for (int i = 0; i < len; i++) {
                TreeNode temp = queue.poll();
                levelResult.add(temp.val);
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
            }
            result.add(levelResult);
        }
        return result;
    }

    /**
     * 二叉树的镜像定义：源二叉树
     * //    	    8
     * //    	   /  \
     * //    	  6   10
     * //    	 / \  / \
     * //    	5  7 9 11
     * //    	镜像二叉树
     * //    	    8
     * //    	   /  \
     * //    	  10   6
     * //    	 / \  / \
     * //    	11 9 7  5
     *
     * @param root
     */
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }
}
