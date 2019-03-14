package algorithmicPractice.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 4. 寻找两个有序数组的中位数
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class Main4 {

    public static void main(String[] args) {

        Main4 main4 = new Main4();
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(main4.findMedianSortedArrays(nums1, nums2));
    }


    /**
     * 线性时间复杂度，代码能过，但是不符合题目要求
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null) {
            return ((double) nums2[nums2.length / 2] + (double) nums2[(nums2.length - 1) / 2]) / 2;
        }
        if (nums2 == null) {
            return ((double) nums1[nums1.length / 2] + (double) nums1[(nums1.length - 1) / 2]) / 2;
        }
        int i = 0;
        int j = 0;
        int total = nums1.length + nums2.length;
        int mo = (total - 1) / 2;
        int mt = total / 2;
        int reso = 0;
        int resw = 0;
        int index = -1;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                index++;
                if (index == mo) {
                    reso = nums1[i];
                }
                if (index == mt) {
                    resw = nums1[i];
                    break;
                }
                i++;
            } else {
                index++;
                if (index == mo) {
                    reso = nums2[j];
                }
                if (index == mt) {
                    resw = nums2[j];
                    break;
                }
                j++;
            }
        }
        while (i >= nums1.length && index < mt) {
            index++;
            if (index == mo) {
                reso = nums2[j];
            }
            if (index == mt) {
                resw = nums2[j];
                break;
            }
            j++;
        }
        while (j >= nums2.length && index < mt) {
            index++;
            if (index == mo) {
                reso = nums1[i];
            }
            if (index == mt) {
                resw = nums1[i];
                break;
            }
            i++;
        }
        return (double) (reso + resw) / 2;
    }
}
