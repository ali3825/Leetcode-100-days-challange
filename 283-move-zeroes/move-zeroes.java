class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;

        // Put all non-zero numbers at the front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }

        // Fill the rest with zeros
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
