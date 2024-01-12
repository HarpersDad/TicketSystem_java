package SharedResources;

import TicketSystem.TicketSystemUI;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;

public class UIMethods
{
    // create and set Text Field bounds
    public static void setTextBounds(JFrame myFrame, JTextArea myText, int x, int y, int w, int h)
    {
        myText.setFont(new Font("Arial", Font.PLAIN, 12));
        myText.setBounds(x, y, w, h);
        myText.setForeground(Color.BLACK);
        myFrame.getContentPane().add(myText);
    }

    // create and set Button bounds
    public static void setButtonBounds(JFrame myFrame, JButton myButton, int x, int y, int w, int h)
    {
        myButton.setFont(new Font("Arial", Font.PLAIN, 16));
        myButton.setBounds(x, y, w, h);
        myButton.setForeground(Color.BLACK);
        myFrame.getContentPane().add(myButton);
    }

    // create and set data labels
    public static void setLabelBounds(JFrame myFrame, JLabel myLabel, int x, int y, int w, int h)
    {
        myLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        myLabel.setBounds(x, y, w, h);
        myLabel.setForeground(Color.BLACK);
        myFrame.getContentPane().add(myLabel);
    }

    // create and set radio buttons
    public static void setRadioButtonBounds(JFrame myFrame, JRadioButton myRadioButton, int x, int y, int w, int h)
    {
        myRadioButton.setBounds(x, y, w, h);
        //myRadioButton.setForeground(Color.BLACK);
        myFrame.getContentPane().add(myRadioButton);
    }

    // create table
    public static void setTable(JFrame myFrame, JTable myTable, int x, int y, int w, int h)
    {
        Border border = BorderFactory.createMatteBorder(0, 1, 1, 1, Color.BLACK);

        myTable.setBounds(x,y,w,h);
        myTable.getTableHeader().setBounds(x,y-25,w,25);
        myTable.setRowHeight(30);
        myTable.setBorder(border);

        myFrame.add(myTable.getTableHeader());
        myFrame.getContentPane().add(myTable);
    }

    public static void fillTable()
    {
        Connection conn;
        PreparedStatement stmt;
        ResultSet rs;

        boolean jeff = true;

        while (jeff)
        {
            try
            {
                Class.forName(Variables.className);
                String url = Variables.sqlURL;
                conn = DriverManager.getConnection(url);
                stmt = conn.prepareStatement("SELECT * FROM [ITHELP].[dbo].[HELPRECORD] WHERE DATE = '" + TicketSystemUI.thisDate +"'");

                rs = stmt.executeQuery();

                int i = 0;

                while (rs.next())
                {
                    boolean skipped = false;
                    for (int n = 0; n < 7; n++)
                    {
                        if (Objects.equals(rs.getString(8).trim(), "YES"))
                        {
                            skipped = true;
                        }
                        else
                        {
                           TicketSystemUI.tableData[i][n] = rs.getString(n+1);
                            TicketSystemUI.tableModel.setValueAt(rs.getString(n+1), i,n);
                        }
                    }

                    if (!skipped)
                    {
                        i++;
                    }
                }
                TicketSystemUI.tableModel.fireTableDataChanged();
            }
            catch (Exception e)
            {
                throw new RuntimeException(e);
            }
            jeff = false;
        }
    }
}
