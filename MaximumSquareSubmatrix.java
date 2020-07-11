

public class MaximumSquareSubmatrix {

    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] a){
        int n = a.length;
        int m = a[0].length;
       int [][] dp = new int[n][m] ;
       int mx = -1 ;
       for(int i =0;i<m;i++){
           dp[0][i] = a[0][i];
       }
       for(int i=0;i<n;i++){
           dp[i][0] = a[i][0]; 
       }
       for(int i=1;i<n;i++){
           for(int j=1;j<m;j++){
               if(a[i][j] == 1){
                   dp[i][j] = 1 + Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
               }
               else{
                   dp[i][j] = 0 ;
               }

               mx = Math.max(dp[i][j], mx) ;
           }
       }

       return mx ;
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args){
         int n = StdIn.readInt();
         int [][] a = new int [n][n];
         for(int i =0;i<n;i++){
             for(int j = 0;j<n;j++){
                 a[i][j] = StdIn.readInt();
             }
         }

         StdOut.println(size(a));

    }
}