import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HealthHandMain extends JFrame
{
	private CardPanel cp;
	private JPanel cardPanel;
	private CardLayout cards;
	private MainMenuPanel mmp;
	private BodyPanel bp;
	private HeadPanel hp;
	private ShoulderPanel sp;
	private TorsoPanel tp;
	private ArmPanel ap;
	private GroinPanel gp;
	private Color backColor;
	
	public HealthHandMain()
	{
		mmp = new MainMenuPanel();
		bp = new BodyPanel();
		hp = new HeadPanel();
		sp = new ShoulderPanel();
		tp = new TorsoPanel();
		ap = new ArmPanel();
		gp = new GroinPanel();
		
		backColor = new Color(104, 175, 255);
	}
	public static void main (String[] args)
	{
		HealthHandMain hhm = new HealthHandMain();
		hhm.run();
	}
	public void run()
	{
			JFrame frame = new JFrame("HealthHand");	//Set the title of the program
			frame.setSize(1000,650);	//Set the size of the frame
			frame.setLocation(400,100);	//Set where the frame will be located
			frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
			frame.setResizable(true);	//Don't allow the frame to be resizable
			frame.setVisible(true);	//Make sure the frame is visible
			cp = new CardPanel();
			frame.getContentPane().add(cp);
    }
	class CardPanel extends JPanel
	{
			public CardPanel()
			{
				new JPanel();
				cardPanel = new JPanel();
				add(cardPanel);
				setLayout(new GridLayout());
				cards = new CardLayout();	//Use CardLayout to add each panel to the cards
				cardPanel.setLayout(cards);
				cardPanel.add(mmp, "Main Menu");
				cardPanel.add(bp, "BodyPanel");
				cardPanel.add(hp, "HeadPanel");
				cardPanel.add(sp, "ShoulderPanel");
				cardPanel.add(tp, "TorsoPanel");
				cardPanel.add(ap, "ArmPanel");
				cardPanel.add(gp, "GroinPanel");
				
				
				cards.show(cardPanel, "Main Menu");

			}
	}
	class MainMenuPanel extends JPanel implements ActionListener
	{
			private JButton beginBtn;
			private Image frontImg;
			public MainMenuPanel()
			{
				setPreferredSize(new Dimension(1000, 650));
				beginBtn = new JButton("Begin");
				setLayout(new FlowLayout(FlowLayout.CENTER, 0, 500));
				beginBtn.setFont(new Font("Monospaced", Font.ITALIC, 50));
				beginBtn.addActionListener(this);
				beginBtn.setBounds(0, 500, 100, 100);
				add(beginBtn);
				frontImg = new ImageIcon(this.getClass().getResource("/hand.png")).getImage();
			}
			public void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				setBackground(backColor);
				g.setFont(new Font("MONOSPACED", Font.ITALIC, 25));
				g.drawString("An interactive helper for health. Press below to begin.", 75, 460);
				g.drawImage(frontImg, 0, -50, this);
			}
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if(e.getActionCommand().equals("Begin"))	
					cards.show(cardPanel, "BodyPanel");
			}
	}
	class BodyPanel extends JPanel implements ActionListener
	{
			private Image bodyImg;
			private JButton headBtn;
			private JButton stomachBtn;
			private JButton shldrBtn;
			private JButton groinBtn;
			private JButton backBtn;
			private JButton armBtn;
			private JButton armBtn2;
			
			public BodyPanel()
			{
				setLayout(null);
				
				headBtn = new JButton("Head");
				headBtn.setBounds(240, 53, 65, 25);
				headBtn.addActionListener(this);
				add(headBtn);
				
				stomachBtn = new JButton("Torso");
				stomachBtn.setBounds(225, 250, 90, 25);
				stomachBtn.addActionListener(this);
				add(stomachBtn);
				
				shldrBtn = new JButton("Shoulder/Chest");
				shldrBtn.setBounds(202, 145, 140, 25);
				shldrBtn.addActionListener(this);
				add(shldrBtn);
				
				groinBtn = new JButton("Groin");
				groinBtn.setBounds(215, 310, 100, 25);
				groinBtn.addActionListener(this);
				add(groinBtn);
				
				armBtn = new JButton("Arm/Hand");
				armBtn.setBounds(45, 225, 100, 25);
				armBtn.addActionListener(this);
				add(armBtn);
				
				armBtn2 = new JButton("Arm/Hand");
				armBtn2.setBounds(400, 225, 100, 25);
				armBtn2.addActionListener(this);
				add(armBtn2);
				
				
				backBtn = new JButton("Back");
				backBtn.setBounds(0, 560, 100, 50);
				backBtn.setFont(new Font("Monospaced", Font.ITALIC, 25));
				backBtn.addActionListener(this);
				add(backBtn);
				
				bodyImg = new ImageIcon(this.getClass().getResource("/body.png")).getImage();
			}
			public void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				setBackground(backColor);
				g.drawImage(bodyImg, 0, 10, this);
				g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 100));
				g.drawString("Click",550,100);
				g.drawString("Area", 585, 300);
				g.drawString("Body", 585, 500);
				g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 75));
				g.drawString("on an",587,200);
				g.drawString("of the",575,400);
				g.setColor(Color.RED);
				g.drawLine(95, 250, 150, 275);
				g.drawLine(450, 250, 390, 275);
			}
			public void actionPerformed(ActionEvent e) 
			{
				if(e.getActionCommand().equals("Head"))	
					cards.show(cardPanel, "HeadPanel");
				else if(e.getActionCommand().equals("Shoulder/Chest"))
					cards.show(cardPanel, "ShoulderPanel");
				else if(e.getActionCommand().equals("Torso"))
					cards.show(cardPanel, "TorsoPanel");
				else if(e.getActionCommand().equals("Groin"))
					cards.show(cardPanel, "GroinPanel");
				else if(e.getActionCommand().equals("Arm/Hand"))
					cards.show(cardPanel, "ArmPanel");
				else if(e.getActionCommand().equals("Legs"))
					cards.show(cardPanel, "LegPanel");
				else if(e.getActionCommand().equals("Feet"))
					cards.show(cardPanel, "FeetPanel");
				else if(e.getActionCommand().equals("Back"))
					cards.show(cardPanel, "Main Menu");
			}
	}
	class HeadPanel extends JPanel implements MouseListener, ActionListener
	{
		private Image childImg;
		private String[] headParts;
		private String[] headFeelings;
		private String[] headProblems;
		private String[] headSolutions;
		private JButton backBtn;
		private int index;
		
		public HeadPanel()
		{
			setPreferredSize(new Dimension(600, 650));
			childImg = new ImageIcon(this.getClass().getResource("/child.png")).getImage();
			headParts = new String[]{"", "Forehead", "Eyes", "Cheeks/Nose", "Ears", "Mouth"};
			headFeelings = new String[] {"", "Tightness or pressure in the head", "Itchy, red eyes with continuous blinking", "Pressure when bending down body", "Pressure within stuffed ear", "Pressure on tooth/gum area when touched"};
			headProblems = new String[] {"", "Headache", "Allergies", "Sinus Infection", "Ear Infection", "Toothache"};
			headSolutions = new String[] {"","Place a cold pack.", "Zaditor eye drops", "Nasal Decongestant Spray", "Advil/Tylenol", "Wash with warm water"};
			addMouseListener(this);
			
			setLayout(null);
			backBtn = new JButton("Back");
			backBtn.setBounds(0, 560, 100, 50);
			backBtn.setFont(new Font("Monospaced", Font.ITALIC, 25));
			backBtn.addActionListener(this);
			add(backBtn);
		}
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			setBackground(backColor);
			g.drawImage(childImg, 0, 100, this);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Sans Serif", Font.BOLD, 25));
			g.drawString("Click on an area for more information", 20, 50);
			g.setFont(new Font("Monospaced", Font.BOLD, 30));
			g.drawString("Area of Head:", 525, 75);
			g.drawString("What it should feel like:", 525, 175);
			g.drawString("Problem:", 525, 350);
			g.drawString("Solution:", 525, 475);
			g.setFont(new Font("Monospaced", Font.PLAIN, 30));
			g.drawString(headParts[index], 525, 125);
			g.drawString(headProblems[index], 525, 400);
			g.drawString(headSolutions[index], 525, 525);
			g.setFont(new Font("Monospaced", Font.PLAIN, 18));
			g.drawString(headFeelings[index], 525, 225);
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getX() >= 100 && e.getX() <= 400 && e.getY() >= 200 && e.getY() <= 300)
				index = 1;
			else if(e.getX() >= 152 && e.getX() <= 180 && e.getY() >= 354 && e.getY() <= 411 || e.getX() >= 320 && e.getX() <= 348 && e.getY() >=354 && e.getY() <= 411)
				index = 2;
			else if(e.getX() >= 85 && e.getX() <= 185 && e.getY() >= 425 && e.getY() <= 475 || e.getX() >= 320 && e.getX() <= 420 && e.getY() >= 425 && e.getY() <= 475 || e.getX() >= 222 && e.getX() <= 277 && e.getY() >= 425 && e.getY() <= 453)
				index = 3;
			else if(e.getX() >= 12 && e.getX() <= 62 && e.getY() >= 325 && e.getY() <= 440 || e.getX() >= 438 && e.getX() <= 488 && e.getY() >= 320 && e.getY() <= 435)
				index = 4;
			else if (e.getX() >= 150 && e.getX() <= 350 && e.getY() >= 480 && e.getY() <= 525)
				index = 5;
			else
				index = 0;
			repaint();
		}
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("Back"))
				cards.show(cardPanel, "BodyPanel");
			
		}
	}
	class ShoulderPanel extends JPanel implements MouseListener, ActionListener
	{
		private JButton backBtn;
		private Image img;
		private String[] parts;
		private String[] feelings;
		private String[] problems;
		private String[] solutions;
		private int index;
		
		public ShoulderPanel()
		{
			img = new ImageIcon(this.getClass().getResource("/shoulder.png")).getImage();
			
			setLayout(null);
			backBtn = new JButton("Back");
			backBtn.setBounds(0, 560, 100, 50);
			backBtn.setFont(new Font("Monospaced", Font.ITALIC, 25));
			backBtn.addActionListener(this);
			add(backBtn);
			parts = new String[] {"", "Shoulder", "Lungs"};
			feelings = new String[] {"", "Lot of strain in the area", "Congested, Lots of mucus, Hard to breathe"};
			problems = new String[] {"", "Shoulder Pain", "Asthma"};
			solutions = new String[] {"", "Apply ice", "Inhaler for Asthma"};
			
			addMouseListener(this);
		}
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			setBackground(backColor);
			g.setColor(Color.BLACK);
			g.drawImage(img, 0, 0, this);
			g.setFont(new Font("Sans Serif", Font.BOLD, 25));
			g.drawString("Click on an area for more information", 20, 50);
			g.setFont(new Font("Monospaced", Font.BOLD, 30));
			g.drawString("Area:", 525, 75);
			g.drawString("What it should feel like:", 525, 175);
			g.drawString("Problem:", 525, 350);
			g.drawString("Solution:", 525, 475);
			g.setFont(new Font("Monospaced", Font.PLAIN, 30));
			g.drawString(parts[index], 525, 125);
			g.drawString(problems[index], 525, 400);
			g.drawString(solutions[index], 525, 525);
			g.setFont(new Font("Monospaced", Font.PLAIN, 18));
			g.drawString(feelings[index], 525, 225);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("Back"))
				cards.show(cardPanel, "BodyPanel");
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getX() >= 40 && e.getX() <= 160 && e.getY() >= 150 && e.getY() <= 240 || e.getX() >= 340 && e.getX() <= 460 && e.getY() >=150 && e.getY() <= 240)
				index = 1;
			else if(e.getX() >= 165 && e.getX() <= 335 && e.getY() >= 125 && e.getY() <= 375)
				index = 2;
			else
				index = 0;
			repaint();
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	class ArmPanel extends JPanel implements MouseListener, ActionListener
	{
		private JButton backBtn;
		private Image img;
		private String[] parts;
		private String[] feelings;
		private String[] problems;
		private String[] solutions;
		private int index;
		
		public ArmPanel()
		{
			img = new ImageIcon(this.getClass().getResource("/arms.png")).getImage();
			
			setLayout(null);
			backBtn = new JButton("Back");
			backBtn.setBounds(0, 560, 100, 50);
			backBtn.setFont(new Font("Monospaced", Font.ITALIC, 25));
			backBtn.addActionListener(this);
			add(backBtn);
			
			parts = new String[] {"", "Elbow", "Wrist"};
			feelings = new String[] {"", "Lot of strain in the area", "Lot of strain in the area"};
			problems = new String[] {"", "Elbow Pain", "Wrist Pain"};
			solutions = new String[] {"", "Apply ice", "Apply ice"};
			
			addMouseListener(this);
		}
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			setBackground(backColor);
			g.setColor(Color.BLACK);
			g.drawImage(img, 0, 0, this);
			g.setFont(new Font("Sans Serif", Font.BOLD, 25));
			g.drawString("Click on an area for more information", 20, 50);
			g.setFont(new Font("Monospaced", Font.BOLD, 30));
			g.drawString("Area:", 525, 75);
			g.drawString("What it should feel like:", 525, 175);
			g.drawString("Problem:", 525, 350);
			g.drawString("Solution:", 525, 475);
			g.setFont(new Font("Monospaced", Font.PLAIN, 30));
			g.drawString(parts[index], 525, 125);
			g.drawString(problems[index], 525, 400);
			g.drawString(solutions[index], 525, 525);
			g.setFont(new Font("Monospaced", Font.PLAIN, 18));
			g.drawString(feelings[index], 525, 225);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getActionCommand().equals("Back"))
				cards.show(cardPanel, "BodyPanel");
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getX() >= 5 && e.getX() <= 80 && e.getY() >= 175 && e.getY() <= 250 || e.getX() >= 410 && e.getX() <= 485 && e.getY() >=175 && e.getY() <= 250)
				index = 1;
			else if(e.getX() >= 345 && e.getX() <= 395 && e.getY() >= 260 && e.getY() <= 310 || e.getX() >= 100 && e.getX() <= 150 && e.getY() >=260 && e.getY() <= 310)
				index = 2;
			else
				index = 0;
			repaint();
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	class TorsoPanel extends JPanel implements MouseListener, ActionListener
	{
		private JButton backBtn;
		private Image img;
		private String[] parts;
		private String[] feelings;
		private String[] problems;
		private String[] solutions;
		private int index;
		
		public TorsoPanel()
		{
			img = new ImageIcon(this.getClass().getResource("/torso.png")).getImage();
			
			setLayout(null);
			backBtn = new JButton("Back");
			backBtn.setBounds(0, 560, 100, 50);
			backBtn.setFont(new Font("Monospaced", Font.ITALIC, 25));
			backBtn.addActionListener(this);
			add(backBtn);
			
			parts = new String[] {"", "Stomach"};
			feelings = new String[] {"", "Small bursts of discomfort, rolling around"};
			problems = new String[] {"", "Stomach ache"};
			solutions = new String[] {"", "TUMS"};
			
			addMouseListener(this);
		}
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			setBackground(backColor);
			g.setColor(Color.BLACK);
			g.drawImage(img, 0, 0, this);
			g.setFont(new Font("Sans Serif", Font.BOLD, 25));
			g.drawString("Click on an area for more information", 20, 50);
			g.setFont(new Font("Monospaced", Font.BOLD, 30));
			g.drawString("Area:", 525, 75);
			g.drawString("What it should feel like:", 525, 175);
			g.drawString("Problem:", 525, 350);
			g.drawString("Solution:", 525, 475);
			g.setFont(new Font("Monospaced", Font.PLAIN, 30));
			g.drawString(parts[index], 525, 125);
			g.drawString(problems[index], 525, 400);
			g.drawString(solutions[index], 525, 525);
			g.setFont(new Font("Monospaced", Font.PLAIN, 18));
			g.drawString(feelings[index], 525, 225);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getActionCommand().equals("Back"))
				cards.show(cardPanel, "BodyPanel");
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getX() >= 125 && e.getX() <= 370 && e.getY() >= 200 && e.getY() <= 365)
				index = 1;
			else
				index = 0;
			repaint();
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	class GroinPanel extends JPanel implements MouseListener, ActionListener
	{
		private JButton backBtn;
		private Image img;
		private String[] parts;
		private String[] feelings;
		private String[] problems;
		private String[] solutions;
		private int index;
		
		public GroinPanel()
		{
			img = new ImageIcon(this.getClass().getResource("/groin.png")).getImage();
			
			setLayout(null);
			backBtn = new JButton("Back");
			backBtn.setBounds(0, 560, 100, 50);
			backBtn.setFont(new Font("Monospaced", Font.ITALIC, 25));
			backBtn.addActionListener(this);
			add(backBtn);
			
			parts = new String[] {"", "Behind"};
			feelings = new String[] {"", "Itchy behind with rashes"};
			problems = new String[] {"", "Intertrigo"};
			solutions = new String[] {"", "Apply Lotion Cream"};
			
			addMouseListener(this);
		}
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			setBackground(backColor);
			g.setColor(Color.BLACK);
			g.drawImage(img, 0, 20, this);
			g.setFont(new Font("Sans Serif", Font.BOLD, 25));
			g.drawString("Click on an area for more information", 20, 50);
			g.setFont(new Font("Monospaced", Font.BOLD, 30));
			g.drawString("Area:", 525, 75);
			g.drawString("What it should feel like:", 525, 175);
			g.drawString("Problem:", 525, 350);
			g.drawString("Solution:", 525, 475);
			g.setFont(new Font("Monospaced", Font.PLAIN, 30));
			g.drawString(parts[index], 525, 125);
			g.drawString(problems[index], 525, 400);
			g.drawString(solutions[index], 525, 525);
			g.setFont(new Font("Monospaced", Font.PLAIN, 18));
			g.drawString(feelings[index], 525, 225);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getActionCommand().equals("Back"))
				cards.show(cardPanel, "BodyPanel");
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getX() >= 100 && e.getX() <= 350 && e.getY() >= 150 && e.getY() <= 400)
				index = 1;
			else
				index = 0;
			repaint();
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

}
