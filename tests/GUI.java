import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class GUI extends JFrame implements ActionListener {
    ProbeDb probe = new ProbeDb();


    JPanel pnlTop  = new JPanel();
    JPanel pnlLeft = new JPanel();
    private JTextArea taContent = new JTextArea(); 	

    GUI() {
        super("SQLite Admin");
        setSize(800, 700);
        setLocation(100, 50);

        setLayout(new BorderLayout());

        /*top toolbar*/
        JButton btnClear = new JButton("Clear");
        btnClear. addActionListener(this);
        pnlTop. add(btnClear);
        add(pnlTop, BorderLayout.NORTH);

        /*add tables*/
        try {
            Vector tables = probe.getTables();
            pnlLeft.setLayout(new GridLayout(tables.size() * 2, 1));
            for(int i=0; i<tables.size(); i++) {
                String tableName = (String) tables.elementAt(i);
                JButton btnTableInfo = new JButton(tableName + " (info)");
                btnTableInfo. addActionListener(this);
                pnlLeft.  add(btnTableInfo);
                JButton btnTableData = new JButton(tableName + " (data)");
                btnTableData. addActionListener(this);
                pnlLeft.  add(btnTableData);
            }
        }catch(Exception exp) {
            exp.printStackTrace();
        }

        add(pnlLeft, BorderLayout.WEST);
        add(taContent, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String cmd = ae.getActionCommand();

        if(cmd.endsWith("(info)")) { showTableInfo(cmd.substring(0, cmd.length() - 6)); }

        if(cmd.endsWith("(data)")) { showTableData(cmd.substring(0, cmd.length() - 6)); }

        if(cmd.equals("Clear")) taContent.setText("");
    }

    private void showTableInfo(String tableName) {
        try {
            Vector fields = probe.getColumns(tableName);
            for(int i=0; i<fields.size(); i++) {
                TableField field = (TableField) fields.elementAt(i);
                addLine(field.name() + " : " + field.type());
            }
        }catch(Exception exp) {
            exp.printStackTrace();
        }
    }

    private void showTableData(String tableName) {
        try {
            Vector data = probe.getTableData(tableName);
            for(int i=0; i<data.size(); i++) {
                Vector row = (Vector) data.elementAt(i);
                String line="";
                for(int j=0; j<row.size(); j++) {
                    line += (String) row.elementAt(j) + ", ";
                }
                addLine(line);
            }
        }catch(Exception exp) {
            exp.printStackTrace();
        }
    }

    private void addLine(String line) {
        taContent.setText(taContent.getText() + line + "\n");
    }

    public static void main(String[] args) throws Exception {
        new GUI();
    }
}
