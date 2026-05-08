class Solution {
    public int romanToInt(String s) {
        // Initialize variable to hold number and to combine with previous numeral
        int numeral = 0;
        boolean combinedNumeral = false;

        // Loop through all characters
        for (int i = 0; i < s.length(); i++) {
            // Add current char's value
            char currentChar = s.charAt(i);
            switch (currentChar) {
                case 'I':
                    numeral++;
                    break;
                case 'V':
                    numeral += 5;
                    break;
                case 'X':
                    numeral += 10;
                    break;
                case 'L':
                    numeral += 50;
                    break;
                case 'C':
                    numeral += 100;
                    break;
                case 'D':
                    numeral += 500;
                    break;
                case 'M':
                    numeral += 1000;
                    break;
            }

            // Check if previous numeral can subtract from current
            combinedNumeral = i > 0 && (s.charAt(i-1) == 'I' || s.charAt(i-1) ==  'X' || s.charAt(i-1) == 'C');

            // If we can, subtract according to the previous and current character
            if (combinedNumeral) {
                char prevChar = s.charAt(i-1);
                switch (prevChar) {
                    case 'I':
                        if (currentChar == 'V' || currentChar == 'X') numeral -= 2;
                        break;
                    case 'X':
                        if (currentChar == 'L' || currentChar == 'C') numeral -= 20;
                        break;
                    case 'C':
                        if (currentChar == 'D' || currentChar == 'M') numeral -= 200;
                        break;
                }
            }
        }

        // Return the accumulated numeral
        return numeral;
    }
}