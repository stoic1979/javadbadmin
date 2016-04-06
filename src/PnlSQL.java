/*****************************************************************************		  
 *                   _____               __    __	     		     *
 *		    / __  \         	|  \  /  |		  	     *
 * 		   | |  |_|             |   \/   |			     *
 *		   | |____  _   _  _ __ | |\  /| |   ____		     *	
 *		   \_____ \| | | || /__|| | \/ | |  /__  \		     *	
 *		    _    | | | | || |   | |    | |  ___| |		     *	
 *		   | |___| | |_| || |   | |    | | / __  | 		     *	
 *		   |______/\ ___ /|_|   |_|    |_| \_____/                   *
 *                                                                           *
 *                                                                           *
 * DESCRIPTION     The main starting class for SurMa desktop applicaiton.    *
 * CREATED         2012-02-06                                                *
 * AUTHOR          WeaveBytes InfoTech R&D Team                              *
 *                                                                           *
 * Copyright (c) 2011 onwards by WeaveBytes InfoTech Pvt. Ltd.               *
 * Please reports bugs at weavebytes@gmail.com                               *
 *                                                                           * 
 * This file may be distributed and/or modified under the terms of the       *
 * GNU General Public License version 2 as published by the Free Software    *
 * Foundation. (See COPYING.GPL for details.)                                *
 *                                                                           *
 * This file is provided AS IS with NO WARRANTY OF ANY KIND, INCLUDING THE   *
 * WARRANTY OF DESIGN, MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. *
 *                                                                           *
 *****************************************************************************/

import javax.swing.table.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class PnlSQL extends JPanel implements ActionListener {

    private ProbeDb        probe;
    private Vector         vctResult;
    private JPanel         pnlUpper, pnlLower;
    private MyTableModel   tm;
    private JTable         tblResult;
	private MyTableModel   tmTableModel;
    private JScrollPane    spTaCommand;
    private int            selectableRow = -1;
    private JComboBox      cmbTables;
    private JLabel         lblSQLQuery;
	private JToolBar	   tbTop;
	private JButton    	   btnExecute;
	private JTextArea	   taCommand;
	
	private int yOffset = 10;
    /**
     * Constructor of SQLiteAdmin
     **/
    PnlSQL() {
        
		//setLayout(new GridLayout(2,1));
		setLayout(null);
		
		probe      = new ProbeDb();		
		vctResult  = new Vector();
		
		pnlUpper = new JPanel();
		pnlUpper. setSize(1200, 220);
		pnlUpper. setLocation(0, 0);
		pnlUpper. setBorder(BorderFactory. createLineBorder(Color.RED));
		pnlUpper. setLayout(null);
		
		lblSQLQuery = new JLabel(Config. APP_LBL_SQL_QUERY);
		lblSQLQuery. setSize(150, 30);
		lblSQLQuery. setLocation(100, yOffset);		
		
		btnExecute = new JButton(Config. APP_BTN_SQL);
        btnExecute. addActionListener(this);
		btnExecute. setActionCommand(Config. APP_BTN_SQL_ACTION_COMMAND);
		btnExecute. setSize(120, 30);
		btnExecute. setLocation(540, yOffset + 170);
		
		taCommand = new JTextArea();
		
		spTaCommand = new JScrollPane(taCommand);
		spTaCommand. setSize(1000,120);
		spTaCommand. setLocation(100,yOffset + 30);
		
		pnlUpper. add(spTaCommand);
		pnlUpper. add(btnExecute);
				
		pnlLower = new JPanel();
		pnlLower. setSize(1200, 310);
		pnlLower. setLocation(0, yOffset + 220);
		pnlLower. setBorder(BorderFactory. createLineBorder(Color.GREEN));
		pnlLower. setLayout(null);
		
		add(lblSQLQuery);
		add(pnlUpper);
		add(pnlLower);
    }

    /**
     * Function to handle events of buttons, menus etc.
     **/
    public void actionPerformed(ActionEvent ae){
        String cmd = ae.getActionCommand();

        if(cmd.equals(Config. APP_BTN_SQL_ACTION_COMMAND)) {
			// if(1 == identifyQuery(query)) {
				
				//tmTableModel = new MyTableModel();
				//tblResult = new JTable();
			// }
        }
    }
	
	 /**
     * Function to identify queries coming from user
     **/
	public int identifyQuery(String query) {
		return 1;
	}
	
	// public Vector getQueryExecuted() {
		// try {
			// vctResult = probe. getRows();
			// ResultSetMetaData rm     = rs. getMetaData();
			// return vctResult;
		// } catch(Exception e) {
			// e.printStackTrace();
		// }
		// return vctResult;
	// }
	
    /************************************************************
        Inner class for creating custom table model
     ************************************************************/
    class MyTableModel extends DefaultTableModel {		

        MyTableModel(Vector data, Vector heading) {
            super(data, heading);
            fireTableDataChanged();
        }

        public boolean isCellEditable(int row, int col) {
            if(selectableRow == row && col < 4 && col > 1) { return true; } 
            else                                           { return false; }
        }

        public Class getColumnClass(int column) {
            return getValueAt(0, column). getClass();
        }

        /*public void setValueAt(Object value, int row, int col) {
          String newValue = (String)value;
          Vector vctRow = (Vector)vctUser.elementAt(row);
          vctRow.set(col,newValue);

        //make row selectable false
        selectableRow = -1;

        //notify table
        fireTableCellUpdated(row, col);
        }
         */
    }/*MyTableModel*/
}/*PnlSQL*/
