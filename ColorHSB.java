

public class ColorHSB {
    
    private int hue , sat , br ;
    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        
        if(h >  359 || h < 0 || s > 100 || s < 0 || b > 100 || b < 0){
            throw new IllegalArgumentException();
       }
        
        hue = h ;
        sat = s ;
        br = b ;
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString(){
        return "("+hue+", "+sat+", "+br+")" ;
    }

    // Is this color a shade of gray?
    public boolean isGrayscale(){
        if(sat == 0 || br == 0){
            return true ;
        }
        else{
            return false ;
        }

    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that){

        int ans = ((int)Math.min(Math.pow((that.hue - hue),2) , Math.pow((360 - Math.abs(that.hue - hue)), 2))  + (int)Math.pow(that.br - br,2) + (int)Math.pow(sat-that.sat, 2)) ;

        return Math.abs(ans) ;

    }

    // Sample client (see below).
    public static void main(String[] args){
        //StdOut.println(args.length);
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        ColorHSB c = new ColorHSB(h, s, b);
        
        In fn = new In (StdIn.readString());
        int hmin = 99999 , smin = 99999999 , bmin = 99999, d = 999999999 ;
        String cname = "" ;
        while(fn.isEmpty() == false){
            String col = fn.readString();
            int hx = fn.readInt();
            int sx = fn.readInt();
            int bx = fn.readInt();  
            ColorHSB cnew = new ColorHSB(hx, sx, bx);

            int dist = cnew.distanceSquaredTo(c);
            //StdOut.println(dist +"---"+col);
            // k = Math.min(k,dist) ;
            // StdOut.println("k ==== "+k);

            if(dist <= d){
                d = dist ;
                hmin = hx ;
                smin = sx ;
                bmin = bx ;
                cname = col ;
            }
            //StdOut.println(cname + "  "+ d);


        }

        StdOut.println(cname + " ("+hmin+", "+smin+", "+bmin+")");

    }

    

}