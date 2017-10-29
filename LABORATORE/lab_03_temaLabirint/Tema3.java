package lab_03_temaLabirint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


public class Tema3 extends JPanel{
   public static final int RECT_DIM = 50;
   public static final int WIN_DIM = 500;
   public static int my_x_pos=0;
   public static int x=0,y=1;
   public static int my_y_pos=0;
   public static int [][] map= {
                 {0,3,0,0,0,0,0,0,0,0,0,0,0},
                 {0,1,0,1,1,1,0,1,1,1,0,0,0},
                 {0,1,0,1,0,1,0,1,0,1,0,0,0},
                 {0,1,0,1,0,1,0,1,0,1,0,0,0},
                 {0,1,0,1,0,1,0,1,0,1,0,0,0},
                 {0,1,1,1,1,1,1,1,1,1,0,0,0},
                 {0,1,0,1,0,1,0,1,0,1,0,0,0},
                 {0,1,0,1,0,1,0,1,0,1,0,0,0},
                 {0,1,1,1,0,1,1,1,0,1,1,1,0},
                 {0,0,0,0,0,0,0,0,0,0,0,2,0}
               };
   
    @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
        for(int i=0;i<10;i++){
            for(int j=0;j<13;j++){
                switch(map[i][j]){
                    case 0:
                    {
                        g.setColor(Color.black);  //zidurile fill
                        g.fillRect(i*50,j*50,RECT_DIM,RECT_DIM);
                        g.setColor(Color.BLACK); //ZIDURILE
                        g.drawRect(i*50,j*50,RECT_DIM,RECT_DIM);
                        break;
                    }
                    case 1:
                    {
                        g.setColor(Color.white);
                        g.fillRect(i*50,j*50,RECT_DIM,RECT_DIM);
                        g.setColor(Color.white);   // linile la tiles de mers
                        g.drawRect(i*50,j*50,RECT_DIM,RECT_DIM);
                        break;
                    }
                    case 2: 
                    {
                        g.setColor(Color.red);
                        g.fillRect(i*50,j*50,RECT_DIM,RECT_DIM);
                        g.setColor(Color.black);
                        g.drawRect(i*50,j*50,RECT_DIM,RECT_DIM);
                        break;
                    }
                    case 3:
                    {
                        my_x_pos=i*50; // pozitia la verde
                        my_y_pos=j*50; // pozitia la verde
                        g.setColor(Color.GREEN); //START
                        g.fillRect(my_x_pos,my_y_pos, RECT_DIM, RECT_DIM);
                    }
                }
            }
        }
   }

   private static void createAndShowGui() {
       Tema3 mainPanel = new Tema3();
        
       ShapeComponent square = new ShapeComponent( new Rectangle(30, 30) );
       square.setForeground(Color.CYAN);             
       square.setLocation(0,50);
       square.setSize( square.getPreferredSize() );    
      
       ComponentMover cm = new ComponentMover();
       cm.registerComponent(square);
       
       MouseListener ml = new MouseAdapter()
        {
            public void mouseClicked( MouseEvent e )
            {
                System.out.println( "clicked " );
            }
        };
       square.addMouseListener( ml );
       
       JFrame frame = new JFrame("DrawRect");
       frame.addKeyListener(new KeyListener() {
           @Override
           public void keyTyped(KeyEvent e) {
           }

           @Override
           public void keyPressed(KeyEvent e) {
               if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                   if(x<10){
                        x++;
                   }
                   System.out.println("x= "+x+" y= "+y+" map= "+map[x][y]);
                   if(map[x][y]!=0){
                       square.setLocation(x*50,y*50);
                   } else {
                       x--;
                   }
               }
               if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    if(x>=0){
                        x--;
                   }
                   System.out.println("x= "+x+" y= "+y+" map= "+map[x][y]);
                    if(map[x][y]!=0){
                        square.setLocation(x*50,y*50);
                    } else {
                       x++;
                   }
               }
               if (e.getKeyCode() == KeyEvent.VK_UP) {
                    if(y>=0){
                        y--;
                   }
                     System.out.println("x= "+x+" y= "+y+" map= "+map[x][y]);
                    if(map[x][y]!=0){
                        square.setLocation(x*50,y*50);
                    } else {
                       y++;
                   }
               }
               if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    if(y<13){
                        y++;
                   }
                    System.out.println("x= "+x+" y= "+y+" map= "+map[x][y]);
                    if(map[x][y]!=0){
                        square.setLocation(x*50,y*50);
                    } else {
                       y--;
                   }
               }
           }

           @Override
           public void keyReleased(KeyEvent e) {
           }
       });
       frame.getContentPane().add(square);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.getContentPane().add(mainPanel);
       frame.pack();
       frame.setSize(WIN_DIM,WIN_DIM);
       frame.setLocationByPlatform(true);
       frame.setVisible(true);
   }

   
   
   public static void main(String[] args) {
       createAndShowGui();
   }
}