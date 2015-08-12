package TreeNodePackage;

/**
 * Created by � on 10.08.2015.
 */
public class BinaryTreeUtilsIter {
    public static void main(String[] args) {
        int number = 6;
        TreeNode rootFib = generateTreeNodeFib(number);
        TreeNode treeNode0 = new TreeNode(0, null, null);
        TreeNode treeNode1 = new TreeNode(1, null, null);
        TreeNode treeNode2 = new TreeNode(2, treeNode0, treeNode1);
        TreeNode treeNode3 = new TreeNode(3, treeNode2, null);
        TreeNode treeNode4 = new TreeNode(4, null, null);
        TreeNode treeNode5 = new TreeNode(5, treeNode3, treeNode4);
//        System.out.println(rootFib.left.left.value);
        System.out.println(sizeRecurs(treeNode5));
    }

    private static int sizeRecurs(TreeNode root) {
        if (root != null) {
            return sizeRecurs(root.left) + sizeRecurs(root.right) + 1;
        } else {
            return 0;
        }
    }

    private static int size(TreeNode root) {
        int result = 0;
        TreeNode prevRoot = null;
        while (root != null) {
            result ++;
            if (root.left != null) {
                prevRoot = root;
                root = root.left;
            } else {
                if (root.right != null) {
                    prevRoot = root;
                    root = root.right;
                } else root = prevRoot.right;
            }
        }
        return result;
    }

    private static TreeNode generateTreeNodeFib(int number) {
        TreeNode left = new TreeNode(0, null, null);
        TreeNode right = new TreeNode(1, null, null);
        TreeNode result = null;
        for (int index = 1; index < number; index++) {
            result = new TreeNode(left.value + right.value, left, right);
            left = right;
            right = result;
        }
        return result;
    }
}
