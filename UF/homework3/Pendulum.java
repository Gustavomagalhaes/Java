package homework3;

import java.awt.*;
import java.applet.Applet;

/** Weight behaves like a weight at the end of the pendulum. */
class Weight {
     // Constants.
     public static final Color  WEIGHT_COLOR = Color.blue;
     public static final int    WEIGHT_DIAMETER = 50;
     public static final int    RIGHT = 1;
     public static final int    LEFT  = -1;

     // Instance variables accessible to objects in the same package.
     int                  xpos; 
     int                  ypos;

     // Private instance variables.
     private   int        dir;      // left and right
     private   int        h;
     private   Pendulum   p;
     private   boolean    reverseOk = true;
     private   double     speed;
     private   double     fastestSpeed;

     /** Construct the weight at end of the pendulum. */
     Weight (Pendulum pen) {
        dir      = 0;
        speed    = 0.0;
        fastestSpeed = 0.0;
        xpos     = Cord.CORD_PIVOT_X;
        ypos     = Cord.CORD_PIVOT_Y + 150;
        h        = ypos;
        p        = pen;
     }

     /** The primary method that moves the pendulum a little at a time. */
     public void swing() {
        double    delta;
        double    divisions; 
        double    theta; 

        // Change the angle to move a little.
        divisions = p.cord.getDivisions();
        delta = speed * (Math.PI/divisions) * (double)dir;  

        theta = p.cord.angle + delta;
        // I have a new theta and the same length. Where are we now?

        xpos = (int)(Math.sin(theta) * (double)p.cord.length) + 
                Cord.CORD_PIVOT_X;
        ypos = (int)(Math.cos(theta) * (double)p.cord.length) + 
                Cord.CORD_PIVOT_Y;

        // Is it okay to possibly reverse direction?
        if (sign(theta) != sign(p.cord.angle)) 
            reverseOk = true;

        // Set the cord's new angle with the vertical.
        p.cord.angle = theta;   
        
              // Change the swing's direction if necessary.
        if (ypos < h && reverseOk) {
           dir       = -dir;
           reverseOk = false;
        }

        // Adjust the weight's speed to match the height in its swing.
        speed = newSpeed();
     }

     private double newSpeed() {
        double    ratio;
        ratio = ((double)(ypos - h))/((double)((p.cord.length +
                        Cord.CORD_PIVOT_Y) - h));

        if (ratio < 0.0)
           ratio = 0.0;
        return ((ratio + .1) * fastestSpeed);
     }

     /** Set the weight to where the user drags it. */
     public void newPosition(int x, int y) {
        xpos = x;
        ypos = y;

        // Prepare to swing the in the appropriate direction.
        speed = 0.1;

        if (x < Cord.CORD_PIVOT_X)
            // The user has dragged the weight to the left;
            // prepare to swing right.
            dir = RIGHT;
        else
            // Prepare to swing left.
            dir = LEFT;

        // Tell the cord to update.
        p.cord.newLength(xpos, ypos);

       // Set the initial height.
       h = ypos; 

       // Don't try to reverse the direction of the pendulum's swing
       // until it has swung back through the center.
       reverseOk = false;

       // Acquire a new speed.
       // SQRT(2 * Gravity in m/s/s) length in meters (1 pixel = 1 dm) *
       //         (1 - cos(initial angle)) )
       fastestSpeed = Math.sqrt(2.0 * 10.0 * (double)p.cord.length/10.0 * 
                         (1.0 - Math.cos(p.cord.angle)) );

     }

     /** Draw the weight. */
     public void draw(Graphics g) {
        int radius = WEIGHT_DIAMETER/2;
        g.setColor(WEIGHT_COLOR);  
        g.fillOval(xpos - radius, ypos - radius, WEIGHT_DIAMETER,
                        WEIGHT_DIAMETER);  
     }

     /** Private method to assist with the calculations for swinging. */
     private int sign(double value) {
        if (value > 0) 
           return 1;
        else
           return -1;
     }

}

/** Class cord knows how to behave like a cord in a pendulum. */
class Cord {
    // Constants.
    public static final Color  CORD_COLOR    = Color.black;
    public static final int    CORD_PIVOT_X  = 250;
    public static final int    CORD_PIVOT_Y  = 20;
    public static final double MIN_DIVISIONS = 60.0; 

    // Public instance variables.
    public int      length;
    public double   angle;
    public double   fastestSpeed;
    
    // Other instance variables.
    Pendulum        p;

    /** Construct a cord for the pendulum. */
    Cord (Pendulum pen) {
       length   = 10;
       angle    = 0.0;
       p        = pen;
       fastestSpeed = 20.0;
    }

