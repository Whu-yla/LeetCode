package Easy;

public class StrStr {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    class Solution {
        public int strStr(String haystack, String needle) {
            if (needle.length() == 0) return 0; // 如果needle长度为0 直接返回0
            int m = haystack.length();
            int n = needle.length();
            if (m < n) return -1;// 如果needle比haystack长 直接返回-1
            else {
                for (int i = 0; i <= m; i++) {// 开始遍历
                    if (i + n <= m) {// 一个一个挪动开始比较
                        if (haystack.substring(i, i + n).equals(needle)) {
                            return i;
                        }
                    }

                }
                return -1;
            }
        }
    }
}
