
public class AudioCollage {

    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha){
        double[] b = new double [a.length] ;
        for(int i=0 ;i< a.length;i++){
            b[i] = alpha * a[i] ;
        }

        return b ;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a){
        int n = a.length;
        double[] b = new double[n];
        for(int i =0;i<n;i++){
            b[i] = a[n-i-1] ;
        }

        return b ;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b){
        int n = a.length ;
        int m = b.length ;
        double[] c = new double[m+n] ;
        for(int i=0;i<n;i++){
            c[i] = a[i] ;
        }
        for(int i =n;i<n+m;i++){
            c[i] = b[i-n] ;
        }

        return c ;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b){
        int n = a.length;
        int m = b.length;
        double[] c = new double[Math.max(n, m)];
        
            for(int i = 0;i<n;i++){
                c[i] += a[i] ;
            }
            for(int i = 0; i < m;i++){
                c[i] += b[i] ;
            }
        
        return c ;
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha){
        int n = a.length ;
        int m = (int) (n/alpha) ;

        double[] b = new double[m];
        for(int i=0;i<m;i++){
            b[i] = a[(int) ((i+1)*alpha)] ;
        }

        return b ;


    }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args){
        double[] a = StdAudio.read("beatbox.wav");
        double[] a1 = StdAudio.read("cow.wav");
        double[] b,c,d,e,f ;
        b = amplify(a, 0.5);
        StdAudio.play(b);
        c = reverse(a);
        StdAudio.play(c);
        d = merge(a,a1);
        StdAudio.play(d);
        e = mix(a,a1);
        StdAudio.play(e);
        f = changeSpeed(a, 0.6);
        StdAudio.play(f);
    }
}