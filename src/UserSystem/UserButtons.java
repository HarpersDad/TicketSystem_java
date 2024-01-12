package UserSystem;

import SharedResources.Variables;

import javax.swing.*;

public class UserButtons
{
    static void cancelRequest()
    {
        System.exit(0);
    }

    static void submitRequest()
    {
        System.out.println("Request Submitted!");
        Variables.userName = HelpSystemUI.userName.getText();
        Variables.userStation = HelpSystemUI.userPCName.getText();
        Variables.userDesc = HelpSystemUI.issueDescription.getText();

        SendHelpRequest.sendRequest();

        if (Variables.wasSent)
        {
            int choice = JOptionPane.showConfirmDialog(HelpSystemUI.hsFrame, "Request Sent!", "Help Request ", JOptionPane.OK_CANCEL_OPTION);

            if (choice == 0 || choice == 1)
            {
                System.exit(0);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(HelpSystemUI.hsFrame, "Request Was Not Sent!\nPlease Submit Again!");
        }
    }

    static void emailIssueSelection()
    {
        Variables.selectedIssue = "Email";
        HelpSystemUI.printerIssue.setSelected(false);
        HelpSystemUI.kavisIssue.setSelected(false);
        HelpSystemUI.otherIssue.setSelected(false);

        HelpSystemUI.issueDescriptionL.setText("Describe your Email Issue:");
    }

    static void kavisIssueSelection()
    {
        Variables.selectedIssue = "Kavis";
        HelpSystemUI.printerIssue.setSelected(false);
        HelpSystemUI.emailIssue.setSelected(false);
        HelpSystemUI.otherIssue.setSelected(false);

        HelpSystemUI.issueDescriptionL.setText("Describe your Kavis Issue:");
    }

    static void printerIssueSelection()
    {
        Variables.selectedIssue = "Printer";
        HelpSystemUI.emailIssue.setSelected(false);
        HelpSystemUI.kavisIssue.setSelected(false);
        HelpSystemUI.otherIssue.setSelected(false);

        HelpSystemUI.issueDescriptionL.setText("Describe your Printer Issue:");
    }

    static void otherIssueSelection()
    {
        Variables.selectedIssue = "Other";
        HelpSystemUI.printerIssue.setSelected(false);
        HelpSystemUI.kavisIssue.setSelected(false);
        HelpSystemUI.emailIssue.setSelected(false);

        HelpSystemUI.issueDescriptionL.setText("Describe your Other Issue:");
    }
}
