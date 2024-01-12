package TicketSystem;

import SharedResources.UIMethods;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TicketSystemUI
{
    static JFrame hsFrame = new JFrame();

    static int hsX = 800;
    static int hsY = 600;

    static int selectedRow;
    public static String thisDate = "";
    static String thisTime = "";
    static JLabel user = new JLabel("User: " + System.getenv("USERNAME"));
    static JLabel date = new JLabel("");

    static JButton remove = new JButton("Remove");
    static JButton own = new JButton("Own Task");
    static JButton close = new JButton("Close");

    public static JTable table;
    public static DefaultTableModel tableModel;

    static String date0 = "";
    static String time0 = "";
    static String name0 = "";
    static String station0 = "";
    static String issue0 = "";
    static String desc0 = "";
    static String own0 = "";
    static String fix0 = "";

    static String date1 = "";
    static String time1 = "";
    static String name1 = "";
    static String station1 = "";
    static String issue1 = "";
    static String desc1 = "";
    static String own1 = "";
    static String fix1 = "";

    static String date2 = "";
    static String time2 = "";
    static String name2 = "";
    static String station2 = "";
    static String issue2 = "";
    static String desc2 = "";
    static String own2 = "";
    static String fix2 = "";

    static String date3 = "";
    static String time3 = "";
    static String name3 = "";
    static String station3 = "";
    static String issue3 = "";
    static String desc3 = "";
    static String own3 = "";
    static String fix3 = "";

    static String date4 = "";
    static String time4 = "";
    static String name4 = "";
    static String station4 = "";
    static String issue4 = "";
    static String desc4 = "";
    static String own4 = "";
    static String fix4 = "";

    static String date5 = "";
    static String time5 = "";
    static String name5 = "";
    static String station5 = "";
    static String issue5 = "";
    static String desc5 = "";
    static String own5 = "";
    static String fix5 = "";

    static String date6 = "";
    static String time6 = "";
    static String name6 = "";
    static String station6 = "";
    static String issue6 = "";
    static String desc6 = "";
    static String own6 = "";
    static String fix6 = "";

    static String date7 = "";
    static String time7 = "";
    static String name7 = "";
    static String station7 = "";
    static String issue7 = "";
    static String desc7 = "";
    static String own7 = "";
    static String fix7 = "";

    static String date8 = "";
    static String time8 = "";
    static String name8 = "";
    static String station8 = "";
    static String issue8 = "";
    static String desc8 = "";
    static String own8 = "";
    static String fix8 = "";

    static String date9 = "";
    static String time9 = "";
    static String name9 = "";
    static String station9 = "";
    static String issue9 = "";
    static String desc9 = "";
    static String own9 = "";
    static String fix9 = "";

    static String date10 = "";
    static String time10 = "";
    static String name10 = "";
    static String station10 = "";
    static String issue10 = "";
    static String desc10 = "";
    static String own10 = "";
    static String fix10 = "";

    static String date11 = "";
    static String time11 = "";
    static String name11 = "";
    static String station11 = "";
    static String issue11 = "";
    static String desc11 = "";
    static String own11 = "";
    static String fix11 = "";

    static String date12 = "";
    static String time12 = "";
    static String name12 = "";
    static String station12 = "";
    static String issue12 = "";
    static String desc12 = "";
    static String own12 = "";
    static String fix12 = "";

    public static Object[][] tableData = {
            {date0, time0, name0, station0, issue0, desc0, own0, fix0},
            {date1, time1, name1, station1, issue1, desc1, own1, fix1},
            {date2, time2, name2, station2, issue2, desc2, own2, fix2},
            {date3, time3, name3, station3, issue3, desc3, own3, fix3},
            {date4, time4, name4, station4, issue4, desc4, own4, fix4},
            {date5, time5, name5, station5, issue5, desc5, own5, fix5},
            {date6, time6, name6, station6, issue6, desc6, own6, fix6},
            {date7, time7, name7, station7, issue7, desc7, own7, fix7},
            {date8, time8, name8, station8, issue8, desc8, own8, fix8},
            {date9, time9, name9, station9, issue9, desc9, own9, fix9},
            {date10, time10, name10, station10, issue10, desc10, own10, fix10},
            {date11, time11, name11, station11, issue11, desc11, own11, fix11},
            {date12, time12, name12, station12, issue12, desc12, own12, fix12}
    };

    public static String[] columnNames = {
            "Date",
            "Time",
            "Station",
            "Employee",
            "Issue",
            "Description",
            "Owner"
            //,"FIXED"
    };

    public static void createUI()
    {
        hsFrame.setTitle("IT Ticketing System");
        hsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hsFrame.setSize(hsX, hsY);
        hsFrame.setLocationRelativeTo(null);

        DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter tf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        thisDate = df.format(now);
        thisTime = tf.format(now);

        date.setText("Date: " + thisDate);

        tableModel = new DefaultTableModel(tableData, columnNames);

        table = new JTable(tableModel);

        UIMethods.setTable(hsFrame, table, hsX / 2 - 358, hsY / 2 - 230, 700, 390);

        UIMethods.setLabelBounds(hsFrame, user, hsX / 2 - 350, hsY / 2 - 285, 150, 25);
        UIMethods.setLabelBounds(hsFrame, date, hsX / 2 + 238, hsY / 2 - 285, 150, 25);

        UIMethods.setButtonBounds(hsFrame, remove, hsX / 2 - 285, hsY / 2 + 180, 150, 50);
        UIMethods.setButtonBounds(hsFrame, own, hsX / 2 - 85, hsY / 2 + 180, 150, 50);
        UIMethods.setButtonBounds(hsFrame, close, hsX / 2 + 115, hsY / 2 + 180, 150, 50);

        hsFrame.setResizable(false);
        hsFrame.setLayout(null);
        hsFrame.setVisible(true);

        close.addActionListener(e -> SystemButtons.closeWindow());
        own.addActionListener(e -> SystemButtons.ownUnown());
        remove.addActionListener(e -> SystemButtons.removeEntry());

        table.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectedRow = table.rowAtPoint(evt.getPoint());

                if (TicketSystemUI.tableData[TicketSystemUI.selectedRow][6] != null)
                {
                    own.setEnabled(false);
                }
                else
                {
                    own.setEnabled(true);
                }
            }
        });

        Runnable getUpdatedTable = UIMethods::fillTable;

        ScheduledExecutorService executeThis = Executors.newScheduledThreadPool(1);
        executeThis.scheduleAtFixedRate(getUpdatedTable,0,1, TimeUnit.MINUTES);
    }
}
