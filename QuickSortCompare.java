import java.util.*;
public class QuickSortCompare {

    // swap helper
    static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    // partition
    static int partition(int[] a, int l, int h) {
        int p = a[h], i = l - 1;
        for (int j = l; j < h; j++) {
            if (a[j] <= p) {
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i + 1, h);
        return i + 1;
    }
    // deterministic quick sort
    static void quickDet(int[] a, int l, int h) {
        if (l < h) {
            int pi = partition(a, l, h);
            quickDet(a, l, pi - 1);
            quickDet(a, pi + 1, h);
        }
    }

    // randomized quick sort
    static void quickRand(int[] a, int l, int h) {
        if (l < h) {
            int r = l + (int) (Math.random() * (h - l + 1));
            swap(a, r, h); // random pivot
            int pi = partition(a, l, h);
            quickRand(a, l, pi - 1);
            quickRand(a, pi + 1, h);
        }
    }
    // MAIN
    public static void main(String[] args) {

        int[] arr = { 10, 7, 8, 9, 1, 5 };
        System.out.println("Original: " + Arrays.toString(arr));

        int[] a1 = arr.clone();
        long t1 = System.nanoTime();
        quickDet(a1, 0, a1.length - 1);
        long t2 = System.nanoTime();

        int[] a2 = arr.clone();
        long t3 = System.nanoTime();
        quickRand(a2, 0, a2.length - 1);
        long t4 = System.nanoTime();

        System.out.println("\nDeterministic: " + Arrays.toString(a1) + " Time: " + (t2 - t1) + " ns");

        System.out.println("Randomized:   " + Arrays.toString(a2) + " Time: " + (t4 - t3) + " ns");
    }
}