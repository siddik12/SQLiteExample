package bd.org.bitm.mad.batch33.sqliteexample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class EmployeeDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "employeeDB";
    private static final int DATABASE_VERSION = 1;

    public static final String EMPLOYEE_TABLE_NAME = "tbl_employee";
    public static final String EMPLOYEE_COL_ID = "_id";
    public static final String EMPLOYEE_COL_NAME = "name";
    public static final String EMPLOYEE_COL_AGE = "age";
    public static final String EMPLOYEE_COL_DEPT = "dept";
    public static final String [] EMPLOYEE_COLUMNS = {EMPLOYEE_COL_NAME,EMPLOYEE_COL_AGE,EMPLOYEE_COL_DEPT};

    private static final String CREATE_TABLE_EMPLOYEE = "CREATE TABLE "+ EMPLOYEE_TABLE_NAME + "(" +
            EMPLOYEE_COL_ID + " INTEGER PRIMARY KEY, " +
            EMPLOYEE_COL_NAME + " TEXT, " +
            EMPLOYEE_COL_AGE + " INTEGER, " +
            EMPLOYEE_COL_DEPT + " TEXT )";


    EmployeeDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_EMPLOYEE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       /* db.execSQL("DROP TABLE IF EXISTS " + EMPLOYEE_TABLE_NAME );
        onCreate(db);*/
    }
}
