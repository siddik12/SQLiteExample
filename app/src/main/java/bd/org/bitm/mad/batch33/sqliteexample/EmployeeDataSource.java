package bd.org.bitm.mad.batch33.sqliteexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDataSource {

    private EmployeeDatabaseHelper employeeDatabaseHelper;
    private SQLiteDatabase db;

    EmployeeDataSource(Context context) {
        employeeDatabaseHelper = new EmployeeDatabaseHelper(context);
    }

    private void openConnection(){
        db = employeeDatabaseHelper.getWritableDatabase();
    }

    private void closeConnection(){
        db.close();
    }

    public boolean saveEmployee(Employee employee){
        openConnection();

        ContentValues contentValues = new ContentValues();
        contentValues.put(EmployeeDatabaseHelper.EMPLOYEE_COL_NAME,employee.getName());
        contentValues.put(EmployeeDatabaseHelper.EMPLOYEE_COL_AGE,employee.getAge());
        contentValues.put(EmployeeDatabaseHelper.EMPLOYEE_COL_DEPT,employee.getDept());

       long id = db.insert(EmployeeDatabaseHelper.EMPLOYEE_TABLE_NAME,null,contentValues);

        closeConnection();

        return id > 0;
    }

    public List<Employee> getAllEmployee(){

        List<Employee> employeeList = new ArrayList<>();

        openConnection();
        Cursor cursor  = db.query(EmployeeDatabaseHelper.EMPLOYEE_TABLE_NAME,null,null,null,null,null,null);

        //Check cursor
        if(cursor != null && cursor.getCount() > 0){
            cursor.moveToFirst();
            do{
                int id = cursor.getInt(cursor.getColumnIndex(EmployeeDatabaseHelper.EMPLOYEE_COL_ID));
                String name = cursor.getString(cursor.getColumnIndex(EmployeeDatabaseHelper.EMPLOYEE_COL_NAME));
                int age = cursor.getInt(cursor.getColumnIndex(EmployeeDatabaseHelper.EMPLOYEE_COL_AGE));
                String dept = cursor.getString(cursor.getColumnIndex(EmployeeDatabaseHelper.EMPLOYEE_COL_DEPT));

                Employee employee  = new Employee(id, name,age,dept);

                employeeList.add(employee);

            }while (cursor.moveToNext());
        }

        closeConnection();

        return employeeList;

    }


}
