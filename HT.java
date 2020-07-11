/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class HT {
    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        int count = 0;
        int count_temp = 0;
        boolean[] prior_array = new boolean[dna.length()];

        for (int i = 0; i < dna.length() - 3; i++) {
            String sub = dna.substring(i, i + 3);
            if (i > 2) {
                if (sub.equals("CAG") && prior_array[i - 3] == true) {
                    count_temp++;
                    if (count_temp >= count) {
                        count = count_temp;
                    }
                    prior_array[i] = true;
                }
                if (sub.equals("CAG") && prior_array[i - 3] == false) {
                    count_temp = 0;
                    count_temp++;
                    if (count_temp >= count) {
                        count = count_temp;
                    }
                    prior_array[i] = true;
                }
            }
            else {
                if (sub.equals("CAG")) {
                    count_temp = 0;
                    count_temp++;
                    if (count_temp >= count) {
                        count = count_temp;
                    }
                }
            }
        }
        return count;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        String s1 = s.replaceAll("\\s" , "");
        String s2 = s1.replaceAll("\n" , "");
        String s3 = s2.replaceAll("\t" , "");

        return s3;

    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        String s = "";
        if(maxRepeats <= 9) {
            s = "not human";
        }
        if(maxRepeats > 9 && maxRepeats <= 35) {
            s = "normal";
        }
        if(maxRepeats > 35 && maxRepeats <= 39) {
            s = "high risk";
        }
        if(maxRepeats > 39 && maxRepeats <= 180) {
            s = "Huntington's";
        } else {
            s = "not human";
        }
        return s;
    }

    public static void main(String[] args) {
        In query = new In(args[0]);
        String s = query.readAll();

        String dna = removeWhitespace(s);
        // StdOut.print(dna);
        int dna2 = maxRepeats(dna);
        String dna3 = diagnose(maxRepeats(dna));
        System.out.println("max repeats = "+dna2);
        System.out.println(dna3);
        
    }
}
