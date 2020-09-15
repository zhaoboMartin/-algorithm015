import java.util.HashMap;
import java.util.Map;

public class BuildTree105 {

//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//
//        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
//
//    }

//    public static void main(String[] args) {
//        BuildTree105 dd = new BuildTree105();
//        int[] preordr = new int[]{3,9,20,15,7};
//        int[] inordr = new int[]{9,3,15,20,7};
//        System.out.println(dd.buildTree(preordr, inordr));
//    }
//
//    /**
//     * 大体思路 此题含有重复自问题
//     * 前序 3,9,20,15,7
//     *
//     * 前序能确定每个子数的根节点，中序能根据根节点划分出左右子树，是个递归的过程
//     * 中序 9,3,15,20,7
//     * @param preorder
//     * @param startPre
//     * @param endPre
//     * @param inorder
//     * @param startIn
//     * @param endIn
//     * @return
//     */
//    public TreeNode helper(int[] preorder, int startPre, int endPre, int[] inorder, int startIn, int endIn) {
//
//        if(startPre > endPre||startIn> endIn){
//            return null;
//        }
//        TreeNode root = new TreeNode(preorder[startPre]);
//        int inorderEnd = 0;
//        for (int i = 0; i < inorder.length; i++) {
//            if (preorder[startPre] == inorder[i]) {
//                inorderEnd = i;
//                break;
//            }
//        }
//        int preOrderend = 0;
//        for (int i = 0; i < preorder.length; i++) {
//            if (inorder[inorderEnd - 1] == preorder[i]) {
//                preOrderend = i;
//            }
//        }
//
//        root.left = helper(preorder, startPre + 1, preOrderend, inorder, startIn, Math.max(inorderEnd - 1, 0));
//        root.right = helper(preorder, preOrderend + 1, endPre, inorder, inorderEnd + 1, endIn);
//
//        return root;
//    }

    private Map<Integer, Integer> indexMap;

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }
}

