package database;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class OnlineSurveySystem {
	private static JFrame mainFrame;
	private static JPanel loginPanel;
	private static JPanel surveyCreationPanel;
	
	private static List<Survey> surveys= new ArrayList<>();

	public static void main(String[] args) {
		
		createLoginForm();

	}
	
	public void createLoginForm() {
		mainFrame = new JFrame("Login");
		mainFrame.setSize(300, 150);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    loginPanel= new JPanel();
	    mainFrame.add(loginPanel);
	    placeComponents(loginPanel);
	    
	    mainFrame.setVisible(true);
	    
	}
	
	public static void placeComponents(JPanel panel) {
		panel.setLayout(null);
		
		JLabel userLabel = new JLabel("User:");
		userLabel.setBounds(10, 20, 80, 25);
		panel.add(userLabel);
		
		JTextField userText = new JTextField(20);
		userText.setBounds(100, 20, 125, 25);
		panel.add(userText);
		
		JLabel passwordLabel = new JLabel ("Password:");
		passwordLabel.setBounds(100, 50, 165, 25);
		panel.add(passwordLabel);
		
		JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 50, 165, 25);
		panel.add(passwordText);
		
		JButton loginButton = new JButton("Login");
		loginButton.setBounds(10, 80, 80, 25);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username =userText.getText();
				//perform authenticate logic here
				if (authenticate(username, new String(passwordText.getPassword()))) {
                    mainFrame.dispose();
                    createSurveyCreationForm();
				
			}else {
				JOptionPane.showConfirmDialog(mainFrame, "Invalid Username or Password", "error", JOptionPane.ERROR_MESSAGE);
				
			}
		}
		});
		
		panel.add(loginButton);
		

		private static boolean authenticate(String username, String password) {
		
	        return username.equals("admin") && password.equals("admin123");
			}

			private void createSurveyCreationForm() {
				surveyCreationPanel = new JPanel (new BorderLayout());
					mainFrame = new JFrame("SurveyCreation");
					mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
					JLabel titleLabel = new JLabel("Create New Survey");
					titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
					surveyCreationPanel.add(titleLabel , BorderLayout.NORTH);
					
					JPanel questionPanel = new JPanel (new GridLayout(0,1));
					JTextField questionField = new JTextField();
					questionPanel.add(new JLabel("Enter question:"));
					questionPanel.add(questionField);
					
					JComboBox<String> questionTypeComboBox = new JComboBox<>(new String[]{"Multiple Choice", "Text Input", "Rating Scale"});
			        questionPanel.add(new JLabel("Select Question Type:"));
			        questionPanel.add(questionTypeComboBox);
			        
			        JButton addQuestionButton = new JButton("Add Question");
			        addQuestionButton.addActionListener(new ActionListener() {
			            
			            public void actionPerformed(ActionEvent e) {
			                String questionText = questionField.getText();
			                String questionType = (String) questionTypeComboBox.getSelectedItem();
			                // Create question based on type (not implemented here)
			                Question question = createQuestion(questionText, questionType);
			                // Add question to survey (not implemented here)
			                addQuestionToSurvey(question);
			                JOptionPane.showMessageDialog(mainFrame, "Question added successfully");
			            }
			        });
			        
			        questionPanel.add(addQuestionButton);

			        surveyCreationPanel.add(questionPanel, BorderLayout.CENTER);
			        
			        JButton saveSurveyButton = new JButton("Save Survey");
			        saveSurveyButton.addActionListener(new ActionListener() {
			            
			            public void actionPerformed(ActionEvent e) {
			                // Save survey to database (not implemented here)
			                surveys.add(new Survey("New Survey", new ArrayList<>())); // Dummy survey creation
			                JOptionPane.showMessageDialog(mainFrame, "Survey saved successfully");
			            }
			        });
			        
			        surveyCreationPanel.add(saveSurveyButton, BorderLayout.SOUTH);

			        mainFrame.add(surveyCreationPanel);
			        mainFrame.setSize(400, 300);
			        mainFrame.setVisible(true);
			        private static Question createQuestion(String questionText, String questionType) {
			            // Create question based on type (not implemented here)
			            // Implement based on the selected type
			            return new Question(questionText, QuestionType.MULTIPLE_CHOICE); // Dummy implementation
			        }

			        private static void addQuestionToSurvey(Question question) {
			            // Add question to survey (not implemented here)
			            // surveys.get(currentSurveyIndex).addQuestion(question); // Implement based on your survey structure
			        }
			    }
			        
			       
					
					
					
				
				
			
		
		
		
		
		
	}

	private static boolean authenticate(String username, String password) {
		// TODO Auto-generated method stub
		
	}
	
	
}
