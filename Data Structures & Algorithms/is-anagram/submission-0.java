class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        // Count the frequency of each character in the first string
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Decrease the frequency count for each character in the second string
        for (char c : t.toCharArray()){
            if (!map.containsKey(c)) {
                return false; // Character not found in the first string
            }
            else{
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    map.remove(c); // Remove the character from the map if its count reaches zero
                }
            }
        }

        // If the map is empty, it means all characters matched and their counts are equal
        return map.isEmpty();
    }
}
