package leetcode.editor.cn;

//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 103 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 只会存在一个有效答案 
// 
// Related Topics 数组 哈希表 
// 👍 10955 👎 0

//思路：判断任意一个数是否大于目标数，大于跳出循环。if(x > target || y > target)

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 已解决
 */
public class TwoSum{
    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
        int[] nums = new int[]{2,7,11,15,1,35,8,9,5};
        int target = 14;
        System.out.println(Arrays.toString(solution.twoSum(nums, target)));

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        //暴力
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if(nums[i] + nums[j] == target){
//                    return new int[]{i,j};
//                }
//            }
//        }

        //因为hashmap的查找要比一个一个查找要快，将数组中的值复制到map中，遍历一次数组，判断语句target-nums[i] == map中的值

        //1.可以避免重复的情况如14 = 7 + 7;
        //2.只用遍历一次
        //3.map的结构（k:num[i]的值，v:存储的位置，即i）


        //运用hashmap的解法
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        for (int i = 0; i < nums.length; i++) {
            int j = target - nums[i];//先获取另一个值j
            if(map.containsKey(j)){//在map中查看是否存在key的值为j
                return new int[]{i,map.get(j)};//如果存在则返回
            }
            map.put(nums[i],i);//不存在则将遍历到的这个数存入数组中。
        }
       throw new RuntimeException("未查找到两数之和为" + target);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
