import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

//implements TestGUI
public class TestGUI {
	//initialize variables
    private JFrame frame;
	
	//these will need to be placed next to their according headers
	private JTextField TitleTextField;
	private JTextField MovementTextField;
	private JTextField OpusTextField;
	private JTextField ComposerTextField;
	private JTextField InfoTextField;
	
	
	private JLabel header;
	//these are on the JPanel LabelPanel
	private JLabel Title;
	private JLabel Movement;
	private JLabel Opus;
	private JLabel Composer;
	private JLabel RelevantInfo;
	
    private JButton Play;
    private JButton Pause;
    private JButton NextQuestion;
    private JButton Quit;
	private String inputtext;
	
	private JTextArea area; // display text
	private JScrollPane scroller;
	
	private JPanel LabelPanel;
	private JPanel HeaderPanel;
	private JPanel TitlePanel;
	private JPanel MovementPanel;
	private JPanel ComposerPanel;
	private JPanel RelevantInfoPanel;
	private JPanel ButtonPanel;
	
    public static void main (String[] args){	
		TestGUI gui = new TestGUI();
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
		TitlePanel = new titlePanel();
		MovementPanel = new movementPanel();
		ComposerPanel = new composerPanel();
		RelevantInfoPanel = new infoPanel();
		ButtonPanel = new buttonPanel();
		
		HeaderPanel.add(header);
		HeaderPanel.add(scroller);
		
		//the next lines need to be on a fram added to the west. Boxlayout/Y-axis
		//use with the coinciding checkboxes/textfields/buttons...
		//also look at formatting to separate from the "Options" tag and spacing/fonts
		//** format to look like above, with the ability to add correct answers after the headers
		LabelPanel.add(TitlePanel);
		LabelPanel.add(MovementPanel);
		LabelPanel.add(ComposerPanel);
		LabelPanel.add(RelevantInfoPanel);
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

	class titlePanel extends JPanel {
		titlePanel() {
			Title		 = new JLabel("Title: ");
			this.add(Title);
			TitleTextField = new JTextField(80);
			//	TitleTextField.addActionListener(new textListener());
			this.add(TitleTextField);
		}
	}
	
	class movementPanel extends JPanel {
		movementPanel() {
			Movement	 = new JLabel("Movement: ");
			MovementTextField = new JTextField(20);
			//	MovementTextField.addActionListener(new textListener());
			Opus		 = new JLabel("Opus #: ");
			OpusTextField = new JTextField(20);
			//	OpusTextField.addActionListener(new textListener());
			this.add(Movement);
			this.add(MovementTextField);
			this.add(Opus);
			this.add(OpusTextField);
		}
	}
	
	class composerPanel extends JPanel {
		composerPanel() {
			Composer	 = new JLabel("Composer: ");
			ComposerTextField = new JTextField(50);
			//	ComposerTextField.addActionListener(new textListener());
			this.add(Composer);
			this.add(ComposerTextField);
		}
	}
	
	class infoPanel extends JPanel {
		infoPanel() {
			RelevantInfo = new JLabel("Relevant Info: ");
			InfoTextField = new JTextField(80);
			//	InfoTextField.addActionListener(new textListener());
			this.add(RelevantInfo);
			this.add(InfoTextField);
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
			area.append(" Next Question button works: \n");
		}
	}
	class QuitListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			area.append(" Quit button works: \n");
		}
	}	
	
}