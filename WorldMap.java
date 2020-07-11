

public class WorldMap {
  public static void main(String[] args) {
      int xmax = StdIn.readInt();
      int ymax = StdIn.readInt();
      StdDraw.setCanvasSize(xmax, ymax);
      StdDraw.setXscale(0, xmax);
      StdDraw.setYscale(0, ymax);
      while(StdIn.isEmpty() == false){
          String s = StdIn.readString();
          int n = StdIn.readInt();
          //StdDraw.polygon(x, y);
          double [] x = new double [n];
          double [] y = new double [n];
          for(int i = 0;i<n;i++){
              x[i] = StdIn.readDouble();
              y[i] = StdIn.readDouble();
          }
      
          StdDraw.polygon(x, y);
      }
  }   
}