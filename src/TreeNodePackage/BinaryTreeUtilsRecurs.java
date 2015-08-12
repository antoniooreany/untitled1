package TreeNodePackage;

/**
 * Created by ù on 10.08.2015.
 */
public class BinaryTreeUtilsRecurs {
    public static void main(String[] args) {
        int size = 5;
        TreeNode treeNode = null;
        TreeNode treeNode0 = new TreeNode(100, null, null);
        TreeNode treeNode1 = new TreeNode(1, null, null);
        TreeNode treeNode2 = new TreeNode(2, treeNode0, treeNode1);
        TreeNode treeNode3 = new TreeNode(36, treeNode2, null);
        TreeNode treeNode4 = new TreeNode(4000, null, null);
        TreeNode treeNode5 = new TreeNode(5, treeNode3, treeNode4);

        TreeNode treeNodeFib = generateTreeNodeFib(size);
        System.out.println(size(treeNode5));
        System.out.println(height(treeNode5));
        System.out.println(sum(treeNode5));
        System.out.println(max(treeNode5));
    }

    private static int size(TreeNode root) {
        if (root != null) {
            return size(root.left) + size(root.right) + 1;
        } else {
            return 0;
        }
    }

    private static int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            if (height(root.left) > height(root.right)) {
                return height(root.left) + 1;
            } else {
                return height(root.right) + 1;
            }
        }
    }

    private static int sum(TreeNode root) {
        if (root != null) {
            return root.value + sum(root.left) + sum(root.right);
        } else {
            return 0;
        }
    }

    private static int max(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        } else {
            return maxOfThree(max(root.left), max(root.right), root.value);
        }
    }

    private static int maxOfThree(int elem1, int elem2, int elem3) {
        if (elem1 > elem2) {
            return maxOfTwo(elem2, elem3);
        } else {
            return maxOfTwo(elem2, elem3);
        }
    }

    private static int maxOfTwo(int elem1, int elem2) {
        if (elem1 > elem2) return elem1;
        else return elem2;
    }

    private static TreeNode generateTreeNodeFib(int number) {
        TreeNode result;
        if (number > 0) {
            result = new TreeNode(number, generateTreeNodeFib(number - 1), generateTreeNodeFib(number - 2));
        } else {
            result = null;
        }
        return result;
    }
}
