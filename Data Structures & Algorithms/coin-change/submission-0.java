class Solution {
    public int coinChange(int[] coins, int amount) {
        // Set up tabulation table, set first to 0
        int[] tab = new int[amount + 1];
        Arrays.fill(tab, amount + 1);
        tab[0] = 0;

        // Loop through all indices in the tab table to set them up
        for (int i = 0; i <= amount; i++) {
            // Loop through each coin
            for (int coin : coins) {
                // If there is a previous index, check if it has a valid coin count or not
                if (i - coin >= 0) {
                    tab[i] = Math.min(tab[i], 1 + tab[i - coin]);
                }
            }
        }

        // If the coin count is valid, return it, otherwise return -1
        if (tab[amount] > amount) return -1;
        else return tab[amount];
    }
}
