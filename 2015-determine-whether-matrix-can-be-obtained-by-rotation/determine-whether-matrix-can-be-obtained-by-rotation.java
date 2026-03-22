class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        boolean flag = false;
        for(int k = 0; k < 4; k++){
            rotateMat90(mat);
            outerLoop: for(int i = 0; i < mat.length; i++){
                for(int j = 0; j < mat[0].length; j++){
                    if(mat[i][j] != target[i][j]){
                        flag = false;
                        break outerLoop;
                    } else{
                        flag = true;
                    }
                }

            }
            if(flag){
                return true;
            }

        }
        return false;
    }

    void rotateMat90(int[][] mat){
        // transpose the mat
        for(int i = 0; i < mat.length; i++){
            for(int j = i; j < mat[i].length; j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        // reverse the array in the mat
        for(int[] arr: mat){
            int start = 0;
            int end = arr.length - 1;
            while(start < end){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
    }
}