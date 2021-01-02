package kata_7;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;
import kata_7.view.BlockDisplay;

public class BlockPanel extends JPanel implements BlockDisplay{
    private final int max;
    private final int size;
    private int x,y;
    private final MouseHandler handler;
    private Moved moved;

    public BlockPanel(int max,int size) {
        this.max = max;
        this.size=size;
        this.handler=new MouseHandler();
        this.addMouseListener(handler);
        this.addMouseMotionListener(handler);
    }
    
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 700, 700);
        
        g.setColor(Color.BLACK);
        int d = max*size;
        for (int i = 0; i <= max; i++){
            int c = i*size;
            g.drawLine(0, c, d, c);
            g.drawLine(c, 0, c, d);
        }
        
        g.setColor(Color.RED);
        g.fillRect(x, y, size, size);
    }

    @Override
    public void paintBlock(int x, int y) {
      this.x=x;
      this.y=y;
      repaint();
    }

    @Override
    public void on(Moved moved) {
        this.moved=moved;
    }
    
    private class MouseHandler implements MouseListener, MouseMotionListener {
        private boolean grabbed=false;
        @Override
        public void mouseClicked(MouseEvent e) {
           
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if(e.getX()<x || e.getX()>x+size)return;
            if(e.getY()<y || e.getY()>y+size)return;
           grabbed=true;
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            grabbed=false;
           
        }

        @Override
        public void mouseEntered(MouseEvent e) {
          
        }

        @Override
        public void mouseExited(MouseEvent e) {
            
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            moved.to(e.getX(), e.getY());
            
        }

        @Override
        public void mouseMoved(MouseEvent e) {
           
        }
        
    }
    
}
