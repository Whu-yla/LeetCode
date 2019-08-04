package Easy;

/**
 * create by: Hugo
 * description:给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 本人的转置int就很简单，思路看下面的注释
 * create time: 9:54 2019/8/4
 *
 * @Param: x
 * @return int
 */
public class ReverseInt {
    public static int myReverse(int x) {
        int result = 0;// 定义一个全局的返回值，默认是0
        if (Math.pow(-2, 31) <= x && x <= (Math.pow(2, 31) - 1)) {// 判断输入是否超限
            String s = String.valueOf(x);// 将输入的int转成string
            if (s.indexOf("-") != -1) {// 判断一下string中能否找到负号，及判断输入是否为负数
                s = s.substring(1, s.length());// 取出负数之后的字符串
                char[] chars = s.toCharArray();// 转成char[]
                char[] temp = new char[s.length()];// 创造一个装字符的字符数组
                for (int i = 0; i < s.length(); i++) {// 开始遍历
                    temp[i] = chars[s.length() - 1 - i];// 开始遍历转置
                }
                String result2 = "-" + String.valueOf(temp);// 加上符号准备输出
                try {
                    result = Integer.parseInt(result2);// 如果try没有捕获异常就表明转置之后也在int范围之内
                } catch (NumberFormatException e) {// 捕获异常，输出result=0
                    result = 0;
                }
            } else {// esle表明输入为正整数，即不需要符号，其余思路与上述相同。
                char[] chars = s.toCharArray();
                char[] temp = new char[s.length()];
                for (int i = 0; i < s.length(); i++) {
                    temp[i] = chars[s.length() - 1 - i];
                }
                String result2 = String.valueOf(temp);
                try {
                    result = Integer.parseInt(result2);
                } catch (NumberFormatException e) {
                    result = 0;
                }
            }
        }
        return result;
    }

    /**
     * create by: Hugo
     * description:排名第一的人的解法
     * create time: 9:53 2019/8/4
     *
     * @return
     * @Param: null
     */
    public static int reverse(int x) {
        int mus = 0;
        int dao = 0;
        if (x == 0)
            return 0;
        while (x != 0) {
            mus = x % 10;// 每次%10可以得到最后一位
            x = x / 10;// 得到最后一位之后x/10因为是int类型所以会向下取整
            if (dao > Integer.MAX_VALUE / 10 || dao < Integer.MIN_VALUE / 10)// 判断是否出界
                return 0;
            dao = dao * 10 + mus;// 将获得的尾数*10+下一次获得的位数，逐渐反转
        }
        return dao;
    }
}
