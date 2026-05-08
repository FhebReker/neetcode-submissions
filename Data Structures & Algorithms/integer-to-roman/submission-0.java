class Solution {
    public String intToRoman(int num) {
        // Initialize arrays for constant lookup and stringbuilder
        int[] intValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] numeralValues = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder s = new StringBuilder();

        // Loop until we have filled the string with the correct characters
        for (int i = 0; i < intValues.length; i++) {
            // Break if num is done
            if (num <= 0) break;

            // Keep adding the same character until we move onto the next value to add
            while (num >= intValues[i]) {
                s.append(numeralValues[i]);
                num -= intValues[i];
            }
        }

        // Return the constructed string
        return s.toString();
    }
}