package Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintHeapPath {

    public static List<String> printHeapPath(List<int[]> list) {
        int[] input1 = list.get(0);
        int[] input2 = list.get(1);
        int[] input3 = list.get(2);
        List<String> result2 = new ArrayList();
        creat(input2, input2.length - 1);
        for (int i = 0; i < input3.length; i++) {
            int param = input3[i];
            String result = "";
            result = result + " " + input2[param - 1];
            while (param / 2 != 0) {
                param /= 2;
                result = result + " " + input2[param - 1];
            }
            result2.add(result);
        }
        return result2;
    }

    /*******一种思路******/
    // 向下调整，顶端的大值往下调，主要用于删除和建堆,i表示要调整的节点索引，n表示堆的最后一个元素索引
    // 删除时候，i是0，建堆时候i从最后一个节点的父节点依次往前调整
    public static void fixDown(int[] data, int i, int n) {
        int num = data[i];// 当前i这个结点的值
        int son = i * 2 + 1;// 表示i这个结点的左子树
        while (son <= n) {// 如果当前左子树存在
            if (son + 1 <= n && data[son + 1] < data[son])// 如果右子树也存在并且右子树小于左子树
                son++;// son++表示只记录较小结点的索引
            if (num < data[son])//如果k节点的值小于较大子节点的值，不返回，若大于则交换它们的值，并将biggerIndex赋值给k，开始下一次循环
                break;
            data[i] = data[son];// son是较小的孩子结点的索引，这里将正在判断的结点赋予更小的孩子结点的值
            i = son;// 赋值son为i
            son = i * 2 + 1;// i*2+1 判断孩子结点是否还存在孩子结点，如果存在再迭代
        }
        data[i] = num;// 将值交换
    }

    // 向上调整，小值往上走,用于增加,往上调整不需要制定最上面的索引，肯定是0
    public static void fixUp(int[] data, int n) {
        int num = data[n];
        int father = (n - 1) / 2;
        // data[father] > num是进入循环的基本条件,father减到0就不会减少了
        // 当n等于0时，father=0；进入死循环，所以当n==0时，需要跳出循环
        while (data[father] > num && n != 0) {
            data[n] = data[father];
            n = father;
            father = (n - 1) / 2;
        }
        data[n] = num;
    }

    // 删除,n表示堆的最后一个元素的索引
    public static void delete(int[] data, int n) {
        data[0] = data[n];
        data[n] = -1;
        fixDown(data, 0, n - 1);
    }

    // 增加,i表示要增加的数字，n表示增加位置的索引，是堆的最后一个元素
    public static void insert(int[] data, int num, int n) {
        data[n] = num;
        fixUp(data, n);
    }

    // 建堆,n表示要建堆的最后一个元素的索引，从lastIndex节点（最后一个节点）的父节点开始循环
    public static void creat(int[] data, int n) {
        for (int i = (n - 1) / 2; i >= 0; i--)
            fixDown(data, i, n);// i为当前判断的结点，n为最后一个元素的索引
    }

    /**************同样的思路*************/

    //堆排序函数
    public static void heapSort(int[] a) {
        int l = a.length;//记录数组长度
        for (int i = 0; i < l - 1; i++) {//循环调用建立堆函数建立堆
            buildHeap(a, l - 1 - i);//调用建立堆函数
            swap(a, 0, l - 1 - i);//堆建立好后，交换根节点和堆的最后一个节点
            System.out.println(Arrays.toString(a));
        }
    }

    //交换元素的函数
    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    //建立堆函数，在数组a中，从0到lastIndex建立堆
    public static void buildHeap(int[] a, int lastIndex) {
        int l = a.length;//记录数组长度
        for (int j = (lastIndex - 1) / 2; j >= 0; j--) {//从lastIndex节点（最后一个节点）的父节点开始循环
            int k = j;//k保存正在判断的节点
            //如果当前k节点的子节点存在
            while (2 * k + 1 <= lastIndex) {
                int biggerIndex = 2 * k + 1;//k节点的左子节点索引
                if (biggerIndex < lastIndex) {//表示k节点存在右节点
                    if (a[biggerIndex] < a[biggerIndex + 1]) {
                        biggerIndex++;//biggerIndex总是记录较大子节点的索引
                    }
                }
                if (a[k] < a[biggerIndex]) {//如果k节点的值小于较大子节点的值，则交换它们的值，并将biggerIndex赋值给k，开始下一次循环
                    swap(a, k, biggerIndex);//保证k节点的值大于其子节点的值
                    k = biggerIndex; //赋值
                } else {
                    break;
                }
            }
        }
    }
}
