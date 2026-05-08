class Solution {
    public String addBinary(String a, String b) {
        // Initialize stringbuilder to hold binary characters, pointers to the end of the strings, and a carry bit holder
        StringBuilder binaryRepresentation = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carryBit = 0;

        // Loop until pointers and carry bit are done
        while (i >= 0 || j >= 0 || carryBit != 0) {
            // Add to carry bit the current character in a
            if (i >= 0) {
                carryBit += a.charAt(i) - '0';
                i--;
            }

            // Add to carry bit the current character in b
            if (j >= 0) {
                carryBit += b.charAt(j) - '0';
                j--;
            }
            
            // Add the current bit, then update carry bit accordingly
            binaryRepresentation.append(carryBit % 2);
            carryBit /= 2;
        }

        // Return reverse of the built string (since we add to the end per char add)
        return binaryRepresentation.reverse().toString();
    }
}