import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

//implements ScoreCardGUI
public class ScoreCardGUI {
	//initialize variables
    private JFrame frame;
	
/* not necessary?
	private JTextField textbar; // input text
	//these will need to be placed next to their according headers
	private JTextField ComposerTextField;
	private JTextField PieceTextField;
	private JTextField FilePathTextField;
*/	
 
 
	private JLabel header;
	//these are on the JPanel LabelPanel
	private JLabel NumQuestions;
	private JLabel SectionPiece;
	private JLabel MovementLimit;
	private JLabel ComposerLimit;
	private JLabel PieceLimit;
	private JLabel FilePathLabel;


    private JButton button1;
	private String inputtext;
	
	private JTextArea area; // display text
	private JScrollPane scroller;

	private JPanel LabelPanel;
	private JPanel panel2; //old probably remove

 
    public static void main (String[] args){	
	ScoreCardGUI gui = new ScoreCardGUI();
	gui.setup();
    }
    
    public void setup() {
	//sets up the GUI
	
	frame = new JFrame(); 
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	button1 = new JButton("PlaceHolder: New Test");
	button1.addActionListener(new NewTestListener());

		
	//Create a display options panel which displays the user defined options at the top
	header			= new JLabel("ScoreCard:"); //look at fonts/spacing/formatting
	NumQuestions	= new JLabel("Number of Questions: ");
	SectionPiece	= new JLabel("Section of Piece: ");
	MovementLimit	= new JLabel("Movements: ");
	ComposerLimit	= new JLabel("Limit Composers: ");
	PieceLimit		= new JLabel("Prioritze Pieces(Op. #): ");
	FilePathLabel	= new JLabel("Enter File Path: ");

	//create a display individual question panel
/*	looks like:
	1. Title: __________________________ M.M.: ____ Op.: _____
	   Composer: _______________________ 
	   Relevant Info: ________________________________________
*/
		
//	textbar = new JTextField(10);
//	textbar.addActionListener(new textListener());
	
    LabelPanel = new JPanel();
	LabelPanel.setLayout(new BoxLayout(LabelPanel,BoxLayout.Y_AXIS));
	panel2 = new JPanel();
	panel2.setLayout(new BoxLayout(panel2,BoxLayout.Y_AXIS));
	
	
	area = new JTextArea(50,10);
	area.setEditable(false);
	scroller = new JScrollPane(area);
	area.setLineWrap(true);
	scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	
	panel2.add(scroller);
//	panel2.add(textbar);
	panel2.add(button1);
		
	//the next lines need to be on a fram added to the west. Boxlayout/Y-axis
		//use with the coinciding checkboxes/textfields/buttons...
		//also look at formatting to separate from the "Options" tag and spacing/fonts
	//** format to look like above, with the ability to add correct answers after the headers
	LabelPanel.add(NumQuestions);
	LabelPanel.add(SectionPiece);
	LabelPanel.add(MovementLimit);
	LabelPanel.add(ComposerLimit);
	LabelPanel.add(PieceLimit);
	LabelPanel.add(FilePathLabel);
	
	frame.getContentPane().add(BorderLayout.EAST, panel2);
	frame.getContentPane().add(BorderLayout.NORTH, header);
	frame.getContentPane().add(BorderLayout.CENTER, LabelPanel);

	frame.setSize(1200,960);
    frame.setVisible(true);
    }

	
class NewTestListener implements  ActionListener {
//inner class
//what to do when roll dice button is clicked
    public void actionPerformed(ActionEvent event) {
	area.append(" you pressed the New Test Button! \n");
//	frame.repaint();  //calls PaintComponent Method in inner class PANEL
    }
}


	
/*
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
*/
	
	
}