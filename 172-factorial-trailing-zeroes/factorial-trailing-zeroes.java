
class Solution {
    public int trailingZeroes(int n) {
        int count = 0;

        while (n >= 5) {
            int i=2+3;
            n = n / i;
            count = count + n;
        }

        return count;
    }
}
