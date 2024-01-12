package TicketSystem;

import SharedResources.Variables;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class SystemButtons
{
    static void closeWindow()
    {
        System.exit(0);
    }
    static void ownUnown()
    {
        Connection conn;
        PreparedStatement stmt;

        try
        {
            Class.forName(Variables.className);
            String url = Variables.sqlURL;
            conn = DriverManager.getConnection(url);
            stmt = conn.prepareStatement("UPDATE [ITHELP].[dbo].[HELPRECORD] SET OWNER = '"
                    + System.getenv("COMPUTERNAME")+"' WHERE DATE = '"
                    + TicketSystemUI.tableData[TicketSystemUI.selectedRow][0] +"'"
                    + "AND TIME = '" + TicketSystemUI.tableData[TicketSystemUI.selectedRow][1] + "'");

            stmt.executeUpdate();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

        if (TicketSystemUI.tableData[TicketSystemUI.selectedRow][6] == null)
        {
            TicketSystemUI.tableData[TicketSystemUI.selectedRow][6] = 0;
            TicketSystemUI.tableModel.setValueAt("0", TicketSystemUI.selectedRow,6);

        }
    }

    static void removeEntry()
    {
        Connection conn;
        PreparedStatement stmt;

        try
        {
            Class.forName(Variables.className);
            String url = Variables.sqlURL;
            conn = DriverManager.getConnection(url);
            stmt = conn.prepareStatement("UPDATE [ITHELP].[dbo].[HELPRECORD] SET FIXED = 'YES' WHERE DATE = '" + TicketSystemUI.tableData[TicketSystemUI.selectedRow][0] +"'" + "AND TIME = '" + TicketSystemUI.tableData[TicketSystemUI.selectedRow][1] + "'");

            stmt.executeUpdate();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

        TicketSystemUI.tableModel.removeRow(TicketSystemUI.selectedRow);
    }
}
