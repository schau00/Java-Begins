

public class Ramanujan {

    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n){
        double k =  Math.floor(Math.cbrt(n));
        // StdOut.println(k);
        int c = 0 ;
        // k = k/2 ;
        for(long i=1;i<=k;i++){
            double x = (Math.cbrt(n - Math.pow(i, 3))) ;
            // StdOut.println(x);
            if(x % 1 == 0){
                c ++ ;
               // StdOut.println(c);
            } 
        }

        if(c >= 4){
            return true ;
        }
        else{
            return false ;
        }
    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args){
        long n = Long.parseLong(args[0]);

        boolean ans = isRamanujan(n);

        StdOut.println(ans);
    }
}