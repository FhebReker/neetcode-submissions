class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] products = new int[nums.length];
        int biggestProduct = 1;
        int zerosInNums = 0;
        boolean changeInNums = false;

        for (int num : nums){
            if (num != 0) {
                biggestProduct *= num;
                changeInNums = true;
            }
            else zerosInNums++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0 && zerosInNums == 0) products[i] = biggestProduct / nums[i];
            else if (zerosInNums > 1 || nums[i] != 0) products[i] = 0;
            else products[i] = biggestProduct;
        }

        return products;
    }
}  
