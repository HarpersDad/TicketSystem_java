package UserSystem;

import SharedResources.Variables;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SendHelpRequest
{
    public static void sendRequest()
    {
        ProcessBuilder pb = new ProcessBuilder().inheritIO().command(
                        "powershell",
                        "Send-MailMessage " +
                        "-From " + Variables.userName.replaceAll(" ", "") +"@" +Variables.userStation + ".com " +
                        "-To yourMom@home.com " +
                        "-Subject " + Variables.selectedIssue + " " +
                        "-Body 'Employee: " + Variables.userName + "\nWorkStation: " + Variables.userStation + "\nIssue: " + Variables.selectedIssue + "\nDescription: " + Variables.userDesc + "' " +
                        "-SmtpServer " +
                        "-Port "
                );

        try
        {
            pb.start();
            Variables.wasSent = true;
        }
        catch(IOException e)
        {
            Variables.wasSent = false;
        }

        if (Variables.wasSent)
        {
            updateDB();
        }
    }

    public static void updateDB()
    {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter tf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        String thisDate = df.format(now);
        String thisTime = tf.format(now);

        Connection conn;
        PreparedStatement stmt;

        try
        {
            Class.forName(Variables.className);
            String url = Variables.sqlURL;
            conn = DriverManager.getConnection(url);
            stmt = conn.prepareStatement("INSERT INTO [ITHELP].[dbo].[HELPRECORD] (DATE, TIME, STATIONID, EMPLOYEE, ISSUE, DESCRIPTION, FIXED) " +
                    "VALUES ('" + thisDate + "', '" + thisTime + "', '" + Variables.userStation + "', '" + Variables.userName + "', '" + Variables.selectedIssue + "', '" + Variables.userDesc + "', 'NO')");

            stmt.executeUpdate();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
