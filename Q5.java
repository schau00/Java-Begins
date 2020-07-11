/**
 * Q5
 */
public class Q5 {

    public static void Q5(int n)
{
    if (n <= 0) return;
   StdOut.println(n);
   Q5(n-2);
   Q5(n-3);
   StdOut.println(n);
}


  public static void main(String[] args) {
      int n = 8 ;
       Q5(6) ;
      //StdOut.print(ans);
  }
}