import javax.swing.*;
import java.awt.*;

public class TopPanel extends JPanel{
	/*Buttons*/
	JButton btnDesign 	= new JButton("Design");
	JButton btnManage 	= new JButton("Manage");
	JButton btnSQL 		= new JButton("SQL");
	JButton btnAnalyze 	= new JButton("Analyze");
	JButton btnVerify 	= new JButton("Verify");
	JButton btnOptimize = new JButton("Optimize");
	JButton btnChart 	= new JButton("Chart");
   
    TopPanel() {
		setLayout(new GridLayout(1,8));
		add(btnDesign);
		add(btnManage);
		add(btnSQL);
		add(btnAnalyze);
	    add(btnOptimize);
		add(btnChart);
        setVisible(true);
    }
}/*ToolBarGUI*/
