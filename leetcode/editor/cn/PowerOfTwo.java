package leetcode.editor.cn;
/*给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。*/

//给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
//
// 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 1
//输出：true
//解释：20 = 1
// 
//
// 示例 2： 
//
// 
//输入：n = 16
//输出：true
//解释：24 = 16
// 
//
// 示例 3： 
//
// 
//输入：n = 3
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：n = 4
//输出：true
// 
//
// 示例 5： 
//
// 
//输入：n = 5
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// -231 <= n <= 231 - 1 
// 
//
// 
//
// 进阶：你能够不使用循环/递归解决此问题吗？ 
// Related Topics 位运算 数学 
// 👍 326 👎 0

/**求是否是2的幂次方
 * 已解决
 */
public class PowerOfTwo{
    public static void main(String[] args) {
        Solution solution = new PowerOfTwo().new Solution();
        System.out.println(Integer.toBinaryString(5));
        System.out.println(Integer.bitCount(5));
//        System.out.println(solution.isPowerOfTwo(-4));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPowerOfTwo(int n) {
//        因为2的幂次方的二进制表示为1000...即第一个数为1其余为0，减1后二进制所有位都为1
        //官方写法
        return n > 0 && (n & (n - 1)) == 0;

//        自己的写法
//        因为2的幂次方的二进制表示为1000...即第一个数为1其余为0
//        if (n <= 0)
//            return false;
//        String str = Integer.toBinaryString(n);
//        String substring = str.substring(1);
//        if (substring.contains("1")){
//            return false;
//        }

//        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
