class Solution {
    public int[][] constructProductMatrix(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int[][] result = new int[n][m];
        long[] pre = new long[n*m];
        long[] post = new long[n*m];
        int mod = 12345;
        pre[0] = grid[0][0];
        post[n*m-1] = grid[n-1][m-1];

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if((i+j) > 0) pre[i*m + j] = (pre[i*m + j - 1]*(grid[i][j]))%mod;
            }
        }

        for(int i = n-1; i >= 0; i--)
        {
            for(int j = m-1; j >= 0; j--)
            {
                if(i == n-1 && j == m-1) continue;
                post[i*m + j] = (post[i*m + j + 1]*grid[i][j])%mod;
            }
        }

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                result[i][j] = (int)((((i+j) > 0 ? pre[i*m+j-1] : 1l)*((i == n-1 && j == m-1) ? 1l : post[i*m+j+1]))%((long)mod));
            }
        }
        return result;
    }
}