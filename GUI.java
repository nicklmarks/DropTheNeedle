import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

//implements GUI
public class GUI {
	//initialize variables
    private JFrame frame;
	private JTextField textbar;
	private JLabel header;
    private JButton button1;
	private JButton button2;
	private JButton button3;
	private String inputtext;
	private JTextArea area;
	private JScrollPane scroller;
	private PANEL panel;
	private JPanel panel2;
	//these locations will probably be part of another class, just place holder for piece starting locations
    private int x = 850;
    private int y = 850;
	private int x2 = 850;
    private int y2 = 850;

    public static void main (String[] args){	
	GUI gui = new GUI();
	gui.setup();
    }
    
    public void setup() {
	//sets up the GUI
	
	frame = new JFrame(); 
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	button1 = new JButton("Roll the dice!");
	button1.addActionListener(new diceListener());
	button2 = new JButton("Mortgage/UnMortgage Properties"); 
	button2.addActionListener(new mortgageListener());
	button3 = new JButton("Buy Houses/Hotels");
	button3.addActionListener(new buyListener());
	
	header = new JLabel("Player One: ");
	
	textbar = new JTextField(10);
	textbar.addActionListener(new textListener());
	
    panel = new PANEL();
	panel2 = new JPanel();
	panel2.setLayout(new BoxLayout(panel2,BoxLayout.Y_AXIS));
	
	area = new JTextArea(60,10);
	area.setEditable(false);
	scroller = new JScrollPane(area);
	area.setLineWrap(true);
	scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	
	panel2.add(scroller);
	panel2.add(textbar);
	panel2.add(button2);
	panel2.add(button3);
	panel2.add(button1);
	
	frame.getContentPane().add(BorderLayout.CENTER, panel);
	frame.getContentPane().add(BorderLayout.EAST, panel2);
	frame.getContentPane().add(BorderLayout.NORTH, header);
	frame.setSize(1200,960);
    frame.setVisible(true);
    }

class diceListener implements  ActionListener {
//inner class
//what to do when roll dice button is clicked
    public void actionPerformed(ActionEvent event) {
	int die1 = (int) (Math.random()*6) +1;
	int die2 = (int) (Math.random()*6) +1;
	//put if statements here to choose which piece moves?
	x = x - 75*(die1+die2); 
	//rolls two dice and adds the results, multiplies by approximate width of tile
	//this causes the piece to animate, we can make it move tile by tile later
	area.append(" Player One: you rolled "+ die1 + " and " + die2 + "\n");
	frame.repaint();  //calls PaintComponent Method in inner class PANEL
    }
}

class mortgageListener implements ActionListener {
//inner class
//what to do when mortgage button is clicked
	public void actionPerformed(ActionEvent event) {
		area.append(" mortgage button works : \n"); //test code
		textbar.requestFocus();
		//Code here to mortgage/unmortgage properties?
	}
}

class buyListener implements ActionListener {
//inner class
//what to do when buy houses button is clicked
	public void actionPerformed(ActionEvent event) {
		area.append(" buy button works \n"); //test code
		textbar.requestFocus();
		//code here to buy houses/hotels/
	}
}
    
class textListener implements ActionListener {	
//inner class
//what to do when enter is hit (saves text, puts it in the JTextArea)
	 public void actionPerformed(ActionEvent evt) {
			inputtext = textbar.getText();
			area.append(inputtext + "\n");
			textbar.setText("");
		//something here to interpret the users answers?
	}
}
class PANEL extends JPanel {
//inner class
//adds the graphics on panel. this method is called when the PANEL is initiated. and when frame.repaint() is called
    public void paintComponent(Graphics g) {
       	Image image = new ImageIcon("blankboard.jpg").getImage();
       	g.drawImage(image,0,0,this);
		g.setColor(Color.blue);
		g.fillOval(x,y,20,20);
		g.setColor(Color.green);
		g.fillOval(x2+20,y2+20,20,20);
    }
 }
}