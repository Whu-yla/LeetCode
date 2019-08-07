package Easy;

import java.math.BigInteger;
import java.util.BitSet;

public class AddBinary {
    public static String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int ca = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;// a.charAt(i) - '0'两个字符相减实际上是ASCII码对应的数相减
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            ans.append(sum % 2);
            ca = sum / 2;
        }
        ans.append(ca == 1 ? ca : "");
        return ans.reverse().toString();
    }

    /**
     * 二进制转十进制
     *
     * @param binaryNumber
     * @return
     */
    public static int binaryToDecimal(int binaryNumber) {

        int decimal = 0;
        int p = 0;
        while (true) {
            if (binaryNumber == 0) {
                break;
            } else {
                int temp = binaryNumber % 10;
                decimal += temp * Math.pow(2, p);
                binaryNumber = binaryNumber / 10;
                p++;
            }
        }
        return decimal;
    }

    /**
     * 十进制转二进制
     *
     * @param n
     * @return
     */
    public static String decimalToBinary(int n) {
        String str = "";
        while (n != 0) {
            str = n % 2 + str;
            n = n / 2;
        }
        return str;
    }

    /**
     * @param decimalSource
     * @return String
     * @Description: 十进制转换成二进制 ()
     */
    public static String decimalToBinary(BigInteger decimalSource) {
//         BigInteger bi = new BigInteger(String.valueOf(decimalSource));  //转换成BigInteger类型
        return decimalSource.toString(2);  //参数2指定的是转化成X进制，默认10进制
    }

    /**
     * @param binarySource
     * @return int
     * @Description: 二进制转换成十进制
     */
    public static BigInteger binaryToDecimal(String binarySource) {
        BigInteger bi = new BigInteger(binarySource, 2);    //转换为BigInteger类型
//         return Integer.parseInt(bi.toString());     //转换成十进制
        return bi;     //转换成十进制
    }

    /**
     * BitSet转二进制
     *
     * @param bitSet
     * @return
     */
    public static String bitSetToBinary(BitSet bitSet) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < bitSet.length(); i++) {
            if (bitSet.get(i)) {
                stringBuilder.append("1");
            } else {
                stringBuilder.append("0");
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 二进制转BitSet
     *
     * @param binary
     * @return
     */
    public static BitSet binaryToBitSet(String binary) {
        BitSet bitSet = new BitSet();
        for (int i = 0; i < binary.length(); i++) {
            String c = String.valueOf(binary.charAt(i));
            if ("1".equals(c)) {
                bitSet.set(i, true);
            }
        }
        return bitSet;
    }

    public static String addBinary2(String a, String b) {
        int m = a.length(), n = b.length();
        char[] r = new char[Math.max(m, n) + 1];
        int carry = 0, k = r.length - 1;
        for (int i = m - 1, j = n - 1; i >= 0 || j >= 0; --i, --j) {// 多参数for循环，注意j上不需要加int，同上类型
            int x = i >= 0 ? a.charAt(i) - '0' : 0;
            int y = j >= 0 ? b.charAt(j) - '0' : 0;
            int val = x + y + carry;
            r[k--] = (char) ((val % 2) + '0');
            carry = val / 2;
        }
        if (carry > 0) {
            r[0] = '1';
            return String.valueOf(r);
        } else {
            return String.valueOf(r, 1, r.length - 1);
        }
    }
}

