package sort;

public class SortTest {
    private static void testFloat() {
        float x = 0.00000112341115f;
        float y = 0.00000112341114f;
        boolean equals = x == y;
        System.out.print(equals);
    }

    /**
     * 冒泡排序
     */
    private static void bubbleSort() {
        int count = 0;
        int[] arrays = {5, 4, 1, 2, 0, 9, 3};
        for (int i = 0; i < arrays.length - 1; i++) {
            for (int j = i + 1; j < arrays.length; j++) {
                System.out.println(++count);
                if (arrays[i] > arrays[j]) {
                    int temp = arrays[i];
                    arrays[i] = arrays[j];
                    arrays[j] = temp;
                }
            }
        }

        System.out.print(arrays);
    }

    /**
     * 快速排序
     *
     * @param arrays
     * @param low
     * @param hi
     */
    private static void quickSort(int[] arrays, int low, int hi) {

        if (low < hi) {
            int position = getPosition(arrays, low, hi);
            quickSort(arrays, low, position - 1);
            quickSort(arrays, position + 1, hi);
        }

        System.out.println(arrays);
    }

    /**
     * 快速排序获取key所在的index
     *
     * @param arrays
     * @param low
     * @param hi
     * @return
     */
    private static int getPosition(int[] arrays, int low, int hi) {
        int base = arrays[low];

        while (low < hi) {
            while (arrays[hi] > base && low < hi) {
                hi--;
            }

            if (arrays[hi] < base) {
                arrays[low++] = arrays[hi];
            }

            while (arrays[low] < base && low < hi) {
                low++;
            }

            if (arrays[low] > base) {
                arrays[hi--] = arrays[low];
            }

        }
        arrays[hi] = base;

        return hi;
    }


    private static void quickSort() {

    }
}
