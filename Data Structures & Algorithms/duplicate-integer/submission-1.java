class Solution {
    public boolean hasDuplicate(int[] nums) {
        // Create a HashSet to store unique elements
        Set<Integer> set = new HashSet<>();

        // Iterate through the array and try to add each element to the set
        for (int num:nums){
            // If the element is already in the set, it means we have a duplicate
            if (!set.add(num)){
                return true; // Duplicate found
            }
        }
        
        // If no duplicates were found, return false
        return false; // No duplicates found
    }
}
