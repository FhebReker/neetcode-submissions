class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> listOfCombinations = new ArrayList<>();
        backtrack(listOfCombinations, new ArrayList<>(), nums, 0, target);
        return listOfCombinations;
    }
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int startIndex, int remainingSum) {
        if (remainingSum == 0) list.add(new ArrayList<>(tempList));
        else {
            for (int i = startIndex; i < nums.length; i++) {
                if (nums[i] <= remainingSum) {
                    tempList.add(nums[i]);
                    backtrack(list, tempList, nums, i, remainingSum - nums[i]);
                    tempList.remove(tempList.size() - 1);
                }
            }

        }
    }
}
