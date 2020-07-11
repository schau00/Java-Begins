public class Clock {

    private int hour , min ;

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {

        if(h > 23 || h < 0 || m > 59 || m < 0 ){
            throw new IllegalArgumentException();
        }
        hour = h ;
        min = m ;

        
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s){
           if(s.length() != 5){
               throw new IllegalArgumentException();
           }
           if(!(s.substring(2, 3)).equals(":")){
               StdOut.println(s.substring(2,3));
               throw new IllegalArgumentException();
           }
           
        //    if((s.substring(0,1)).equals("0") && s.substring(0,1) != "1" && s.substring(0,1) != "2" && s.substring(0,1) != "3" && s.substring(0,1) != "4" && s.substring(0,1) != "5" && s.substring(0,1) != "6" && s.substring(0,1) != "7" && s.substring(0,1) != "8" && s.substring(0,1) != "9"){
        //     StdOut.println("01");   
        //     throw new IllegalArgumentException();
        //    }
        //    if(s.substring(1,2) != "0" && s.substring(1,2) != "1" && s.substring(1,2) != "2" && s.substring(1,2) != "3" && s.substring(1,2) != "4" && s.substring(1,2) != "5" && s.substring(1,2) != "6" && s.substring(1,2) != "7" && s.substring(1,2) != "8" && s.substring(1,2) != "9"){
        //     StdOut.println("12");  
        //     throw new IllegalArgumentException();
        //    }
        //    if(s.substring(3,4) != "0" && s.substring(3,4) != "1" && s.substring(3,4) != "2" && s.substring(3,4) != "3" && s.substring(3,4) != "4" && s.substring(3,4) != "5" && s.substring(3,4) != "6" && s.substring(3,4) != "7" && s.substring(3,4) != "8" && s.substring(3,4) != "9"){
        //     StdOut.println("34");  
        //     throw new IllegalArgumentException();
        //    }
        //    if(s.substring(4,5) != "0" && s.substring(4,5) != "1" && s.substring(4,5) != "2" && s.substring(4,5) != "3" && s.substring(4,5) != "4" && s.substring(4,5) != "5" && s.substring(4,5) != "6" && s.substring(4,5) != "7" && s.substring(4,5) != "8" && s.substring(4,5) != "9"){
        //     StdOut.println("45");  
        //     throw new IllegalArgumentException();
        //    }
        boolean check = false ;
           for(int i=0;i<=9;i++){
               if((s.substring(0, 1)).equals(""+i)){
                   check = true ;
                   break ;
               }
           }
           if(!check){
               throw new IllegalArgumentException();
           }
            check = false ;
           for(int i=0;i<=9;i++){
            if((s.substring(1, 2)).equals(""+i)){
                check = true ;
                break ;
            }
        }
        if(!check){
            throw new IllegalArgumentException();
        }

        check = false ;
           for(int i=0;i<=9;i++){
            if((s.substring(3, 4)).equals(""+i)){
                check = true ;
                break ;
            }
        }
        if(!check){
            throw new IllegalArgumentException();
        }

        check = false ;
           for(int i=0;i<=9;i++){
            if((s.substring(4, 5)).equals(""+i)){
                check = true ;
                break ;
            }
        }
        if(!check){
            throw new IllegalArgumentException();
        }


           String t = s.substring(0,2);
           hour = Integer.parseInt(t);
           t = "" ;
           t += s.substring(3, 5);
           min = Integer.parseInt(t);
           // StdOut.println(hour +"---"+min);
           if(hour > 23 || hour < 0 || min > 59 || min < 0){
               
               throw new IllegalArgumentException();
           }
           
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString(){
        String t ="";
        t += hour ;
        if(t.length() == 1){
            t = '0'+t ;
        }
        String t2 = "";
        t2 += min ;
        if(t2.length() == 1){
            t2 = '0'+t2 ;
        }

        return t+":"+t2 ;
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that){
        if(this.hour < that.hour){
            return true ;
        }
        else if(this.hour > that.hour){
            return false ;
        }
        else{
            if(this.min < that.min){
                return true ;
            }
            else{
                return false ;
            }
        }
    }

    // Adds 1 minute to the time on this clock.
    public void tic(){
        min += 1 ;
        if(min == 60){
            min = 0;
            hour ++ ;
            if(hour == 24){
                hour = 0;
            }
        }

    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta){
        if(delta < 0){
            throw new IllegalArgumentException();
        }
        int ha = delta/60 ;
        delta = delta % 60; 
        min += delta ;
        if(min > 59){
            ha ++ ;
            min -= 60 ;
        }
        hour += ha ;
        if(hour > 23){
            hour = hour % 24 ;
        }
    }

    // Test client (see below).
    public static void main(String[] args){
        int h = StdIn.readInt();
        int m = StdIn.readInt();
        Clock c1 = new Clock(h,m);
        StdOut.println(c1.toString());
        String s = StdIn.readString();
        //StdOut.println(s.substring(2, 3));
        Clock c2 = new Clock(s);
        //StdOut.println(c1.toString());
        StdOut.println(c1.isEarlierThan(c2));
        c1.tic();
        c2.toc(1000000);
        StdOut.println(c1.toString());
        StdOut.println(c2.toString());

    }
}