import java.util.Arrays;
/**
 * BarChartRacer
 */


 class Bar implements Comparable<Bar> {
    private String barname, barcat ;
    private int barvalue  ;

    // Creates a new bar.
    public Bar(String name, int value, String category){
        if(name == null || value < 0 || category == null){
            throw new IllegalArgumentException("hello");
        }
        barname = name;
        barvalue = value ;
        barcat = category;
    }

    // Returns the name of this bar.
    public String getName(){
        return this.barname;
    }

    // Returns the value of this bar.
    public int getValue(){
        return this.barvalue;
    }

    // Returns the category of this bar.
    public String getCategory(){
        return barcat ;
    }

    // Compare two bars by value.
    public int compareTo (Bar that){
        // if(that == null){
        //     NullPointerException nullPointer = new NullPointerException();
        //     throw nullPointer;
        // }
        return (this.getValue() - that.getValue()) ;
    }

    // Sample client (see below).
    

}

public class BarChartRacer {


    

    public static void main(String[] args) { 
        int x = 0;
        StdDraw.enableDoubleBuffering();
        StdDraw.setCanvasSize(1000, 700);
        
        
        StdAudio.loop("UEFA Champions League Theme Song [On Screen] (online-audio-converter.com).wav");
        In fn = new In(args[0]);
        int k = Integer.parseInt(args[1]);
        String title , xaxislabel , datasrc ;
        title = fn.readLine();
        xaxislabel = fn.readLine();
        datasrc = fn.readLine();
        BarChart chart = new BarChart(title, xaxislabel, datasrc);
        while(fn.isEmpty() == false){
           // StdDraw.pause(2);
            //chart.reset();
            String space = fn.readLine();
            int n = Integer.parseInt(fn.readLine());
            Bar bar[] = new Bar [n];
            String label = "" ;
            for(int i=0;i<n;i++){
                String ln = fn.readLine();
                //StdOut.println(ln);
                String [] lnarray = ln.split(",");
                //StdOut.println(lnarray.length);
                String year,name,aCountry,category;
                int value ;
                year = lnarray[0];
                name = lnarray[1];
                aCountry = lnarray[2];
                value = Integer.parseInt(lnarray[3]);
                category = lnarray[4];

                bar[i] = new Bar(name, value, category);
                label = year;
            }
            int xmax = 1 ;
            Arrays.sort(bar);
            for(int i=n-1;i>n-k-1;i--){
                if(bar[i].getValue() <= 0){
                    break ;
                }
                chart.add(bar[i].getName(), bar[i].getValue(), bar[i].getCategory());
                xmax = Math.max(xmax,bar[i].getValue());
            }
            chart.setCaption(label);
            //chart.setMaxValue(xmax);
            StdDraw.pause(50);
            chart.draw();
            StdDraw.show();
            
            
            
            StdDraw.clear();
            x ++ ;
            chart.reset();
            



        }
        //StdOut.print(x);

    }
}