public class Divisors {

    // Returns the greatest common divisor of a and b.
    public static int gcd(int a, int b){
        a = Math.abs(a);
        b = Math.abs(b);
        int x = Math.max(a, b);
        int y = Math.min(a, b);
        while (y != 0){
            int t = x % y ;
            x = y ;
            y = t ;

        }

        return x ;
    }

    // Returns the least common multiple of a and b.
    public static int lcm(int a, int b){

        return Math.abs(a*b)/gcd(a, b);

    }

    // Returns true if a and b are relatively prime; false otherwise.
    public static boolean areRelativelyPrime(int a, int b){
        if(gcd(a, b) == 1){
            return true ;
        }
        else{
            return false;
        }
    }

    // Returns the number of integers between 1 and n that are
    // relatively prime with n.
    public static int totient(int n){
        int c =0 ;
        for(int i =1 ;i<=n;i++){
            if(gcd(i,n) == 1){
                c ++ ;
            }
        }

        return c ;
    }

    // Takes two integer command-line arguments a and b and prints
    // each function, evaluated in the format (and order) given below.
    public static void main(String[] args){
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        StdOut.println("gcd("+a+", "+b+") = "+gcd(a, b));
        StdOut.println("lcm("+a+", "+b+") = "+lcm(a, b));
        StdOut.println("areRelativelyPrime("+a+", "+b+") = "+areRelativelyPrime(a, b));
        StdOut.println("totient("+a+") = "+totient(a));
        StdOut.println("totient("+b+") = "+totient(b));
    }
}