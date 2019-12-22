package medium;

import java.util.*;

/*
    Given an array of integers nums and a positive integer k, find whether
    it's possible to divide this array into sets of k consecutive numbers

    Return True if its possible otherwise return False.
 */
public class DivideArrayInSetsOfKConsecutiveNumbers {

    public static void main(String... args) {

        int[] nums = {1, 1, 1, 2, 2, 2};
        DivideArrayInSetsOfKConsecutiveNumbers divideArrayInSetsOfKConsecutiveNumbers = new DivideArrayInSetsOfKConsecutiveNumbers();
        System.out.println(divideArrayInSetsOfKConsecutiveNumbers.isPossibleDivide(nums, 2));
    }

    public boolean isPossibleDivide(int[] nums, int k) {

        if (nums.length % k != 0) return false;
        Map<Integer, Integer> m = new HashMap<>();
        List<Integer> f = new ArrayList<>();
        boolean flag = true;

        for (int x : nums) {

            f.add(x);
            Integer y = m.get(x);
            m.put(x, y == null ? 1 : 1 + y);
        }

        int p = m.get(nums[0]);
        Collection<Integer> c = m.values();

        for (int x : c)
            if (x != p) {
                flag = false;
                break;
            }

        if (flag && m.size() == k) {

            List<Integer> list = new ArrayList<>(m.keySet());
            Collections.sort(list);

            for (int i = 1; i < list.size(); i++)
                if (list.get(i) != list.get(i-1) + 1)
                    return false;

            return true;
        }

        Collections.sort(f);
        int n = nums.length / k;

        while (--n >= 0) {

            Set<Integer> t = new HashSet<>();
            Integer x = f.get(0), y = 0;
            t.add(x);

            for (int i = 1; i < k; i++) {

                while (++y < f.size()) {

                    Integer z = f.get(y);
                    if (z > x+1) return false;

                    if (z == x+1) {
                        x++;
                        t.add(z);
                        break;
                    }
                }

                if (y == f.size()) return false;
            }

            if (t.size() != k) return false;
            for (Integer z : t) f.remove(z);
        }

        return true;
    }

}
