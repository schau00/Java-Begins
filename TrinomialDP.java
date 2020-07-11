
public class TrinomialDP{
  
  
  public static long trinomial(int n,int k){
     // long x = -1000 ; 
      n = Math.abs(n);
      k = Math.abs(k);
     int t = Math.max(n, k) ;
     long dp[][] = new long[t+100][t+100] ;
     for(int i=0;i<=t;i++){
       for(int j=0;j<=t;j++){
           //dp[i][j] = trinomial(i,j); 
           if(i == 0 && j == 0){
               dp[i][j] = 1;
           }
           else if(j > i){
               dp[i][j] = 0;
           }
           else{
               dp[i][j] = dp[Math.abs(i-1)][Math.abs(j-1)] + dp[Math.abs(i-1)][j] + dp[Math.abs(i-1)][j+1] ;
           }
       }
     }

     return dp[n][k];

  }


  public static void main(String[] args) {
      int n = Integer.parseInt(args[0]);
      int k = Integer.parseInt(args[1]);
      

      StdOut.println(trinomial(n, k));
  }
}