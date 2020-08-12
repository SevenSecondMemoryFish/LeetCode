public class MergeNums88 {
    public static void main(String[] args) {

        merge(new int[] {2,0},1,new int[]{1},1);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length == 1){
            nums1 = nums2;
        } else {
        var beforeIndex = -1;
        var before = 0;
        var isEnd = false;
        for (int index = 0; index < nums2.length; index++) {
            var hh = nums2[index];
            var isAdd = false;
            if (!isEnd) {
                while (!isAdd) {
                    beforeIndex++;
                    before = beforeIndex < m ? nums1[beforeIndex] : before;
                    if (hh < before || (hh >= before && (hh < nums1[beforeIndex+1] || beforeIndex + 1 == m))) {
                        if (beforeIndex == m-1) {
                            beforeIndex++;
                            isEnd = true;
                        } else {
                            for (int a = m - 1; a >= beforeIndex; a--) {
                                nums1[a + 1] = nums1[a];
                            }
                        }
                        isAdd = true;
                        nums1[beforeIndex] = hh;
                        m++;
                    }
                }
            } else {
                beforeIndex++;
                nums1[beforeIndex] = hh;
                m++;
            }
        }}
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }
}
