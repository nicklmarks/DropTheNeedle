import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

//implements OptionsMenuGUI
public class OptionsMenuGUI_V2 {
	//initialize variables
    private JFrame frame;
	
	private JTextField textbar; // input text
	//these will need to be placed next to their according headers
	private JTextField ComposerTextField;
	private JTextField PieceTextField;
	private JTextField FilePathTextField;
	
	private JLabel header;
	//these are on the JPanel LabelPanel
	private JLabel NumQuestions;
	private JLabel SectionPiece;
	private JLabel MovementLimit;
	private JLabel ComposerLimit;
	private JLabel PieceLimit;
	private JLabel FilePathLabel;

	//instead of buttons should use checkboxes/(singledots...) align next to according headers

	private JButton SubmitButton;
    private JButton BrowseButton;
	private JButton NextPhaseButton;
	private JButton QuitButton;
	private String inputtext;
	
	private JTextArea area; // display text
	private JScrollPane scroller;

	private JPanel LabelPanel;
	private JPanel HeaderPanel;
	private JPanel SouthPanel;

	private JPanel panel2; //old probably remove
	
	private JPanel NumQuestionPanel;
	private JPanel SectionPanel;
	private JPanel MovementPanel;
	private JPanel ComposerPanel;
	private JPanel PiecePanel;
	private JPanel FilePathPanel;
	
	private JCheckBox BeginningBox;
	private JCheckBox MiddleBox;
	private JCheckBox EndBox;
	private JCheckBox RandBox;	
	private JCheckBox OneBox;
	private JCheckBox TwoBox;
	private JCheckBox ThreeBox;
	private JCheckBox FourBox;
	private JCheckBox AllBox;

	private ButtonGroup NumQuestionsGroup;
	private JRadioButton FiveButton;
	private JRadioButton TenButton;
	private JRadioButton TwentyButton;
	private JRadioButton ThirtyButton;
	private JRadioButton FiftyButton;
 
    public static void main (String[] args){	
	OptionsMenuGUI_V2 gui = new OptionsMenuGUI_V2();
	gui.setup();
    }
    
