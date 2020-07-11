
public class TowerOFHanoi {
 public static void main(String[] args) {
     int n = Integer.parseInt(args[0]) ;
     int k = n + 1 - (int) Math.sqrt(2*n + 1) ;
     TH(n," A "," D "," B "," C ") ;
     //THT(k," A "," D "," C ",n-k) ;
     //TH(n-k," B "," D "," C ") ;
 }   

 public static void TH(int n,String from,String to,String mid,String mid2){
        if(n == 0){
            return ;
        }
        if(n == 1){
            StdOut.println("Move disc "+n+" from"+from+"to"+to);
            return ;
        }

        // TH(n-1, from, mid, mid2,to);
        // StdOut.println("Move disc "+n+" from"+from+"to"+to);
        // TH(n-1, mid, mid2, to,from);
        // StdOut.println("Move disc "+n+" from"+from+"to"+to);
        // TH(n-1,mid2,to,from,mid);
        // StdOut.println("Move disc "+n+" from"+from+"to"+to);


        TH(n-2, from, mid, mid2,to) ; 
                                             
        System.out.println("Move disk " + (n - 1) +  
                           " from rod " + from +  
                           " to rod " + mid2); 
        System.out.println("Move disk " + n +  
                           " from rod " + from +  
                           " to rod " + to); 
        System.out.println("Move disk " + (n - 1) +  
                           " from rod " + mid2 +  
                               " to rod " + to ); 
        TH(n - 2, mid, to, from,  mid2) ;
                                          

 }
//  public static void THT(int n,String from,String to,String mid,int k){
//     if(n == 1){
//         StdOut.println("Move disc "+(n+k)+" from"+from+"to"+to);
//         return ;
//     }

//     THT(n-1, from, mid, to,k);
//     StdOut.println("Move disc "+(n+k)+" from"+from+"to"+to);
//     THT(n-1, mid, to, from,k);
// }
}

