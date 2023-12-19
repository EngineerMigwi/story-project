import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public Main() {
        setTitle("Maringo Sports Club System");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create login/signup components
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        usernameField.setBounds(150,250,400,50);

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        passwordField.setBounds(150,250,400,50); // Set preferred size


        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });

        JButton signupButton = new JButton("Sign Up");
        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSignUp();
            }
        });

        // Create layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(signupButton);

        // Add layout to the frame
        add(panel);

        // Make the frame visible
        setVisible(true);
    }

    private void handleLogin() {
        // Check username and password (you can replace this with your authentication logic)
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());


        if (isValidLogin(username, password)) {
            // Redirect to Club Member page
            openClubMemberFrame();
            // Close the current login/signup frame
            dispose();
        } else {
            showAlert("Invalid Login", "Please check your username and password.");
        }
    }

    private void handleSignUp() {
        // Implement signup logic if needed
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (isValidLogin(username, password)) {
            // Redirect to Club Member page
            openClubMemberFrame();
            // Close the current login/signup frame
            dispose();
        } else {
            showAlert("Invalid Login", "Please check your username and password.");
        }
    }


    private boolean isValidLogin(String username, String password) {
        // Implement your authentication logic here (e.g., check against a database)
        // For simplicity, let's assume a valid login if the fields are not empty
        return !username.isEmpty() && !password.isEmpty();
    }

    private void openClubMemberFrame() {
        // Create a ClubMember instance (replace these values with actual data)
        class ClubMember{
            public <E> ClubMember(String johnDoe, String male, String janeDoe, String date, String number, String maringo, String abcSchool, ArrayList<E> es, double v, double v1, String none) {
            }

            public char getFullName() {
                return 0;
            }

            public char getGender() {
                return 0;
            }
            public char getNextOfKin(){
                return 0;

            }
            public int getDateOfBirth(){return 0;}
            public int getContactdetails(){return 0;}

        }
        ClubMember member = new ClubMember("John Doe", "Male", "Jane Doe", "2000-01-01", "123456789",
                "Maringo", "ABC School", new ArrayList<>(), 70.5, 175.0, "None");

        JFrame clubMemberFrame = new JFrame("Club Member Page");
        clubMemberFrame.setSize(400, 300);
        clubMemberFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create labels and text fields for ClubMember attributes
        JLabel fullNameLabel = new JLabel("Full Name:");
        JTextField fullNameField = new JTextField(member.getFullName());
        fullNameField.setEditable(true);

        JLabel genderLabel = new JLabel("Gender:");
        JTextField genderField = new JTextField(member.getGender());
        genderField.setEditable(true);

        JLabel nextOfKin= new JLabel("Next Of Kin");
        JTextField nextOfKinField = new JTextField(member.getNextOfKin());
        nextOfKinField.setEditable(true);

        JLabel dateOfBirth=new JLabel("Date of birth");
        JTextField dateOfBirthField=new JTextField(member.getDateOfBirth());
        dateOfBirthField.setEditable(true);

        JLabel contactDetails= new JLabel("Contact details");
        JTextField contactDetailsField=new JTextField(member.getContactdetails());
        contactDetailsField.setEditable(true);






        // ... add similar labels and text fields for other attributes

        // Create layout for Club Member page
        JPanel clubMemberPanel = new JPanel();
        clubMemberPanel.setLayout(new GridLayout(6, 2));
        clubMemberPanel.add(fullNameLabel);
        clubMemberPanel.add(fullNameField);
        clubMemberPanel.add(genderLabel);
        clubMemberPanel.add(genderField);
        clubMemberPanel.add(nextOfKin);
        clubMemberPanel.add(nextOfKinField);
        clubMemberPanel.add(dateOfBirth);
        clubMemberPanel.add(dateOfBirthField);
        clubMemberPanel.add(contactDetails);
        clubMemberPanel.add(contactDetailsField);

        // ... add similar labels and text fields for other attributes

        // Add layout to the Club Member frame
        clubMemberFrame.add(clubMemberPanel);

        // Make the Club Member frame visible
        clubMemberFrame.setVisible(true);
    }


    private void showAlert(String title, String message) {
        // Show a message dialog with the provided title and message
        JOptionPane.showMessageDialog(this, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }});
    }
}