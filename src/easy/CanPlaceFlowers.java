package easy;

import java.util.ArrayList;
import java.util.List;

/*
    Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty),
    and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.
 */
public class CanPlaceFlowers {

    public static void main(String... args) {

        int[] flowerbed = {1, 0, 0, 0, 0, 1};
        CanPlaceFlowers canPlaceFlowers = new CanPlaceFlowers();
        System.out.println(canPlaceFlowers.canPlaceFlowers(flowerbed, 2));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int s = 0;
        int m = 2 + flowerbed.length;
        Integer[] f = new Integer[m];
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int x : flowerbed) list.add(x);
        list.add(0);
        list.toArray(f);

        for (int i = 1; i < m-1; i++)
            if (f[i] == 0 && f[i-1] == 0 && f[i+1] == 0) {
                s++;
                f[i] = 1;
            }

        return s >= n;
    }

}
