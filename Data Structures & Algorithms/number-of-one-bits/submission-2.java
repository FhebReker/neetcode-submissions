class Solution {
    public int hammingWeight(int n) {
        // Track 1's bits
        int bits = 0;

        // Loop through all 32 bits
        while (n != 0) {
            // Remove last 1 bit
            n &= n - 1;

            // Add to count
            bits++;
        }

        return bits;
    }
}
