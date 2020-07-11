
public class RevesPuzzle {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        revesPuzzle(n, 'A', 'B', 'C', 'D');

         // System.out.println(c);
    }
    //public static int c = 0 ;
    public static void revesPuzzle(int n, char A, char B, char C, char D) {
        if (n == 1) {
            System.out.println("Move disc " + n + " from " + A + " to " + D);
           // c ++ ;
            return;
        }
        int k = (int) Math.round(1 + n - Math.sqrt(2*n +1));
        revesPuzzle(k, A, D, C, B);
        hanoi(n - k, A, C, D);
        revesPuzzle(k, B, A, C, D);
    }

    public static void hanoi(int n, char from, char mid, char to) {
        if (n > 0) {
            hanoi(n - 1, from, to, mid);
            System.out.println("Move disc " + n + " from " + from + " to " + to);
            // c ++ ;
            hanoi(n - 1, mid, from, to);
        }
    }

    
   

}