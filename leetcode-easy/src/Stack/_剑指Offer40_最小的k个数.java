package Stack;

public class _剑指Offer40_最小的k个数 {
    public static void main(String[] args) {
       int[] ints = new int[]{0,0,2,3,2,1,1,2,0,4};
       getLeastNumbers(ints, 10);
    }
    public static int[] getLeastNumbers(int[] arr, int k) {
        int[] ints = new int[k];
        int length = arr.length;

        for (int i = 0; i < length; i++) {
            for (int j = length - 2; j >= i ; j--) {
                if (arr[j] > arr[j+1]) {
                    arr[j] = arr[j+1] + arr[j];
                    arr[j+1] = arr[j] - arr[j+1];
                    arr[j] = arr[j] - arr[j+1];
                }
            }
            ints[i] = arr[i];
            if (i + 1 == k)return ints;
        }



        //for (int i = 0; i < length; i++) {
        //    for (int j = 0; j < length - 1 - i; j++) {
        //        if (arr[j] > arr[j+1]) {
        //            arr[j] = arr[j+1] + arr[j];
        //            arr[j+1] = arr[j] - arr[j+1];
        //            arr[j] = arr[j] - arr[j+1];
        //        }
        //    }
        //}
        for (int i = 0; i < length; i++) {
            System.out.println(arr[i]);
        }
        for (int i = 0; i < k; i++) {
            ints[i] = arr[i];
        }
        return ints;
    }
}
