package niuke;

/**
 * @author atom.hu
 * @version V1.0
 * @Package niuke
 * @date 2020/9/30 22:32
 * @Description ArrSolution
 */
public class ArrSolution {
    /**
     * 给出一个整数数组，请在数组中找出两个加起来等于目标值的数，返回这两个数字的下标（index1，index2）
     *
     * @param numbers int整型一维数组
     * @param target  int整型
     * @return int整型一维数组
     */
    public int[] twoSum(int[] numbers, int target) {
        // write code here
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return null;
    }

    /**
     * 寻找第K大
     *
     * @param a
     * @param n
     * @param K
     * @return
     */
    public int findKth(int[] a, int n, int K) {
        return quickSort(a, 0, n - 1, K);
    }

    private int quickSort(int[] arr, int low, int high, int k) {
        int p = partion(arr, low, high);
        if (k < p - low + 1) {
            return quickSort(arr, low, high - 1, k);
        } else if (k > p - low + 1) {
            return quickSort(arr, low, high + 1, k - (p - low + 1));
        } else {
            return arr[p];
        }
    }

    private int partion(int[] arr, int low, int high) {
        int tmp = arr[low];
        while (low < high) {
            while (low < high && arr[high] <= tmp) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] >= tmp) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = tmp;
        return low;
    }


}
