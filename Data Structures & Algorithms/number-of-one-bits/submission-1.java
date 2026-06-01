class Solution {
    public int hammingWeight(int n) {
        // Track 1's bits
        int bits = 0;

        // Loop through all 32 bits
        while (n != 0) {
            // If the last is 1, add to count
            if ((n & 1) == 1) bits++;

            // Shift bits to the right
            n >>= 1;
        }

        return bits;
    }
}
