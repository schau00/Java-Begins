public class RP {
    public static int c = 0 ;
    public static void revesPuzzle(int n, char A, char B, char C, char D) {
        if (n == 1) {
            System.out.println("Move disc " + n + " from " + A + " to " + D);
            c ++ ;
            return;
        }
        int k = (int) Math.round(1.0 + n - Math.sqrt(1.0 + 2 * n));
        revesPuzzle(k, A, D, C, B);
        hanoi(n - k, A, C, D);
        revesPuzzle(k, B, A, C, D);
    }

    public static void hanoi(int n, char start, char mid, char end) {
        if (n > 0) {
            hanoi(n - 1, start, end, mid);
            System.out.println("Move disc " + n + " from " + start + " to " + end);
            c ++ ;
            hanoi(n - 1, mid, start, end);
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        revesPuzzle(n, 'A', 'B', 'C', 'D');

        // System.out.println(c);
    }
}
