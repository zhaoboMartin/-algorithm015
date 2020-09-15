import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * 全排列
 */
public class Permute46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums,res,new LinkedHashSet<>());
        return res;
    }
    public void helper(int[] nums,List<List<Integer>> res, Set<Integer> tempSet){
        if(tempSet.size() == nums.length){
            res.add(new ArrayList<>(tempSet));
            return;
        }
        for (int num : nums) {
            if(tempSet.contains(num))
                continue;
            tempSet.add(num);
            helper(nums,res,tempSet);
            tempSet.remove(num);
        }

    }
}
