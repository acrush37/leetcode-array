package medium;

import java.util.*;

/*
    Design a data structure that supports all following operations in average O(1) time.

    insert(val): Inserts an item val to the set if not already present.
    remove(val): Removes an item val from the set if present.
    getRandom: Returns a random element from current set of elements.
    Each element must have the same probability of being returned.
 */
public class InsertDeleteGetRandomO1 {

    private Random random = new Random();
    private Set<Integer> set = new HashSet<>();
    private List<Integer> list = new ArrayList<>();

    public static void main(String... args) {

        InsertDeleteGetRandomO1 insertDeleteGetRandomO1 = new InsertDeleteGetRandomO1();
        insertDeleteGetRandomO1.insert(4);
        insertDeleteGetRandomO1.insert(7);
        System.out.println(insertDeleteGetRandomO1.getRandom());
        insertDeleteGetRandomO1.remove(4);
        System.out.println(insertDeleteGetRandomO1.getRandom());
    }

    public boolean insert(int val) {

        if (set.contains(val)) return false;
        list.add(val);
        set.add(val);
        return true;
    }

    public boolean remove(int val) {

        if (!set.contains(val)) return false;
        set.remove(val);
        return true;
    }

    public int getRandom() {

        while (true) {

            int x = list.get(random.nextInt(list.size()));
            if (set.contains(x)) return x;
        }
    }

}
