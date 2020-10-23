import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;
public class Menue {
	
	private int buttonPlayWidth;
	private int buttonPlayHeight;
	private int buttonHelpWidth;
	private int buttonHelpHeight;
	private int buttonExitWidth;
	private int buttonExitHeight;
	private Color color;
	private String s;
	private String help;
	private String exit;
	private String title1;
	private String title2;
	private static int transp = 0;
	private static int transpHelp = 0;
	private static int transpExit = 0;
	public static ArrayList<Enemy> enemies;
	public static ExitQ quit;
	public static int debug;
	public Menue()
	{
		buttonPlayWidth = 140;
		buttonPlayHeight = 70;
		buttonHelpWidth = 120;
		buttonHelpHeight = 60;
		buttonExitWidth = 100;
		buttonExitHeight = 60;		
		color = Color.white;
		quit=new ExitQ();
		debug=0;
		s = "Play";
		help = "Help";
		exit = "Exit";
		title1 = "BUBBLE";
		title2 = "WORLD";
		enemies = new ArrayList<Enemy>();
		for (int k = 0; k < 5; k++) {
			for (int i = 1; i <= 4; i++) {
				for(int j = 1; j <= 4; j++) {
					enemies.add(new Enemy(i,j));
				}
			}
		}
	}
	
	public void update()
	{
		for (int i = 0; i < enemies.size(); i++)
		 {
				enemies.get(i).update();
		 }
		if (GamePanel.mouseX > GamePanel.WIDTH / 2 - buttonPlayWidth / 2 && 
			 GamePanel.mouseX < GamePanel.WIDTH / 2 + buttonPlayWidth / 2 && 
			 GamePanel.mouseY > GamePanel.HEIGHT / 2 - buttonPlayHeight / 2 && 
			 GamePanel.mouseY < GamePanel.HEIGHT / 2 + buttonPlayHeight / 2)
		{
			transp = 80;
			if (GamePanel.leftMouse)
			{
				GamePanel.state = GamePanel.STATES.PLAY;
				if (GamePanel.player.getScore() > 0 && GamePanel.player.getX() == GamePanel.WIDTH / 2 && GamePanel.player.getY() == GamePanel.HEIGHT / 1.2
						&& GamePanel.enemies.size() == 0 && GamePanel.bullets.size() == 0)
				{
					GamePanel.player.setScore(0);
				}
			}
		}
		else
		{
			transp = 0;
		}
		if (GamePanel.mouseX > GamePanel.WIDTH / 2 - buttonHelpWidth / 2 && 
				 GamePanel.mouseX < GamePanel.WIDTH / 2 + buttonHelpWidth / 2 && 
				 GamePanel.mouseY > GamePanel.HEIGHT - GamePanel.HEIGHT / 3  - buttonHelpHeight / 2 + 13 && 
				 GamePanel.mouseY < GamePanel.HEIGHT - GamePanel.HEIGHT / 3  + buttonHelpHeight / 2 + 15)
			{
				transpHelp = 80;
				if (GamePanel.leftMouse)
				{
					GamePanel.state = GamePanel.STATES.HELP;
				}
			}
			else
			{
				transpHelp = 0;
			}
		if (GamePanel.mouseX > GamePanel.WIDTH / 2 - buttonExitWidth / 2  && 
				 GamePanel.mouseX < GamePanel.WIDTH / 2 + buttonExitWidth / 2 + 2 && 
				 GamePanel.mouseY > GamePanel.HEIGHT - GamePanel.HEIGHT / 5 - buttonExitHeight / 2 + 5 && 
				 GamePanel.mouseY < GamePanel.HEIGHT - GamePanel.HEIGHT / 5 + buttonExitHeight / 2 + 8)
			{
				transpExit = 80;
				if (GamePanel.leftMouse)
				{
					debug++;
					if(debug==1)
						quit.main();
				}
			}
			else
			{
				transpExit = 0;
				debug=0;
			}
	}
	
