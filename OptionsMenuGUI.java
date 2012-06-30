import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

//implements OptionsMenuGUI
public class OptionsMenuGUI {
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
	
	private ButtonGroup FilePathGroup;
	private JRadioButton ItunesButton;
	private JRadioButton FolderButton;
	private JRadioButton OtherButton;	
	
    public static void main (String[] args){	
		OptionsMenuGUI gui = new OptionsMenuGUI();
		gui.setup();
    }
    
    public void setup() {
		//sets up the GUI
		
		frame = new JFrame(); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		LabelPanel = new JPanel();
		LabelPanel.setLayout(new BoxLayout(LabelPanel,BoxLayout.Y_AXIS));
		
		HeaderPanel = new HeaderComponents();
		NumQuestionPanel = new NumberQuestionsComponents();
		SectionPanel = new SectionComponents();
		MovementPanel = new MovementComponents();
		ComposerPanel = new ComposerComponents();
		PiecePanel = new PiecePriorityComponents();
		FilePathPanel = new  FilePathComponents();
		SouthPanel = new ButtonComponents();
		
		
		//the next lines need to be on a fram added to the west. Boxlayout/Y-axis
		//use with the coinciding checkboxes/textfields/buttons...
		//also look at formatting to separate from the "Options" tag and spacing/fonts
		// in between each of these add their according checkbox components
		HeaderPanel.add(header);
		HeaderPanel.add(scroller);
		
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

		FilePathPanel.add(ItunesButton);
		FilePathPanel.add(FolderButton);
		FilePathPanel.add(OtherButton); 
		//make a newline here. also make it so that when 
		// different buttons are pressed the textfield acts differently
		FilePathPanel.add(FilePathLabel);
		FilePathPanel.add(FilePathTextField);
		FilePathPanel.add(BrowseButton);
		
		SouthPanel.add(SubmitButton);
		SouthPanel.add(NextPhaseButton);
		SouthPanel.add(QuitButton);		
		
		LabelPanel.add(NumQuestionPanel);
		LabelPanel.add(SectionPanel);
		LabelPanel.add(MovementPanel);
		LabelPanel.add(ComposerPanel);
		LabelPanel.add(PiecePanel);
		LabelPanel.add(FilePathPanel);
		
		frame.getContentPane().add(BorderLayout.NORTH, HeaderPanel);
		frame.getContentPane().add(BorderLayout.CENTER, LabelPanel);
		frame.getContentPane().add(BorderLayout.SOUTH, SouthPanel);
		
		frame.setSize(1280,960);
		frame.setVisible(true);
    }
	
	
	
	class  HeaderComponents extends JPanel {
		HeaderComponents() {
			header			= new JLabel("Options"); //look at fonts/spacing/formatting
			area = new JTextArea(10,100); // move this to the header, and use it as display directions.
			area.setEditable(false);
			scroller = new JScrollPane(area);
			area.setLineWrap(true);
			scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		}
	}
	
	class  NumberQuestionsComponents extends JPanel {
		NumberQuestionsComponents() {
			NumQuestions	= new JLabel("Number of Questions: ");
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
		}
	}
	class  SectionComponents extends JPanel {
		SectionComponents() {
			SectionPiece	= new JLabel("Section of Piece: ");
			BeginningBox = new JCheckBox("Beginning");
			MiddleBox	 = new JCheckBox("Middle");
			EndBox		 = new JCheckBox("End");
			RandBox		 = new JCheckBox("Random");
		}
	}
	class  MovementComponents extends JPanel {
		MovementComponents() {
			MovementLimit	= new JLabel("Movements: ");
			OneBox		 = new JCheckBox("First");
			TwoBox		 = new JCheckBox("Second");
			ThreeBox	 = new JCheckBox("Third");
			FourBox		 = new JCheckBox("Fourth");
			AllBox		 = new JCheckBox("All");
		}
	}
	class  ComposerComponents extends JPanel {
		ComposerComponents() {
			ComposerLimit	= new JLabel("Limit Composers: ");
			ComposerTextField = new JTextField(50);
			//textlistener
		}
	}
	class  PiecePriorityComponents extends JPanel {
		PiecePriorityComponents() {
			PieceLimit		= new JLabel("Prioritze Pieces(Op. #): ");
			PieceTextField	  = new JTextField(50);
			//textlistener
		}
	}
	
	class  FilePathComponents extends JPanel {
		 FilePathComponents() {
			ItunesButton	= new JRadioButton("Itunes");
			ItunesButton.setSelected(true);
			//		ItunesButton.setActionCommand("Itunes");
			FolderButton	= new JRadioButton("Folder");
			OtherButton		= new JRadioButton("Other");
			
			FilePathGroup	= new ButtonGroup();
			FilePathGroup.add(ItunesButton);
			FilePathGroup.add(FolderButton);
			FilePathGroup.add(OtherButton);
			
			FilePathLabel	= new JLabel("Enter File Path: ");
			FilePathTextField = new JTextField(50);
			//textfieldlistener, for testing, when enter is pressed then display the text.
			BrowseButton = new JButton("Browse");
			BrowseButton.addActionListener(new BrowseListener());
		}
	}
	
	class  ButtonComponents extends JPanel {
		ButtonComponents() {
			SubmitButton = new JButton("Submit");
			SubmitButton.addActionListener(new SubmitListener());
			NextPhaseButton = new JButton("Next Phase");
			NextPhaseButton.addActionListener(new PhaseListener());
			QuitButton = new JButton("Quit");
			QuitButton.addActionListener(new QuitListener());
		}
	}
	
	class PhaseListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			area.append(" Phase button works: \n"); 
		}
	}
	
	class QuitListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			area.append(" Quit button works: \n"); 
		}
	}
	
	class SubmitListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			area.append(" Submit button works, Should post all the options that are set \n"); //test code
		}
	}
	
	class BrowseListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			area.append(" Browse button works \n");
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
}