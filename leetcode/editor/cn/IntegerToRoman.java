package leetcode.editor.cn;
/*罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。*/

//罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。 
//
// 
//字符          数值
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000 
//
// 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V + I
//I 。 
//
// 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5
// 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况： 
//
// 
// I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。 
// X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
// C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。 
// 
//
// 给你一个整数，将其转为罗马数字。 
//
// 
//
// 示例 1: 
//
// 
//输入: num = 3
//输出: "III" 
//
// 示例 2: 
//
// 
//输入: num = 4
//输出: "IV" 
//
// 示例 3: 
//
// 
//输入: num = 9
//输出: "IX" 
//
// 示例 4: 
//
// 
//输入: num = 58
//输出: "LVIII"
//解释: L = 50, V = 5, III = 3.
// 
//
// 示例 5: 
//
// 
//输入: num = 1994
//输出: "MCMXCIV"
//解释: M = 1000, CM = 900, XC = 90, IV = 4. 
//
// 
//
// 提示： 
//
// 
// 1 <= num <= 3999 
// 
// Related Topics 数学 字符串 
// 👍 590 👎 0

public class IntegerToRoman{
    public static void main(String[] args) {
//        Solution solution = new IntegerToRoman().new Solution();
//        System.out.println(solution.intToRoman(3451));
//        String s1 = "a";
//        String s2 = "b";
//        System.out.println(s1.compareTo(s2));

            Integer i1 = 1;
            Integer i2 = 2;
        System.out.println(i1.compareTo(i2));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String intToRoman(int num) {
        StringBuffer str = new StringBuffer();
        //取到千位数
        int th = num/1000;
        while(th > 0){
            str.append("M");
            th--;
        }

        //取余数：百
        num = num%1000;

        //取到百位数
        int hun = num/100;

        if(hun == 9){
            str.append("CM");
        }else if(hun == 4){
            str.append("CD");
        }else if(hun < 5){
            while (hun > 0){
                str.append("C");
                hun--;
            }
        }else if(hun > 5){
            str.append("D");
            int tem = hun%5;
            while (tem > 0){
                str.append("C");
                tem--;
            }
        }else{
            str.append("D");
        }

        //取余数：十
        num = num%100;

        //取到十位数
        int te = num/10;
        if(te == 9){
            str.append("XC");
        }else if(te == 4){
            str.append("XL");
        }else if(te < 5){
            while(te > 0){
                str.append("X");
                te--;
            }
        }else if(te > 5){
            str.append("L");
            int tem = te % 5;
            while(tem > 0){
                str.append("X");
                tem--;
            }
        }else{
            str.append("L");
        }

        //取余数：个，取到个位数
        num = num%10;
        if(num == 9){
            str.append("IX");
        }else if(num == 4){
            str.append("IV");
        }else if(num < 5){
            while(num > 0){
                str.append("I");
                num--;
            }
        }else if(num > 5){
            str.append("V");
            int tem = num%5;
            while(tem > 0){
                str.append("I");
                tem--;
            }
        }else{
            str.append("V");
        }

        return str.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
