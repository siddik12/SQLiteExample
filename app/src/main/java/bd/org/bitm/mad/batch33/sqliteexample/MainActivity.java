package bd.org.bitm.mad.batch33.sqliteexample;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName,editTextAge,editTextDept;
    private EmployeeDataSource employeeDataSource = new EmployeeDataSource(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        editTextDept = findViewById(R.id.editTextDept);
    }

    public void saveEmployee(View view) {
        String name = editTextName.getText().toString();
        int age = Integer.parseInt(editTextAge.getText().toString());
        String dept = editTextDept.getText().toString();

        Employee employee = new Employee(name,age,dept);

        boolean saved = employeeDataSource.saveEmployee(employee);

        if(saved){
            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "No Saved", Toast.LENGTH_SHORT).show();
        }
    }

    public void showEmployeeData(View view) {

        List<Employee> employeeList = employeeDataSource.getAllEmployee();

        for (Employee employee: employeeList){
            Log.d("EMPLOYEE ID",employee.getId()+"");
            Log.d("EMPLOYEE NAME",employee.getName());
            Log.d("EMPLOYEE AGE",employee.getAge()+"");
            Log.d("EMPLOYEE DEPT",employee.getDept());
        }

    }
}
