public class Config {

    /*log levels*/
    public static final int LOG_DEBUG                   = 1;
    public static final int LOG_INFO                    = 2;
    public static final int LOG_WARNING                 = 3;
    public static final int LOG_CRITICAL                = 4;
    public static final int LOG_ERROR                   = 5;

    public static final int LOG_LEVEL                   = LOG_DEBUG;

    /**********************************************
     *		SQLiteAdmin Main APP Config 
     **********************************************/

    public static final String APP_TITLE = "JSqliteAdmin by :WEAVEBYTES:";

    public static final int APP_WIDTH = 1200;
    public static final int APP_HEIGHT = 720;


    //Combobox
    public static final String APP_CMB_TABLES_ACTION_COMMAND = "selecttable";
    public static final int APP_CMB_TABLES_WIDTH = 100;
    public static final int APP_CMB_TABLES_HEIGHT = 25;
    public static final int APP_CMB_TABLES_X = 10;
    public static final int APP_CMB_TABLES_Y = 50;

    //Label
    public static final String APP_LBL_TABLE_CAPTION = "Tables:";
    public static final int APP_LBL_TABLE_WIDTH = 150;
    public static final int APP_LBL_TABLE_HEIGHT = 25;
    public static final int APP_LBL_TABLE_X = 10;
    public static final int APP_LBL_TABLE_Y = 10;

    //PnlLeft
    public static final int APP_PNL_LEFT_WIDTH = 0;
    public static final int APP_PNL_LEFT_HEIGHT = 100;

    //buttons
    public static final String APP_BTN_SQL = "Execute SQL";
    public static final String APP_BTN_SQL_ACTION_COMMAND = "executesql";

    //Label
    public static final String APP_LBL_SQL_QUERY = "Enter your SQL Query:";

}/*Config*/