    public void setup() {
	//sets up the GUI
	
	frame = new JFrame(); 
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// changet the buttons... use one for browse, one for next phase..
	BrowseButton = new JButton("Browse");
//	button1.addActionListener(new diceListener());
		
		//add these to a panel and put them in the south.
	NextPhaseButton = new JButton("Next Phase"); 
	NextPhaseButton.addActionListener(new PhaseListener());
	QuitButton = new JButton("Quit");
	QuitButton.addActionListener(new QuitListener());
	SubmitButton = new JButton("Submit");
	SubmitButton.addActionListener(new SubmitListener());


	// PlaceHolder: limit Composers
	// PlaceHolder: Prioritize Pieces (By Op. #)
	// PlaceHolder: FilePath	
		
	header			= new JLabel("Options"); //look at fonts/spacing/formatting
	NumQuestions	= new JLabel("Number of Questions: ");
	SectionPiece	= new JLabel("Section of Piece: ");
	MovementLimit	= new JLabel("Movements: ");
	ComposerLimit	= new JLabel("Limit Composers: ");
	PieceLimit		= new JLabel("Prioritze Pieces(Op. #): ");
	FilePathLabel	= new JLabel("Enter File Path: ");
	
	//Abstract these out into individual inner classes so that when listeners are implemented
	// they can be added as "this"
	FiveButton			= new JRadioButton("Five");
	FiveButton.setSelected(true);
//		FiveButton.setActionCommand("Five"); // add these for the next 4 when implementing listeners
	TenButton			= new JRadioButton("Ten");
	TwentyButton		= new JRadioButton("Twenty");
	ThirtyButton		= new JRadioButton("Thirty");
	FiftyButton			= new JRadioButton("Fifty");
	
	NumQuestionsGroup	= new ButtonGroup();
	NumQuestionsGroup.add(FiveButton);
	NumQuestionsGroup.add(TenButton);
	NumQuestionsGroup.add(TwentyButton);
	NumQuestionsGroup.add(ThirtyButton);
	NumQuestionsGroup.add(FiftyButton);

		
	BeginningBox = new JCheckBox("Beginning");
	MiddleBox	 = new JCheckBox("Middle");
	EndBox		 = new JCheckBox("End");
	RandBox		 = new JCheckBox("Random");
	OneBox		 = new JCheckBox("First");
	TwoBox		 = new JCheckBox("Second");
	ThreeBox	 = new JCheckBox("Third");
	FourBox		 = new JCheckBox("Fourth");
	AllBox		 = new JCheckBox("All");


//	textbar = new JTextField(10);
//	textbar.addActionListener(new textListener()); 
		// create listeners for the next three fields, 
		// use them to display the text on the area field for now...
	ComposerTextField = new JTextField(50);
	PieceTextField	  = new JTextField(50);
	FilePathTextField = new JTextField(50);
		
    LabelPanel = new JPanel();
	LabelPanel.setLayout(new BoxLayout(LabelPanel,BoxLayout.Y_AXIS));
	panel2 = new JPanel();
	panel2.setLayout(new BoxLayout(panel2,BoxLayout.Y_AXIS));
	
		HeaderPanel = new JPanel();
		SouthPanel = new JPanel();
	//	SouthPanel.setLayout(new BoxLayout(LabelPanel,BoxLayout.Y_AXIS));
		NumQuestionPanel = new JPanel();
		SectionPanel = new JPanel();
		MovementPanel = new JPanel();
		ComposerPanel = new JPanel();
		PiecePanel = new JPanel();
		FilePathPanel = new JPanel();
	
	area = new JTextArea(10,100); // move this to the header, and use it as display directions.
	area.setEditable(false);
	scroller = new JScrollPane(area);
	area.setLineWrap(true);
	scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	
//	panel2.add(scroller);
//	panel2.add(textbar);
	SouthPanel.add(SubmitButton);
	SouthPanel.add(NextPhaseButton);
	SouthPanel.add(QuitButton);
		
	//the next lines need to be on a fram added to the west. Boxlayout/Y-axis
		//use with the coinciding checkboxes/textfields/buttons...
		//also look at formatting to separate from the "Options" tag and spacing/fonts
		// in between each of these add their according checkbox components
				
		NumQuestionPanel.add(NumQuestions);
		NumQuestionPanel.add(FiveButton);
		NumQuestionPanel.add(TenButton);
		NumQuestionPanel.add(TwentyButton);
		NumQuestionPanel.add(ThirtyButton);
		NumQuestionPanel.add(FiftyButton);

		
		SectionPanel.add(SectionPiece);
		SectionPanel.add(BeginningBox);
		SectionPanel.add(MiddleBox);
		SectionPanel.add(EndBox);
		SectionPanel.add(RandBox);

		MovementPanel.add(MovementLimit);
		MovementPanel.add(OneBox);
		MovementPanel.add(TwoBox);
		MovementPanel.add(ThreeBox);
		MovementPanel.add(FourBox);
		MovementPanel.add(AllBox);
		
		ComposerPanel.add(ComposerLimit);
		ComposerPanel.add(ComposerTextField);
		
		PiecePanel.add(PieceLimit);
		PiecePanel.add(PieceTextField);
		
		FilePathPanel.add(FilePathLabel);
		FilePathPanel.add(FilePathTextField);
		FilePathPanel.add(BrowseButton);
		
		//LabelPanel = new labelPanel();
		
		LabelPanel.add(NumQuestionPanel);
		LabelPanel.add(SectionPanel);
		LabelPanel.add(MovementPanel);
		LabelPanel.add(ComposerPanel);
		LabelPanel.add(PiecePanel);
		LabelPanel.add(FilePathPanel);
		
		 
		HeaderPanel.add(header);
		HeaderPanel.add(scroller);
		
//	frame.getContentPane().add(BorderLayout.CENTER, panel);
//	frame.getContentPane().add(BorderLayout.EAST, panel2);
	frame.getContentPane().add(BorderLayout.NORTH, HeaderPanel);
	frame.getContentPane().add(BorderLayout.CENTER, LabelPanel);
	frame.getContentPane().add(BorderLayout.SOUTH, SouthPanel);

	frame.setSize(1280,960);
    frame.setVisible(true);
    }

	/*
	class labelPanel extends JPanel {
		//inner class
		//adds the graphics on panel. this method is called when the PANEL is initiated. and when frame.repaint() is called
		LabelPanel.add(NumQuestionPanel);
		LabelPanel.add(SectionPanel);
		LabelPanel.add(MovementPanel);
		LabelPanel.add(ComposerPanel);
		LabelPanel.add(PiecePanel);
		LabelPanel.add(FilePathPanel);
		
	}
	 */
	
	/*
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
*/

	
class PhaseListener implements ActionListener {
//inner class
//what to do when mortgage button is clicked
	public void actionPerformed(ActionEvent event) {
		area.append(" Phase button works: \n"); //test code
		//textbar.requestFocus();
		//Code here to mortgage/unmortgage properties?
	}
}
	
class QuitListener implements ActionListener {
//inner class
//what to do when buy houses button is clicked
	public void actionPerformed(ActionEvent event) {
		area.append(" Quit button works: \n"); //test code
		//textbar.requestFocus();
		//code here to buy houses/hotels/
	}
}

class SubmitListener implements ActionListener {
	//inner class
	//what to do when buy houses button is clicked
	public void actionPerformed(ActionEvent event) {
		area.append(" Submit button works, Should post all the options that are set \n"); //test code
		//textbar.requestFocus();
		//code here to buy houses/hotels/
	}
}
	
	
	
/*
class textListener implements ActionListener {	
//inner class
//what to do when enter is hit (saves text, puts it in the JTextArea)
	 public void actionPerformed(ActionEvent evt) {
			inputtext = textbar.getText(); //change textbar to be the 3 different textbars.
			area.append(inputtext + "\n");
			textbar.setText("");
		//something here to interpret the users answers?
	}
} 
*/
	
/*	
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
 */

	
}