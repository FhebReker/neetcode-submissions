class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] newNums = new int[2 * nums.length];
        int index = 0;
        while (index < nums.length) {
            newNums[index] = newNums[index + nums.length] = nums[index];
            index++;
        }

        return newNums;
    }
}