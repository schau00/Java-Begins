
  


 public class ActivationFunction {

    // Returns the Heaviside function of x.
    public static double heaviside(double x){
         
        if(x < 0) return 0 ;
        else if(x == 0) return 0.5 ;
        else return 1 ;
     
    }

    // Returns the sigmoid function of x.
    public static double sigmoid(double x){

        double t  = Math.exp(-x);

        t += 1 ;

        return 1/t ;


    }

    // Returns the hyperbolic tangent of x.
    public static double tanh(double x){

        double t1 = Math.exp(x);
        double t2 = Math.exp(-x);

        return (t1-t2)/(t1+t2) ;

    }

    // Returns the softsign function of x.
    public static double softsign(double x){

        return x/(1+ Math.abs(x)) ;

    }

    // Returns the square nonlinearity function of x.
    public static double sqnl(double x){

        if(x <= -2){
            return -1 ;
        }
        else if(x > -2 && x < 0){
            return (x + Math.pow(x, 2)/4) ;
        }
        else if(x >= 0 && x < 2){
            return (x - Math.pow(x, 2)/4) ;
        }
        else{
            return 1 ;
        }
      
    }

    // Takes a double command-line argument x and prints each activation
    // function, evaluated, in the format (and order) given below.
    public static void main(String[] args){

        double x = Double.parseDouble(args[0]);

       // String [] s = {"heaviside","sigmoid","tanh","softsign","sqnl"};

        StdOut.println("heaviside" + '(' + x + ')' + " = " + heaviside(x));
        StdOut.println("sigmoid" + '(' + x + ')' + " = " + sigmoid(x));
        StdOut.println("tanh" + '(' + x + ')' + " = " + tanh(x));
        StdOut.println("softsign" + '(' + x + ')' + " = " + softsign(x));
        StdOut.println("sqnl" + '(' + x + ')' + " = " + sqnl(x));

        

    }


    
}
