package Trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreepath {
    
    class solution{
        public static void paths(Node root , String str ,List<String> ans){
            if(root==null) return;
            if(root.left==null  && root.right==null){
                str+=root.val;
                ans.add(str);
                return;
            }
            path(root.right , str+root.val+"->"  , ans);
            path(root.left , str+root.val+"->"  , ans);

        }
        public List<String> binaryTreePaths(Node root) {
            ArrayList<String> ans = new ArrayList<>();
            paths(root , "" , ans);
            return  ans;



            
    }
    }
}
