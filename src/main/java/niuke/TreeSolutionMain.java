package niuke;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static niuke.TreeSolution.*;

/**
 * @author atom.hu
 * @version V1.0
 * @Package PACKAGE_NAME
 * @date 2020/9/30 21:08
 * @Description niuke.TreeSolutionTest
 * <p>
 * 1、test_maxDepth 二叉树的深度。最大深度是指树的根结点到最远叶子结点的最长路径上结点的数量。
 * <p>
 * 2、sumNumbers:找出根节点到叶子节点的所有路径表示的数字之和.https://www.nowcoder.com/practice/185a87cd29eb42049132aed873273e83?tpId=188&&tqId=35512&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
 * //            这颗二叉树一共有两条路径，
 * //            根节点到叶子节点的路径 1\to 21→2 用数字\ 12 12 代替
 * //            根节点到叶子节点的路径 1\to 31→3 用数字\ 13 13 代替
 * //            所以答案为\ 12+13=25 12+13=25
 * <p>
 * 3、test_levelOrder：二叉树层次遍历
 * <p>
 * 4、test_Mirror    操作给定的二叉树，将其变换为源二叉树的镜像。
 * <P>
 * 5、
 */
public class TreeSolutionMain {
    private TreeSolution solution = new TreeSolution();
    private TreeNode root;

    private void getTreeRoot() {
        root = new TreeNode();
        root.val = 1;
        TreeNode left = new TreeNode();
        left.val = 3;
        root.left = left;
        TreeNode right = new TreeNode();
        right.val = 2;
        root.right = right;
    }

    @Test
    public void test_maxDepth() {
        getTreeRoot();
        System.out.println(solution.maxDepth(root));
    }

    @Test
    public void test_sumNumbers() {
        //找出根节点到叶子节点的所有路径表示的数字之和.https://www.nowcoder.com/practice/185a87cd29eb42049132aed873273e83?tpId=188&&tqId=35512&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
//            这颗二叉树一共有两条路径，
//            根节点到叶子节点的路径 1\to 21→2 用数字\ 12 12 代替
//            根节点到叶子节点的路径 1\to 31→3 用数字\ 13 13 代替
//            所以答案为\ 12+13=25 12+13=25
        TreeNode root = new TreeNode();
        root.val = 1;
        TreeNode left = new TreeNode();
        left.val = 3;
        root.left = left;
        TreeNode right = new TreeNode();
        right.val = 2;
        root.right = right;
        int result = solution.sumNumbers(root);
        System.out.println("sum:" + result);
    }

    @Test
    public void test_levelOrder() {
        TreeNode root = new TreeNode();
        root.val = 1;
        TreeNode left = new TreeNode();
        left.val = 3;
        root.left = left;
        TreeNode right = new TreeNode();
        right.val = 2;
        root.right = right;
//           二叉树层次遍历
        ArrayList<ArrayList<Integer>> result = solution.levelOrder(root);
        System.out.println(result);
    }


    @Test
    public void test_Mirror() {
        getTreeRoot();
        solution.Mirror(root);
    }
}
