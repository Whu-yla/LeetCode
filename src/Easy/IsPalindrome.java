package Easy;

public class IsPalindrome {
    /**
     * create by: Hugo
     * description:
     * create time: 14:37 2019/8/4
     * @Param: x
     * @return boolean
     */
    public static boolean isPalindrome(int x) {
        boolean flag = false;
        if (x >= 0) {
            int temp = x;
            int mus = 0;
            int dao = 0;
            if (x == 0)
                return true;
            while (x != 0) {
                mus = x % 10;// 每次%10可以得到最后一位
                x = x / 10;// 得到最后一位之后x/10因为是int类型所以会向下取整
                if (dao > Integer.MAX_VALUE / 10 || dao < Integer.MIN_VALUE / 10)// 判断是否出界
                    return false;
                dao = dao * 10 + mus;// 将获得的尾数*10+下一次获得的位数，逐渐反转
            }
            if (temp == dao) {
                flag = true;
            }
        } else flag = false;
        return flag;
    }
    /**
     * create by: Hugo
     * description:思路和我完全一样，只是我的代码可以简化
     * create time: 14:38 2019/8/4
     * @Param: null
     * @return
     */
    public static class Solution {
        public static boolean isPalindrome(int x) {
            if(x < 0) return false;
            int sub = 0;
            int temp = 0;
            int count = 0;
            int n = x;
            while(n > 0){
                sub = n % 10;
                temp = temp * 10 + sub;
                n /= 10;
            }

            if(temp == x) return true;
            else return false;
        }
    }
}
