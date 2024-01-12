import TicketSystem.TicketSystemUI;
import UserSystem.HelpSystemUI;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        }
        catch(Exception e)
        {
            throw new RuntimeException(e);
        }

        String pcName = System.getenv("COMPUTERNAME");
        String[] options = {"1", "2", "Cancel"};

        if (pcName.startsWith("ITDPT"))
        {
            int thisOption = JOptionPane.showOptionDialog(
                    null,
                    "Select version to run.\n1.Ticket System\n2.Help System",
                    "Which Version?",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,options,options[0]);

            if (thisOption == 0)
            {
                TicketSystemUI.createUI();
            }

            if (thisOption == 1)
            {
                HelpSystemUI.createUI();
            }

            if (thisOption == 2)
            {
                System.exit(0);
            }
        }
        else
        {
            HelpSystemUI.createUI();
        }
    }
}