    /** Calculate a new cord length given a new weight position. */
    public void newLength(int x, int y) {
       double len; 
       double sqx;
       double sqy;

       sqx = (double)(CORD_PIVOT_X - x) * (double)(CORD_PIVOT_X - x);
       sqy = (double)(CORD_PIVOT_Y - y) * (double)(CORD_PIVOT_Y - y);

       // sqx and sqy will never be negative.
       len = Math.sqrt(sqx + sqy); // no exceptions in floating point math 
     
       length = (int)len; 
       newAngle(x);
   }

   /** Calculate the angle between the cord and the vertical. */
   public void newAngle(int x) {
       double opp;

       // The angle will be the arcsin of the opposite side
       // (the x distance) over the hypotenuse (the length).
       opp = (double)(x - CORD_PIVOT_X); // note this can be negative.
       if (Math.abs(opp) < 1.0)
          angle = 0.0;
       else 
          angle = Math.asin(opp/length);
   }
   /** The pendulum moves faster the smaller the cord length. */
   public double getDivisions() {
      if ((double)length < MIN_DIVISIONS)
         return MIN_DIVISIONS;
      else
         return (double)length;
   }

   /** Draw the cord. */
   public void draw(Graphics g) {
      g.setColor(CORD_COLOR);  
      g.drawLine(CORD_PIVOT_X, CORD_PIVOT_Y, p.weight.xpos, p.weight.ypos);
   }

}


/** Controlling class to simulate a pendulum. */
public class Pendulum extends Applet implements Runnable {
   
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Public instance variables.
    public Cord     cord;
    public Weight   weight;
    
    // Private instance variables.
    private Thread  myThread;
    private boolean freeze = true;

    /** Initialize the application. */
    public void init () {
       //resize (500,400);
       cord   = new Cord(this);
       weight = new Weight(this);
    }

    /** Create a thread and make this thread's target the applet. */
    public void start () {
      if (myThread == null) {
         myThread = new Thread(this, "Pendulum");
         myThread.start();
      }
    }

   /** Keep on swinging and redrawing the pendulum. */
   public void run() { 
       while (myThread != null) {

           // slow things down for looks.
           try {
              Thread.sleep(100); // = 1/10th of a second
           } catch (InterruptedException e) {
           }
           
           if (!freeze)
             weight.swing();
           myRepaint();
       }
   }

   /** Stop the pendulum from swinging. */
   @SuppressWarnings("deprecation")
public void stop() {
       myThread.stop();
       myThread = null;
   }

   /** Draw the pieces of the pendulum. */
   public void paint(Graphics g) {
      cord.draw(g);
      weight.draw(g);
      
      // Draw a little red spot where the pivot is.
      g.setColor(Color.red);  
      g.fillOval(Cord.CORD_PIVOT_X - 3, Cord.CORD_PIVOT_Y - 3, 6, 6);     
   }

   /** Reset the weight to this position as the user drags it around. */
   public boolean mouseDrag(Event e, int x, int y) {
      weight.newPosition(x, y);
      return false; // pass this event up the window hierarchy
   }

   /** Called when the mouse goes down. Stop swinging. */
   public boolean mouseDown(Event e, int x, int y) {
      freeze = true;
      return false; // pass this event up the window hierarchy
   }

   /** Called when the mouse goes up. Start swinging again. */
   public boolean mouseUp(Event e, int x, int y) {
      freeze = false;
      
      // Do a total repaint after the user drags the pendulum
      // to clean up the screen.
      repaint();
     
      return false; // pass this event up the window hierarchy
   }

   /** Focus the repaint to the pendulum. */
   private void myRepaint() {
      int x;
      int y;
      int w;
      int h;
      int border = Weight.WEIGHT_DIAMETER * 2;

      y = Cord.CORD_PIVOT_Y;
      h = weight.ypos + Weight.WEIGHT_DIAMETER;
      x = (weight.xpos > Cord.CORD_PIVOT_X) ? 
            Cord.CORD_PIVOT_X - border : weight.xpos - border;
      w = Math.abs(Cord.CORD_PIVOT_X - weight.xpos) + (border * 2);

      repaint(x, y, w, h);
   }

   /** Provide a main routine so that we can run stand-alone. */
    @SuppressWarnings("deprecation")
	public static void main(String args[]) {
      Pendulum p = new Pendulum();
      p.init();

      // Create a window hierarchy and hook it up.
      Frame f = new Frame("Pendulum");
      f.add(p);
      f.resize(500,400);
      f.show();

      // Start the app (this is done by the appletviewer or Web browser
      // for us automatically, but it's not done if we're running the app
      // from the command line).
      p.start();
    }   
}