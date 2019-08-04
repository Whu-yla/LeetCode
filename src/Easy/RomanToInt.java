package Easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    /**
     * create by: Hugo
     * description:创建Map<Character, Integer>来装字符和对应的值，如果左边比右边小就减去自己，如果左边比右边大就加上自己
     * create time: 15:13 2019/8/4
     * @Param: s
     * @return int
     */
    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (map.get(chars[i]) >= map.get(chars[i + 1]))
                result = result + map.get(chars[i]);
            else result = result - map.get(chars[i]);
        }
        return result + map.get(chars[chars.length - 1]);// 别忘了加最后一个字符对应的值
    }

    class Solution {
        /**
         * create by: Hugo
         * description:第一名的解法和我思路一致
         * create time: 15:16 2019/8/4
         * @Param: s
         * @return int
         */
        public int romanToInt(String s) {
            int[] dic = new int[26];
            dic['I' - 'A'] = 1;
            dic['V' - 'A'] = 5;
            dic['X' - 'A'] = 10;
            dic['L' - 'A'] = 50;
            dic['C' - 'A'] = 100;
            dic['D' - 'A'] = 500;
            dic['M' - 'A'] = 1000;

            int res = dic[s.charAt(0) - 'A'];
            for (int i = 1; i < s.length(); i++) {
                if (dic[s.charAt(i) - 'A'] > dic[s.charAt(i - 1) - 'A']) {
                    res += dic[s.charAt(i) - 'A'] - 2 * dic[s.charAt(i - 1) - 'A'];
                } else {
                    res += dic[s.charAt(i) - 'A'];
                }
            }

            return res;
        }
    }
}
