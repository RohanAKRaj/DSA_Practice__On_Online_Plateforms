class Solution {
    private static void leftBoundary(Node root, ArrayList<Integer> ans) {
        if(root==null) return;
        if(root.left==null && root.right==null) return;
        ans.add(root.data);
        if(root.left!=null) leftBoundary(root.left, ans);
        else leftBoundary(root.right, ans);
    }

    private static void leafs(Node root, ArrayList<Integer> ans) {
        if(root==null) return;
        if(root.left==null && root.right==null) ans.add(root.data);

        leafs(root.left, ans);
        leafs(root.right, ans);
    }

    private static void rightBoundary(Node root, ArrayList<Integer> ans) {
        if(root==null) return;
        if(root.left==null && root.right==null) return;
        if(root.right!=null) rightBoundary(root.right, ans);
        else rightBoundary(root.left, ans);
        ans.add(root.data);
    }
    
    public ArrayList<Integer> boundaryTraversal(Node root) {
       ArrayList<Integer> ans = new ArrayList<>();
       ans.add(root.data);
       if(root.left==null && root.right==null) return ans;
       leftBoundary(root.left, ans);
       leafs(root, ans);
       rightBoundary(root.right, ans);
       return ans;
        
    }
}