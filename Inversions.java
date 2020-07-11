
public class Inversions {

    // Return the number of inversions in the permutation a[].
    public static long count(int[] a){
        long c = 0 ;
        int n = a.length;
        for(int i = 0;i<n-1;i++){
            for(int j= i+1;j<n;j++){
                if(a[i] > a[j]){
                    c ++ ;
                }
            }
        }

        return c ;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k){
        int [] a = new int [n+1];
        a[0] = 0 ;
        int s = 1 , e = n ;
        for(int i=n;i>=1;i--){
            if(k >= i-1){
                a[s] = i-1 ;
                k -= (i-1);
                s ++ ;
            }
            else{
                a[e] = i-1 ;
                e -- ;
            }
        }

        return a ;
    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);

        int [] a = generate(n, k);
        for(int i= 1;i<=n;i++){
            StdOut.print(a[i] + " ");
        }
        // StdOut.println();
        // long p = count(a) ;
        // StdOut.println(p);

    }
}