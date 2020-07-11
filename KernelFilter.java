import java.awt.Color;

public class KernelFilter {

    // Returns a new picture that applies the identity filter to the given picture.
    public static Picture identity(Picture picture){
        double [][] kernel = {{0,0,0},{0,1,0},{0,0,0}};
        int h = picture.height();
        int w = picture.width();
        //int [][] p = new int [h][w];
        Picture p = new Picture(picture) ;
        Picture s = new Picture(picture) ;
        
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){

               // p.set(i, j, Colo);; = (int)Math.round((p[(i-1+h)%h][(j-1+w)%w] * kernel[0][0]) + (p[(i-1+h)%h][(j+w)%w] * kernel[0][1]) + p[(i-1+h)%h][(j+1+w)%w] * kernel[0][2] + p[(i+h)%h][(j-1+w)%w] * kernel[1][0] + p[(i+h)%h][(j+w)%w] * kernel[1][1] + p[(i+h)%h][(j+1+w)%w] * kernel[1][2] + p[(i+1+h)%h][(j-1+w)%w] * kernel[2][0] + p[(i+1+h)%h][(j+w)%w] * kernel[2][1] + p[(i+1+h)%h][(j+1+w)%w] * kernel[2][2]) ;
                  
                //   Color color = p.get(j, i);
                //   int r = color.getRed();
                //   int g = color.getGreen();
                //   int b = color.getBlue();

                  int newred = (int) Math.round( (p.get((j-1+w)%w, (i-1+h)%h).getRed() * kernel[0][0]) + (p.get((j+w)%w, (i-1+h)%h).getRed() * kernel[0][1]) + (p.get((j+1+w)%w, (i-1+h)%h).getRed() * kernel[0][2]) + 
                   (p.get((j-1+w)%w, (i+h)%h).getRed() * kernel[1][0])  + (p.get((j+w)%w, (i+h)%h).getRed() * kernel[1][1]) + (p.get((j+1+w)%w, (i+h)%h).getRed() * kernel[1][2]) + 
                  (p.get((j-1+w)%w, (i+1+h)%h).getRed() * kernel[2][0]) + (p.get((j+w)%w, (i+1+h)%h).getRed() * kernel[2][1]) + (p.get((j+1+w)%w, (i+1+h)%h).getRed() * kernel[2][2])    
                  ) ;

                  int newgreen = (int) Math.round( (p.get((j-1+w)%w, (i-1+h)%h).getGreen() * kernel[0][0]) + (p.get((j+w)%w, (i-1+h)%h).getGreen() * kernel[0][1]) + (p.get((j+1+w)%w, (i-1+h)%h).getGreen() * kernel[0][2]) + 
                   (p.get((j-1+w)%w, (i+h)%h).getGreen() * kernel[1][0])  + (p.get((j+w)%w, (i+h)%h).getGreen() * kernel[1][1]) + (p.get((j+1+w)%w, (i+h)%h).getGreen() * kernel[1][2]) + 
                  (p.get((j-1+w)%w, (i+1+h)%h).getGreen() * kernel[2][0]) + (p.get((j+w)%w, (i+1+h)%h).getGreen() * kernel[2][1]) + (p.get((j+1+w)%w, (i+1+h)%h).getGreen() * kernel[2][2])    
                  ) ;

                  int newblue = (int) Math.round( (p.get((j-1+w)%w, (i-1+h)%h).getBlue() * kernel[0][0]) + (p.get((j+w)%w, (i-1+h)%h).getBlue() * kernel[0][1]) + (p.get((j+1+w)%w, (i-1+h)%h).getBlue() * kernel[0][2]) + 
                   (p.get((j-1+w)%w, (i+h)%h).getBlue() * kernel[1][0])  + (p.get((j+w)%w, (i+h)%h).getBlue() * kernel[1][1]) + (p.get((j+1+w)%w, (i+h)%h).getBlue() * kernel[1][2]) + 
                  (p.get((j-1+w)%w, (i+1+h)%h).getBlue() * kernel[2][0]) + (p.get((j+w)%w, (i+1+h)%h).getBlue() * kernel[2][1]) + (p.get((j+1+w)%w, (i+1+h)%h).getBlue() * kernel[2][2])    
                  )  ;

                  if(newred <= 0){
                    newred = 0 ;
                }
                if(newred >= 255){
                    newred = 255 ;
                }

                if(newblue <= 0){
                    newblue = 0 ;
                }
                if(newblue >= 255){
                    newblue = 255 ;
                }

                if(newgreen <= 0){
                    newgreen = 0 ;
                }
                if(newgreen >= 255){
                    newgreen = 255 ;

                }

                  Color newcolor = new Color (newred,newgreen,newblue);
                  s.set(j, i, newcolor);


                

                
            }
        }


        return s ;


    }

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
     public static Picture gaussian(Picture picture){
         double a1 = 1.00 / 16 ;
         double a2 = 2.00 /16 ;
         double a3 = 4.00 / 16 ;
        // StdOut.println(a1 + " "+a2+" "+a3);
        double kernel[][] = {{a1,a2,a1},{a2,a3,a2},{a1,a2,a1}};
         //double [][] kernel = {{(1/16),(2/16),(1/16)},{(2/16),(4/16),(2/16)},{(1/16),(2/16),(1/16)}};
        int h = picture.height();
        int w = picture.width();
        //int [][] p = new int [h][w];
        Picture p = new Picture(picture) ;
        Picture s = new Picture(picture) ;
        
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){

               // p.set(i, j, Colo);; = (int)Math.round((p[(i-1+h)%h][(j-1+w)%w] * kernel[0][0]) + (p[(i-1+h)%h][(j+w)%w] * kernel[0][1]) + p[(i-1+h)%h][(j+1+w)%w] * kernel[0][2] + p[(i+h)%h][(j-1+w)%w] * kernel[1][0] + p[(i+h)%h][(j+w)%w] * kernel[1][1] + p[(i+h)%h][(j+1+w)%w] * kernel[1][2] + p[(i+1+h)%h][(j-1+w)%w] * kernel[2][0] + p[(i+1+h)%h][(j+w)%w] * kernel[2][1] + p[(i+1+h)%h][(j+1+w)%w] * kernel[2][2]) ;
                  
                //   Color color = p.get(j, i);
                //   int r = color.getRed();
                //   int g = color.getGreen();
                //   int b = color.getBlue();

                  int newred = (int) Math.round( (p.get((j-1+w)%w, (i-1+h)%h).getRed() * kernel[0][0]) + (p.get((j+w)%w, (i-1+h)%h).getRed() * kernel[0][1]) + (p.get((j+1+w)%w, (i-1+h)%h).getRed() * kernel[0][2]) + 
                   (p.get((j-1+w)%w, (i+h)%h).getRed() * kernel[1][0])  + (p.get((j+w)%w, (i+h)%h).getRed() * kernel[1][1]) + (p.get((j+1+w)%w, (i+h)%h).getRed() * kernel[1][2]) + 
                  (p.get((j-1+w)%w, (i+1+h)%h).getRed() * kernel[2][0]) + (p.get((j+w)%w, (i+1+h)%h).getRed() * kernel[2][1]) + (p.get((j+1+w)%w, (i+1+h)%h).getRed() * kernel[2][2])    
                  ) ;

                  int newgreen = (int) Math.round( (p.get((j-1+w)%w, (i-1+h)%h).getGreen() * kernel[0][0]) + (p.get((j+w)%w, (i-1+h)%h).getGreen() * kernel[0][1]) + (p.get((j+1+w)%w, (i-1+h)%h).getGreen() * kernel[0][2]) + 
                   (p.get((j-1+w)%w, (i+h)%h).getGreen() * kernel[1][0])  + (p.get((j+w)%w, (i+h)%h).getGreen() * kernel[1][1]) + (p.get((j+1+w)%w, (i+h)%h).getGreen() * kernel[1][2]) + 
                  (p.get((j-1+w)%w, (i+1+h)%h).getGreen() * kernel[2][0]) + (p.get((j+w)%w, (i+1+h)%h).getGreen() * kernel[2][1]) + (p.get((j+1+w)%w, (i+1+h)%h).getGreen() * kernel[2][2])    
                  ) ;

                  int newblue = (int) Math.round( (p.get((j-1+w)%w, (i-1+h)%h).getBlue() * kernel[0][0]) + (p.get((j+w)%w, (i-1+h)%h).getBlue() * kernel[0][1]) + (p.get((j+1+w)%w, (i-1+h)%h).getBlue() * kernel[0][2]) + 
                   (p.get((j-1+w)%w, (i+h)%h).getBlue() * kernel[1][0])  + (p.get((j+w)%w, (i+h)%h).getBlue() * kernel[1][1]) + (p.get((j+1+w)%w, (i+h)%h).getBlue() * kernel[1][2]) + 
                  (p.get((j-1+w)%w, (i+1+h)%h).getBlue() * kernel[2][0]) + (p.get((j+w)%w, (i+1+h)%h).getBlue() * kernel[2][1]) + (p.get((j+1+w)%w, (i+1+h)%h).getBlue() * kernel[2][2])    
                  )  ;

                  if(newred <= 0){
                    newred = 0 ;
                }
                if(newred >= 255){
                    newred = 255 ;
                }

                if(newblue <= 0){
                    newblue = 0 ;
                }
                if(newblue >= 255){
                    newblue = 255 ;
                }

                if(newgreen <= 0){
                    newgreen = 0 ;
                }
                if(newgreen >= 255){
                    newgreen = 255 ;

                }

                  Color newcolor = new Color (newred,newgreen,newblue);
                  s.set(j, i, newcolor);


                

                
            }
        }


        return s ;
     }

    // // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture){
        double [][] kernel = {{0,-1,0},{-1,5,-1},{0,-1,0}};
        int h = picture.height();
        int w = picture.width();
        //int [][] p = new int [h][w];
        Picture p = new Picture(picture) ;
        Picture s = new Picture(picture) ;
        
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){

               // p.set(i, j, Colo);; = (int)Math.round((p[(i-1+h)%h][(j-1+w)%w] * kernel[0][0]) + (p[(i-1+h)%h][(j+w)%w] * kernel[0][1]) + p[(i-1+h)%h][(j+1+w)%w] * kernel[0][2] + p[(i+h)%h][(j-1+w)%w] * kernel[1][0] + p[(i+h)%h][(j+w)%w] * kernel[1][1] + p[(i+h)%h][(j+1+w)%w] * kernel[1][2] + p[(i+1+h)%h][(j-1+w)%w] * kernel[2][0] + p[(i+1+h)%h][(j+w)%w] * kernel[2][1] + p[(i+1+h)%h][(j+1+w)%w] * kernel[2][2]) ;
                  
                //   Color color = p.get(j, i);
                //   int r = color.getRed();
                //   int g = color.getGreen();
                //   int b = color.getBlue();

                  int newred = (int) Math.round( (p.get((j-1+w)%w, (i-1+h)%h).getRed() * kernel[0][0]) + (p.get((j+w)%w, (i-1+h)%h).getRed() * kernel[0][1]) + (p.get((j+1+w)%w, (i-1+h)%h).getRed() * kernel[0][2]) + 
                   (p.get((j-1+w)%w, (i+h)%h).getRed() * kernel[1][0])  + (p.get((j+w)%w, (i+h)%h).getRed() * kernel[1][1]) + (p.get((j+1+w)%w, (i+h)%h).getRed() * kernel[1][2]) + 
                  (p.get((j-1+w)%w, (i+1+h)%h).getRed() * kernel[2][0]) + (p.get((j+w)%w, (i+1+h)%h).getRed() * kernel[2][1]) + (p.get((j+1+w)%w, (i+1+h)%h).getRed() * kernel[2][2])    
                  ) ;

                  int newgreen = (int) Math.round( (p.get((j-1+w)%w, (i-1+h)%h).getGreen() * kernel[0][0]) + (p.get((j+w)%w, (i-1+h)%h).getGreen() * kernel[0][1]) + (p.get((j+1+w)%w, (i-1+h)%h).getGreen() * kernel[0][2]) + 
                   (p.get((j-1+w)%w, (i+h)%h).getGreen() * kernel[1][0])  + (p.get((j+w)%w, (i+h)%h).getGreen() * kernel[1][1]) + (p.get((j+1+w)%w, (i+h)%h).getGreen() * kernel[1][2]) + 
                  (p.get((j-1+w)%w, (i+1+h)%h).getGreen() * kernel[2][0]) + (p.get((j+w)%w, (i+1+h)%h).getGreen() * kernel[2][1]) + (p.get((j+1+w)%w, (i+1+h)%h).getGreen() * kernel[2][2])    
                  ) ;

                  int newblue = (int) Math.round( (p.get((j-1+w)%w, (i-1+h)%h).getBlue() * kernel[0][0]) + (p.get((j+w)%w, (i-1+h)%h).getBlue() * kernel[0][1]) + (p.get((j+1+w)%w, (i-1+h)%h).getBlue() * kernel[0][2]) + 
                   (p.get((j-1+w)%w, (i+h)%h).getBlue() * kernel[1][0])  + (p.get((j+w)%w, (i+h)%h).getBlue() * kernel[1][1]) + (p.get((j+1+w)%w, (i+h)%h).getBlue() * kernel[1][2]) + 
                  (p.get((j-1+w)%w, (i+1+h)%h).getBlue() * kernel[2][0]) + (p.get((j+w)%w, (i+1+h)%h).getBlue() * kernel[2][1]) + (p.get((j+1+w)%w, (i+1+h)%h).getBlue() * kernel[2][2])    
                  )  ;

                  if(newred <= 0){
                      newred = 0 ;
                  }
                  if(newred >= 255){
                      newred = 255 ;
                  }

                  if(newblue <= 0){
                      newblue = 0 ;
                  }
                  if(newblue >= 255){
                      newblue = 255 ;
                  }

                  if(newgreen <= 0){
                      newgreen = 0 ;
                  }
                  if(newgreen >= 255){
                      newgreen = 255 ;

                  }

                  Color newcolor = new Color (newred,newgreen,newblue);
                  s.set(j, i, newcolor);


                

                
            }
        }


        return s ;
    }

    // // Returns a new picture that applies an Laplacian filter to the given picture.
     public static Picture laplacian(Picture picture){
         double a1 = -1 * 1.00 ;
         double a2 = 8.00 ;
        double [][] kernel = {{a1,a1,a1},{a1,a2,a1},{a1,a1,a1}};
        int h = picture.height();
        int w = picture.width();
        //int [][] p = new int [h][w];
        Picture p = new Picture(picture) ;
        Picture s = new Picture(picture) ;
        
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){

               // p.set(i, j, Colo);; = (int)Math.round((p[(i-1+h)%h][(j-1+w)%w] * kernel[0][0]) + (p[(i-1+h)%h][(j+w)%w] * kernel[0][1]) + p[(i-1+h)%h][(j+1+w)%w] * kernel[0][2] + p[(i+h)%h][(j-1+w)%w] * kernel[1][0] + p[(i+h)%h][(j+w)%w] * kernel[1][1] + p[(i+h)%h][(j+1+w)%w] * kernel[1][2] + p[(i+1+h)%h][(j-1+w)%w] * kernel[2][0] + p[(i+1+h)%h][(j+w)%w] * kernel[2][1] + p[(i+1+h)%h][(j+1+w)%w] * kernel[2][2]) ;
                  
                //   Color color = p.get(j, i);
                //   int r = color.getRed();
                //   int g = color.getGreen();
                //   int b = color.getBlue();

                  int newred = (int) Math.round( (p.get((j-1+w)%w, (i-1+h)%h).getRed() * kernel[0][0]) + (p.get((j+w)%w, (i-1+h)%h).getRed() * kernel[0][1]) + (p.get((j+1+w)%w, (i-1+h)%h).getRed() * kernel[0][2]) + 
                   (p.get((j-1+w)%w, (i+h)%h).getRed() * kernel[1][0])  + (p.get((j+w)%w, (i+h)%h).getRed() * kernel[1][1]) + (p.get((j+1+w)%w, (i+h)%h).getRed() * kernel[1][2]) + 
                  (p.get((j-1+w)%w, (i+1+h)%h).getRed() * kernel[2][0]) + (p.get((j+w)%w, (i+1+h)%h).getRed() * kernel[2][1]) + (p.get((j+1+w)%w, (i+1+h)%h).getRed() * kernel[2][2])    
                  ) ;

                  int newgreen = (int) Math.round( (p.get((j-1+w)%w, (i-1+h)%h).getGreen() * kernel[0][0]) + (p.get((j+w)%w, (i-1+h)%h).getGreen() * kernel[0][1]) + (p.get((j+1+w)%w, (i-1+h)%h).getGreen() * kernel[0][2]) + 
                   (p.get((j-1+w)%w, (i+h)%h).getGreen() * kernel[1][0])  + (p.get((j+w)%w, (i+h)%h).getGreen() * kernel[1][1]) + (p.get((j+1+w)%w, (i+h)%h).getGreen() * kernel[1][2]) + 
                  (p.get((j-1+w)%w, (i+1+h)%h).getGreen() * kernel[2][0]) + (p.get((j+w)%w, (i+1+h)%h).getGreen() * kernel[2][1]) + (p.get((j+1+w)%w, (i+1+h)%h).getGreen() * kernel[2][2])    
                  ) ;

                  int newblue = (int) Math.round( (p.get((j-1+w)%w, (i-1+h)%h).getBlue() * kernel[0][0]) + (p.get((j+w)%w, (i-1+h)%h).getBlue() * kernel[0][1]) + (p.get((j+1+w)%w, (i-1+h)%h).getBlue() * kernel[0][2]) + 
                   (p.get((j-1+w)%w, (i+h)%h).getBlue() * kernel[1][0])  + (p.get((j+w)%w, (i+h)%h).getBlue() * kernel[1][1]) + (p.get((j+1+w)%w, (i+h)%h).getBlue() * kernel[1][2]) + 
                  (p.get((j-1+w)%w, (i+1+h)%h).getBlue() * kernel[2][0]) + (p.get((j+w)%w, (i+1+h)%h).getBlue() * kernel[2][1]) + (p.get((j+1+w)%w, (i+1+h)%h).getBlue() * kernel[2][2])    
                  )  ;

                  if(newred <= 0){
                      newred = 0 ;
                  }
                  if(newred >= 255){
                      newred = 255 ;
                  }

                  if(newblue <= 0){
                      newblue = 0 ;
                  }
                  if(newblue >= 255){
                      newblue = 255 ;
                  }

                  if(newgreen <= 0){
                      newgreen = 0 ;
                  }
                  if(newgreen >= 255){
                      newgreen = 255 ;

                  }

                  Color newcolor = new Color (newred,newgreen,newblue);
                  s.set(j, i, newcolor);


                

                
            }
        }


        return s ;
     }

    // // Returns a new picture that applies an emboss filter to the given picture.
     public static Picture emboss(Picture picture){
        double [][] kernel = {{-2,-1,0},{-1,1,1},{0,1,2}};
        int h = picture.height();
        int w = picture.width();
        //int [][] p = new int [h][w];
        Picture p = new Picture(picture) ;
        Picture s = new Picture(picture) ;
        
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){

               // p.set(i, j, Colo);; = (int)Math.round((p[(i-1+h)%h][(j-1+w)%w] * kernel[0][0]) + (p[(i-1+h)%h][(j+w)%w] * kernel[0][1]) + p[(i-1+h)%h][(j+1+w)%w] * kernel[0][2] + p[(i+h)%h][(j-1+w)%w] * kernel[1][0] + p[(i+h)%h][(j+w)%w] * kernel[1][1] + p[(i+h)%h][(j+1+w)%w] * kernel[1][2] + p[(i+1+h)%h][(j-1+w)%w] * kernel[2][0] + p[(i+1+h)%h][(j+w)%w] * kernel[2][1] + p[(i+1+h)%h][(j+1+w)%w] * kernel[2][2]) ;
                  
                //   Color color = p.get(j, i);
                //   int r = color.getRed();
                //   int g = color.getGreen();
                //   int b = color.getBlue();

                  int newred = (int) Math.round( (p.get((j-1+w)%w, (i-1+h)%h).getRed() * kernel[0][0]) + (p.get((j+w)%w, (i-1+h)%h).getRed() * kernel[0][1]) + (p.get((j+1+w)%w, (i-1+h)%h).getRed() * kernel[0][2]) + 
                   (p.get((j-1+w)%w, (i+h)%h).getRed() * kernel[1][0])  + (p.get((j+w)%w, (i+h)%h).getRed() * kernel[1][1]) + (p.get((j+1+w)%w, (i+h)%h).getRed() * kernel[1][2]) + 
                  (p.get((j-1+w)%w, (i+1+h)%h).getRed() * kernel[2][0]) + (p.get((j+w)%w, (i+1+h)%h).getRed() * kernel[2][1]) + (p.get((j+1+w)%w, (i+1+h)%h).getRed() * kernel[2][2])    
                  ) ;

                  int newgreen = (int) Math.round( (p.get((j-1+w)%w, (i-1+h)%h).getGreen() * kernel[0][0]) + (p.get((j+w)%w, (i-1+h)%h).getGreen() * kernel[0][1]) + (p.get((j+1+w)%w, (i-1+h)%h).getGreen() * kernel[0][2]) + 
                   (p.get((j-1+w)%w, (i+h)%h).getGreen() * kernel[1][0])  + (p.get((j+w)%w, (i+h)%h).getGreen() * kernel[1][1]) + (p.get((j+1+w)%w, (i+h)%h).getGreen() * kernel[1][2]) + 
                  (p.get((j-1+w)%w, (i+1+h)%h).getGreen() * kernel[2][0]) + (p.get((j+w)%w, (i+1+h)%h).getGreen() * kernel[2][1]) + (p.get((j+1+w)%w, (i+1+h)%h).getGreen() * kernel[2][2])    
                  ) ;

                  int newblue = (int) Math.round( (p.get((j-1+w)%w, (i-1+h)%h).getBlue() * kernel[0][0]) + (p.get((j+w)%w, (i-1+h)%h).getBlue() * kernel[0][1]) + (p.get((j+1+w)%w, (i-1+h)%h).getBlue() * kernel[0][2]) + 
                   (p.get((j-1+w)%w, (i+h)%h).getBlue() * kernel[1][0])  + (p.get((j+w)%w, (i+h)%h).getBlue() * kernel[1][1]) + (p.get((j+1+w)%w, (i+h)%h).getBlue() * kernel[1][2]) + 
                  (p.get((j-1+w)%w, (i+1+h)%h).getBlue() * kernel[2][0]) + (p.get((j+w)%w, (i+1+h)%h).getBlue() * kernel[2][1]) + (p.get((j+1+w)%w, (i+1+h)%h).getBlue() * kernel[2][2])    
                  )  ;

                  if(newred <= 0){
                      newred = 0 ;
                  }
                  if(newred >= 255){
                      newred = 255 ;
                  }

                  if(newblue <= 0){
                      newblue = 0 ;
                  }
                  if(newblue >= 255){
                      newblue = 255 ;
                  }

                  if(newgreen <= 0){
                      newgreen = 0 ;
                  }
                  if(newgreen >= 255){
                      newgreen = 255 ;

                  }

                  Color newcolor = new Color (newred,newgreen,newblue);
                  s.set(j, i, newcolor);


                

                
            }
        }


        return s ;
     }

    // // Returns a new picture that applies a motion blur filter to the given picture.
     public static Picture motionBlur(Picture picture){
        double d = 1.00/9 ;
        int h = picture.height();
        int w = picture.width();

        Picture p = new Picture(picture);
        Picture s = new Picture(picture) ;
        
        for(int i = 0;i<h;i++){
            for(int j=0;j<w;j++){
                int newred = p.get(j, i).getRed() ;
                int newgreen = p.get(j, i).getGreen();
                int newblue = p.get(j,i).getBlue();
                for(int k = 1;k<=4;k++){
                    newred += (p.get((j+k+w)%w, (i+k+h)%h).getRed() + p.get((j-k+w)%w, (i-k+h)%h).getRed() ) ;
                    newgreen += (p.get((j+k+w)%w, (i+k+h)%h).getGreen() + p.get((j-k+w)%w, (i-k+h)%h).getGreen() ) ;
                    newblue += (p.get((j+k+w)%w, (i+k+h)%h).getBlue() + p.get((j-k+w)%w, (i-k+h)%h).getBlue() ) ;
                }
                newred = (int)(Math.round(newred*d));
                newblue = (int) (Math.round(newblue*d));
                newgreen = (int)(Math.round(newgreen*d));

                if(newred <= 0){
                    newred = 0 ;
                }
                if(newred >= 255){
                    newred = 255 ;
                }

                if(newblue <= 0){
                    newblue = 0 ;
                }
                if(newblue >= 255){
                    newblue = 255 ;
                }

                if(newgreen <= 0){
                    newgreen = 0 ;
                }
                if(newgreen >= 255){
                    newgreen = 255 ;

                }

                Color col = new Color(newred, newgreen, newblue);
                s.set(j, i, col);

            }
        }

        return s ;


     }

    // Test client (ungraded).
    public static void main(String[] args){
       Picture pic = new Picture(args[0]);
       
       Picture identitypic = new Picture(identity(pic)) ;
       Picture gausspic = new Picture(gaussian(pic));
       Picture sharpic = new Picture(sharpen(pic));
       Picture lappic = new Picture(laplacian(pic));
       Picture empic = new Picture(emboss(pic));
       Picture mbpic = new Picture(motionBlur(pic));
       
       pic.show();
       identitypic.show();
       gausspic.show();
       sharpic.show();
       lappic.show();
       empic.show();
       mbpic.show();
    } 

}