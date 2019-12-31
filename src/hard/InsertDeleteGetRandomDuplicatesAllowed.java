package hard;

import java.util.*;

/*
    Design a data structure that supports all following operations in average O(1) time.

    Note: Duplicate elements are allowed.
    insert(val): Inserts an item val to the collection.
    remove(val): Removes an item val from the collection if present.
    getRandom: Returns a random element from current collection of elements.

    The probability of each element being returned is linearly related to the number of same value the collection contains.
 */
public class InsertDeleteGetRandomDuplicatesAllowed {

    private Random random = new Random();

    private List<Integer> t = new ArrayList<>();

    private Map<Integer, List<Integer>> f = new HashMap<>();

    public static void main(String... args) {

        InsertDeleteGetRandomDuplicatesAllowed insertDeleteGetRandomDuplicatesAllowed = new InsertDeleteGetRandomDuplicatesAllowed();
        System.out.println(insertDeleteGetRandomDuplicatesAllowed.insert(1));
        System.out.println(insertDeleteGetRandomDuplicatesAllowed.insert(1));
        System.out.println(insertDeleteGetRandomDuplicatesAllowed.insert(2));
        System.out.println(insertDeleteGetRandomDuplicatesAllowed.insert(1));
        System.out.println(insertDeleteGetRandomDuplicatesAllowed.insert(2));
        System.out.println(insertDeleteGetRandomDuplicatesAllowed.remove(1));
        System.out.println(insertDeleteGetRandomDuplicatesAllowed.remove(2));
        System.out.println(insertDeleteGetRandomDuplicatesAllowed.remove(2));
        System.out.println(insertDeleteGetRandomDuplicatesAllowed.getRandom());
        System.out.println(insertDeleteGetRandomDuplicatesAllowed.getRandom());
    }

    public boolean insert(int val) {

        List<Integer> x = f.get(val);
        if (x == null) x = new ArrayList<>();
        x.add(t.size());
        f.put(val, x);
        t.add(val);
        return x.size() == 1;
    }

    public boolean remove(int val) {

        List<Integer> x = f.get(val);
        if (x == null || x.isEmpty()) return false;
        int y = x.get(x.size() - 1);
        f.get(val).remove(x.size() - 1);
        int z = t.get(t.size() - 1);
        t.set(y, z);
        f.get(z).add(y);
        f.get(z).remove(Integer.valueOf(t.size() - 1));
        t.remove(t.size() - 1);
        return true;
    }

    public int getRandom() {
        return t.get(random.nextInt(t.size()));
    }

}
