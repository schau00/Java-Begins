//`1/*97import java.io.File;

public class Huntingtons {

    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna){
        int rep = 0 ;
        int temp = 0 ;
        for(int i=0;i<dna.length()-2;i++){
            if((dna.substring(i, i+3)).equals("CAG")){
                temp ++ ;
                i += 2 ;
                rep = Math.max(rep,temp);
            }
            else{
                
                temp = 0;
            }
        }

        return rep ;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
     public static String removeWhitespace(String s){
        String s1 = s.replaceAll("\\s" , "");
        String s2 = s1.replaceAll("\n" , "");
        String s3 = s2.replaceAll("\t" , "");

        return s3 ;

     }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats){
        /*
        repeats	diagnosis
                0–9	not human
                10–35	normal
                   36–39	high risk
               40–180  	  Huntington’s  
                 181–	not human
*/

        if(maxRepeats >= 0 && maxRepeats <= 9){
            return "not human" ;
        }
        else if(maxRepeats >= 10 && maxRepeats <= 35){
            return "normal" ;
        }
        else if(maxRepeats >= 36 && maxRepeats <= 39){
            return "high risk" ;
        }
        else if(maxRepeats >= 40 && maxRepeats <= 180){
            return "Huntington's" ;
        }
        else{
            return "not human" ;
        }
    }

    // Sample client (see below).
    public static void main(String[] args){
        In fn = new In(args[0]);
        String dna = fn.readAll();

        StdOut.println(dna);

        dna = removeWhitespace(dna);

        // StdOut.println(dna);

        int maxrep = maxRepeats(dna);

        StdOut.println("max repeats = "+maxrep);

        StdOut.println(diagnose(maxrep));



    }

}
