import java.awt.Color;
public class Luminance {
 public static void main(String[] args) {
     int r = StdIn.readInt();
     int g = StdIn.readInt();
     int b = StdIn.readInt();

     Color c = new Color (r,g,b);

     StdOut.println(c);

     StdDraw.setPenColor(c);

     StdDraw.filledSquare(0.5, 0.5, 0.5);



     StdOut.println(Math.round(lum(c)));
  
     StdDraw.setPenColor(c);

     StdDraw.filledSquare(0.5, 0.5, 0.25);
     
 }   
 public static double lum(Color c){
       int r = c.getRed();
       int b = c.getBlue();
       int g = c.getGreen();

       return  .299*r + .587*g + .114*b;
 }
}