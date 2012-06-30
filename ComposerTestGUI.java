import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

//implements ComposerTestGUI
public class ComposerTestGUI {
	//initialize variables
    private JFrame frame;
	
	private JLabel header;
	//these are on the JPanel LabelPanel
	private JLabel Composer;
	
	//multiple choice stuff here
	public ButtonGroup AnswersGroup;
	private JRadioButton FirstChoice;
	private JRadioButton SecondChoice;
	private JRadioButton ThirdChoice;
	private JRadioButton FourthChoice;
	private JRadioButton NoneChoice;	
	
    private JButton Play;
    private JButton Pause;
    private JButton NextQuestion;
    private JButton Quit;
	private String inputtext;
	
	private JTextArea area; // display text
	private JScrollPane scroller;
	
	private JPanel LabelPanel;
	private JPanel HeaderPanel;
	private JPanel ComposerPanel;
	private JPanel ButtonPanel;
	
    public static void main (String[] args){	
		ComposerTestGUI gui = new ComposerTestGUI();
		gui.setup();
    }
    
    public void setup() {
		//sets up the GUI
		
		frame = new JFrame(); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
				
		//Create a display options panel which displays the user defined options at the top
		LabelPanel = new JPanel();
		LabelPanel.setLayout(new BoxLayout(LabelPanel,BoxLayout.Y_AXIS));
		HeaderPanel = new headerPanel();
		ComposerPanel = new composerPanel();
		ButtonPanel = new buttonPanel();
		
		HeaderPanel.add(header);
		HeaderPanel.add(scroller);
		
		LabelPanel.add(ComposerPanel);
		LabelPanel.add(ButtonPanel);	
		
		frame.getContentPane().add(BorderLayout.NORTH, HeaderPanel);
		frame.getContentPane().add(BorderLayout.CENTER, LabelPanel);
		
		frame.setSize(1200,960);
		frame.setVisible(true);
    }
	
	
	class NewTestListener implements  ActionListener {
		public void actionPerformed(ActionEvent event) {
			area.append(" you pressed the New Test Button! \n");
		}
	}
	
	class headerPanel extends JPanel {
		headerPanel() {
			header		 = new JLabel("Test Question 1"); //look at fonts/spacing/formatting
			String Directions = new String("Directions \n");
			area = new JTextArea(Directions, 5, 80);
			area.setEditable(false);
			scroller = new JScrollPane(area);
			area.setLineWrap(true);
			scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		}
	}
	
	class composerPanel extends JPanel {
		composerPanel() {
			//initialize composer multiple choice and add to the panel
			Composer	 = new JLabel("Composer: ");
			this.add(Composer);
			
			FirstChoice			= new JRadioButton("Beethoven");
			FirstChoice.setActionCommand("Beethoven");
			SecondChoice		= new JRadioButton("Bach");
			SecondChoice.setActionCommand("Bach");
			ThirdChoice			= new JRadioButton("Mozart");
			ThirdChoice.setActionCommand("Mozart");
			FourthChoice		= new JRadioButton("Debussy");
			FourthChoice.setActionCommand("Debussy");
			NoneChoice			= new JRadioButton("None");
			NoneChoice.setSelected(true);
			NoneChoice.setActionCommand("None of the Above");
			
			AnswersGroup	= new ButtonGroup();
			AnswersGroup.add(FirstChoice);
			AnswersGroup.add(SecondChoice);
			AnswersGroup.add(ThirdChoice);
			AnswersGroup.add(FourthChoice);
			AnswersGroup.add(NoneChoice);
			
			this.add(FirstChoice);
			this.add(SecondChoice);
			this.add(ThirdChoice);
			this.add(FourthChoice);
			this.add(NoneChoice);
		}
	}
		
	class buttonPanel extends JPanel {
		buttonPanel() {
			Play = new JButton("Play");
			Play.addActionListener(new PlayListener());
			Pause = new JButton("Pause");
			Pause.addActionListener(new PauseListener());
			NextQuestion = new JButton("NextQuestion");
			NextQuestion.addActionListener(new NextQuestionListener());
			Quit = new JButton("Quit");
			Quit.addActionListener(new QuitListener());
			this.add(Play);
			this.add(Pause);
			this.add(NextQuestion);
			this.add(Quit);
		}
	}
	
	class PlayListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			area.append(" Play button works: \n");
		}
	}
	
	class PauseListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			area.append(" Pause button works: \n");
		}
	}
	
	class NextQuestionListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String answer = new String();
			DefaultButtonModel jrb = new DefaultButtonModel();
			jrb = (DefaultButtonModel) AnswersGroup.getSelection();
			answer = jrb.getActionCommand();
			area.append(answer + "\n");
		}
	}
	
	class QuitListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			area.append(" Quit button works: \n");
		}
	}
	
	// class SetChoices() { //set the four choices for answers by going through the playlist }
	// class PlaySound() { //play the sound for the current question }
	// class SaveAnswer() { //saves the user input answer }
	
}