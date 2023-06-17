import java.awt.*; 
import java.util.Random; 
import java.util.Timer; 
import java.util.TimerTask;
     
public class CanvasExample extends TimerTask 
{    

    Timer timer = new Timer(); 
    Frame f = new Frame("Canvas Example"); 
    // class constructor   
    public void run(){
        for(int i = 0; i<f.getComponentCount(); ++i) {
            f.getComponent(i).repaint();
        }
    }

    public CanvasExample()    
    {    
          
        // adding canvas to frame   
        f.add(new MyCanvas());    
    
        // setting layout, size and visibility of frame  
        f.setLayout(null);    
        f.setSize(400, 400);    
        f.setVisible(true);

        timer.schedule(this,100, 100);
    }   
  
  // main method  
  public static void main(String args[])    
  {    
    new CanvasExample();    
  }    
}    
  
// class which inherits the Canvas class  
// to create Canvas  
class MyCanvas extends Canvas    
{    
    int twists = 0;
    
    // class constructor  
    public MyCanvas() {    
        setBackground (Color.BLACK);    
        setSize(400, 400);    
    }    
  
    float R = 0.5f;
    float G = 0.5f;
    float B = 0.5f;

     // paint() method to draw inside the canvas  
    public void paint(Graphics g)    
    {  
        Random rand = new Random();
        R = R+((rand.nextFloat()-0.5f)/30);
        G = G+((rand.nextFloat()-0.5f)/30);
        B = B+((rand.nextFloat()-0.5f)/30);  
        int centerX = getWidth()/2;
        int centerY = getHeight()/2;
        int radius = Math.min(getWidth(), getHeight())/2-50;
        Color randomColor = new Color(R, G, B);
        g.setColor(randomColor); 
        int pointc = 100;
        drawCircle(g, centerX, centerY, radius, twists, pointc);
        for(int i=0; i<radius; i+=1) {
            drawCircle(g, centerX, centerY, radius-(int)(i*1.5),twists+i*3, pointc-((int)i));
        }
        twists++;
    }    

    public void drawCircle(Graphics g, int centerX, int centerY, int radius, int twist, int points){
        double step = 2*Math.PI/points;
        for(int i=0; i<points; i++) {
            double angle = i*step+twist;
            int Xc = (int)Math.round(centerX + radius*Math.cos(angle));
            int Yc = (int)Math.round(centerY + radius*Math.sin(angle));
            g.fillRect(Xc, Yc, 1, 1);    
        }
    }

}       
