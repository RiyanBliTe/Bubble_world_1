import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
public class Listreners implements KeyListener, MouseListener, MouseMotionListener {

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
        if(key == KeyEvent.VK_UP)
        {
            Player.up = true;
        }
        if(key == KeyEvent.VK_DOWN)
        {
            Player.down = true;
        }
        if(key == KeyEvent.VK_LEFT)
        {
            Player.left = true;
        }
        if(key == KeyEvent.VK_RIGHT)
        {
            Player.right = true;
        }
        if(key == KeyEvent.VK_W)
        {
            Player.up = true;
        }
        if(key == KeyEvent.VK_S)
        {
            Player.down = true;
        }
        if(key == KeyEvent.VK_A)
        {
            Player.left = true;
        }
        if(key == KeyEvent.VK_D)
        {
            Player.right = true;
        }
        if (key == KeyEvent.VK_SPACE)
        {
            Player.firing = true;
        }
        if (key == KeyEvent.VK_ESCAPE )
        {
        	if (GamePanel.state == GamePanel.STATES.MENUE) {
        		ExitQ q = new ExitQ();
        		q.main();
        	}else {
        	GamePanel.state = GamePanel.STATES.MENUE;
        	}
        }
        if (key == KeyEvent.VK_ENTER)
        {
        	if (GamePanel.state == GamePanel.STATES.MENUE)
        	{
        		GamePanel.state = GamePanel.STATES.PLAY;
        	}
        }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
        if(key == KeyEvent.VK_UP)
        {
            Player.up = false;
        }
        if(key == KeyEvent.VK_DOWN)
        {
            Player.down = false;
        }
        if(key == KeyEvent.VK_LEFT)
        {
            Player.left = false;
        }
        if(key == KeyEvent.VK_RIGHT)
        {
            Player.right = false;
        }
        if(key == KeyEvent.VK_W)
        {
            Player.up = false;
        }
        if(key == KeyEvent.VK_S)
        {
            Player.down = false;
        }
        if(key == KeyEvent.VK_A)
        {
            Player.left = false;
        }
        if(key == KeyEvent.VK_D)
        {
            Player.right = false;
        }
        if (key == KeyEvent.VK_SPACE)
        {
            Player.firing = false;
        }
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getButton() == MouseEvent.BUTTON1)
		{
			GamePanel.leftMouse = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getButton() == MouseEvent.BUTTON1)
		{
			GamePanel.leftMouse = false;
		}
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		GamePanel.mouseX = arg0.getX();
		GamePanel.mouseY = arg0.getY();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		GamePanel.mouseX = arg0.getX();
		GamePanel.mouseY = arg0.getY();
	}

}
