package niuke;

/**
 * @author atom.hu
 * @version V1.0
 * @Package niuke
 * @date 2020/10/1 20:35
 * @Description NumberArrSolution
 */
public class NumberSolution {
    /**
     * 在不使用额外的内存空间的条件下判断一个整数是否是回文数字
     *
     * @param x int整型
     * @return bool布尔型
     */
    public boolean isPalindrome(int x) {
        // write code here
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int reverse = 0;
        while (x > reverse) {
            reverse = reverse * 10 + x % 10;
            x = x / 10;
        }
        return (reverse == x || reverse / 10 == x);
    }
}
