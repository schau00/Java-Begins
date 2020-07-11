
// piping
public class IO {
    public static void main(String[] args) {
        
        for(int i = 0;i<3;i++){
            double x = StdIn.readInt() ;
            StdOut.println(x);
        }

    }


}



class Average {
    public static void main(String[] args) {
        double s = 0 ;
        for(int i = 0;i<100;i++){
            s += StdIn.readDouble() ;
        }


        s = s/100 ;

        StdOut.println(s);
    }
}