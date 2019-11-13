package easy;

/*
    We have two special characters. The first character can be represented by one bit 0.
    The second character can be represented by two bits (10 or 11).

    Now given a string represented by several bits.
    Return whether the last character must be a one-bit character or not.
    The given string will always end with a zero.
 */
public class OneAndTwoBitCharacters {

    public static void main(String... args) {

        int[] bits = {1, 0};
        OneAndTwoBitCharacters oneAndTwoBitCharacters = new OneAndTwoBitCharacters();
        System.out.println(oneAndTwoBitCharacters.isOneBitCharacter(bits));
    }

    public boolean isOneBitCharacter(int[] bits) {

        int n = bits.length;
        if (n == 1 || bits[n-2] == 0) return true;
        while (n >= 2 && bits[n-2] == 1) n--;
        return ((bits.length - n) & 1) == 0;
    }

}
