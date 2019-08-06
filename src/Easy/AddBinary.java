package Easy;

import java.math.BigInteger;
import java.util.BitSet;

public class AddBinary {
    public static String addBinary(String a, String b) {
        return "";
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
     * @Description: 十进制转换成二进制 ()
     * @param decimalSource
     * @return String
     */
    public static String decimalToBinary(BigInteger decimalSource) {
//         BigInteger bi = new BigInteger(String.valueOf(decimalSource));  //转换成BigInteger类型
        return decimalSource.toString(2);  //参数2指定的是转化成X进制，默认10进制
    }

    /**
     * @Description: 二进制转换成十进制
     * @param binarySource
     * @return int
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
}
