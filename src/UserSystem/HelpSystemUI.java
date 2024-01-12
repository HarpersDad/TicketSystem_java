package UserSystem;

import SharedResources.UIMethods;
import javax.swing.*;

public class HelpSystemUI
{
    static JFrame hsFrame = new JFrame();
    static int hsX = 600;
    static int hsY = 400;

    static JButton cancel = new JButton("Cancel");
    static JButton submit = new JButton("Submit");
    static JLabel issue = new JLabel("Choose Issue: ");
    static JRadioButton emailIssue = new JRadioButton();
    static JLabel emailIssueL = new JLabel("Email");
    static JRadioButton printerIssue = new JRadioButton();
    static JLabel printerIssueL = new JLabel("Printer");
    static JRadioButton kavisIssue = new JRadioButton();
    static JLabel kavisIssueL = new JLabel("Kavis");
    static JRadioButton otherIssue = new JRadioButton();
    static JLabel otherIssueL = new JLabel("Other");
    static JTextArea issueDescription = new JTextArea();
    static JLabel issueDescriptionL = new JLabel("Describe your issue: ");
    static JLabel userNameL = new JLabel("User: ");
    static JLabel userName = new JLabel(System.getenv("USERNAME"));
    static JLabel userPCNameL= new JLabel("Station: ");
    static JLabel userPCName= new JLabel(System.getenv("COMPUTERNAME"));

    public static void createUI()
    {
        hsFrame.setTitle("Help System");
        hsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hsFrame.setSize(hsX,hsY);
        hsFrame.setLocationRelativeTo(null);

        // function calls to create UI elements
        // Username, Station Name and Labels
        UIMethods.setLabelBounds(hsFrame,userName,85,5, 100,25);
        UIMethods.setLabelBounds(hsFrame,userNameL,50,5, 50,25);

        UIMethods.setLabelBounds(hsFrame,userPCName,hsX - 100,5, 100,25);
        UIMethods.setLabelBounds(hsFrame,userPCNameL,hsX - 145,5, 100,25);

        // Buttons
        UIMethods.setButtonBounds(hsFrame,cancel,hsX/2 + 25,hsY/2 + 110,85,35);
        UIMethods.setButtonBounds(hsFrame,submit,hsX/2 - 125,hsY/2 + 110,85,35);

        // Text Area
        UIMethods.setTextBounds(hsFrame, issueDescription, hsX/2 - 255,hsY/2 - 100, 500,200);
        UIMethods.setLabelBounds(hsFrame, issueDescriptionL, hsX/2 - 250,hsY/2 - 125, 200,25);

        // Radio Buttons and Labels
        UIMethods.setLabelBounds(hsFrame, issue, hsX/2 - 60, 25, 100, 25);

        UIMethods.setRadioButtonBounds(hsFrame, emailIssue, 200, 50, 25,25);
        UIMethods.setLabelBounds(hsFrame,emailIssueL,225,50,100,25);

        UIMethods.setRadioButtonBounds(hsFrame, printerIssue, 300, 50, 25,25);
        UIMethods.setLabelBounds(hsFrame,printerIssueL,325,50,100,25);

        UIMethods.setRadioButtonBounds(hsFrame, kavisIssue, 100, 50, 25,25);
        UIMethods.setLabelBounds(hsFrame,kavisIssueL,125,50,100,25);

        UIMethods.setRadioButtonBounds(hsFrame, otherIssue, 400, 50, 25,25);
        UIMethods.setLabelBounds(hsFrame,otherIssueL,425,50,100,25);

        hsFrame.setResizable(false);
        hsFrame.setLayout(null);
        hsFrame.setVisible(true);

        cancel.addActionListener(e -> UserButtons.cancelRequest());
        submit.addActionListener(e -> UserButtons.submitRequest());

        emailIssue.addActionListener(e->UserButtons.emailIssueSelection());
        kavisIssue.addActionListener(e->UserButtons.kavisIssueSelection());
        printerIssue.addActionListener(e->UserButtons.printerIssueSelection());
        otherIssue.addActionListener(e->UserButtons.otherIssueSelection());
    }
}