	public void draw(Graphics2D g)
	{
		for (int i = 0; i < enemies.size(); i++)
		{
			enemies.get(i).draw(g);
		}
		
		g.setColor(Color.WHITE);
		g.setStroke(new BasicStroke(10));
		g.drawOval(GamePanel.WIDTH / 3 + GamePanel.WIDTH / 14 + 4, GamePanel.HEIGHT / 18 +4, 250, 250);
		g.setColor(new Color(0,0,0,128));
		g.fillOval(GamePanel.WIDTH / 3 + GamePanel.WIDTH / 14 + 8, GamePanel.HEIGHT / 18 + 8, 250, 250);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Jokerman",Font.BOLD,50));
		long length = (int)g.getFontMetrics().getStringBounds(title1,g).getWidth();
		g.drawString(title1, (int)GamePanel.WIDTH / 2 - length / 2 , (int)GamePanel.HEIGHT / 6 + buttonPlayHeight / 4 + 25);
		g.setFont(new Font("Verdana",Font.BOLD,30));
		length = (int)g.getFontMetrics().getStringBounds(title2,g).getWidth();
		g.drawString(title2, (int)GamePanel.WIDTH / 2 - length / 2 , (int)GamePanel.HEIGHT / 4 + buttonPlayHeight / 4 + 10);
		g.setFont(new Font("Verdana",Font.BOLD,14));
		g.drawString("Ver 1.1", (int)GamePanel.WIDTH / 2 - length / 2 + 35, (int)GamePanel.HEIGHT / 4 + buttonPlayHeight / 2 + 30);
		g.setFont(new Font("Verdana",Font.BOLD,30));
		
		g.setColor(color);
		
		
		g.setStroke(new BasicStroke(3));
		g.draw3DRect(GamePanel.WIDTH / 2 - buttonPlayWidth / 2, 
				GamePanel.HEIGHT / 2 - buttonPlayHeight / 2, buttonPlayWidth, buttonPlayHeight, true);
		g.setColor(new Color(255, 255, 255, transp));
		g.fillRect(GamePanel.WIDTH / 2 - buttonPlayWidth / 2, 
				GamePanel.HEIGHT / 2 - buttonPlayHeight / 2, buttonPlayWidth, buttonPlayHeight);
		
		g.setColor(color);
		g.setStroke(new BasicStroke(3));
		g.draw3DRect(GamePanel.WIDTH / 2 - buttonHelpWidth / 2 + 1, 
				GamePanel.HEIGHT - GamePanel.HEIGHT / 4  - buttonHelpHeight / 2 -50, buttonHelpWidth, buttonHelpHeight, true);
		g.setColor(new Color(255, 255, 255, transpHelp));
		g.fillRect(GamePanel.WIDTH / 2 - buttonHelpWidth / 2 + 1, 
				GamePanel.HEIGHT - GamePanel.HEIGHT / 4 - buttonHelpHeight / 2 - 50, buttonHelpWidth, buttonHelpHeight);
		
		g.setColor(color);
		g.setStroke(new BasicStroke(3));
		g.draw3DRect(GamePanel.WIDTH / 2 - buttonExitWidth / 2 + 1, 
				GamePanel.HEIGHT - GamePanel.HEIGHT / 8 - buttonExitHeight / 2 - 50, buttonExitWidth, buttonExitHeight, true);
		g.setColor(new Color(255, 255, 255, transpExit));
		g.fillRect(GamePanel.WIDTH / 2 - buttonExitWidth / 2 + 1, 
				GamePanel.HEIGHT - GamePanel.HEIGHT / 8 - buttonExitHeight / 2 - 50, buttonExitWidth, buttonExitHeight);
		
		g.setFont(new Font("Verdana",Font.BOLD,40));
		g.setStroke(new BasicStroke(1));
		g.setColor(color);
		length = (int)g.getFontMetrics().getStringBounds(s,g).getWidth();
		g.drawString(s, (int)GamePanel.WIDTH / 2 - length / 2, (int)GamePanel.HEIGHT / 2 + buttonPlayHeight / 4);
		g.setFont(new Font("Verdana",Font.BOLD,30));
		length = (int)g.getFontMetrics().getStringBounds(help,g).getWidth();
		g.drawString(help, (int)GamePanel.WIDTH / 2 - length / 2, (int)GamePanel.HEIGHT - GamePanel.HEIGHT / 4 - buttonHelpHeight / 2 - 5);
		length = (int)g.getFontMetrics().getStringBounds(exit,g).getWidth();
		g.drawString(exit, (int)GamePanel.WIDTH / 2 - length / 2, (int)GamePanel.HEIGHT - GamePanel.HEIGHT / 8 - buttonExitHeight / 2 - 5 );
		
		g.setFont(new Font("Arial", Font.BOLD,15));
		
	}
}