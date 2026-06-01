class Solution {
    public int hammingWeight(int n) {
        // Track 1's bits
        int bits = 0;

        // Loop through all 32 bits
        for (int i = 0; i < 32; i++) {
            // If the bit at index i is 1, add to count
            if (((1 << i) & n) != 0) bits++;
        }

        return bits;
    }
}
