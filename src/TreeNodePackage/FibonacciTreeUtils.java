package TreeNodePackage;

/**
 * Created by ù on 12.08.2015.
 */
public class FibonacciTreeUtils {
    public static void main(String[] args) {
        int number = 7;
        TreeNode treeNodeArg = generateArg(number);
        TreeNode treeNodeRes = generateRes(number);
        TreeNode treeNodeNum = generateNum(number, 0).result;

        System.out.println(treeNodeArg.left.left.right.value);
        System.out.println(treeNodeRes.left.right.value);
        System.out.println(treeNodeNum.left.left.left.value);
    }

    private static ReturnTreeNode generateNum(int number, int count) {
        if (number > 1) {
            TreeNode result = new TreeNode(count,
                    generateNum(number - 2, count + 1).result,
                    generateNum(number - 1, generateNum(number - 2, count + 1).count + 1).result);
            return new ReturnTreeNode(result, count);
        } else {
            TreeNode result = new TreeNode(count, null, null);
            return new ReturnTreeNode(result, count);
        }
    }

    private static TreeNode generateArg(int number) {
        if (number > 1) {
            return new TreeNode(number, generateArg(number - 2), generateArg(number - 1));
        } else {
            return new TreeNode(number, null, null);
        }
    }

    private static TreeNode generateRes(int number) {
        if (number > 1) {
            return new TreeNode(generateRes(number - 2).value + generateRes(number - 1).value,
                    generateRes(number - 2),
                    generateRes(number - 1));
        } else {
            return new TreeNode(number, null, null);
        }
    }
}
