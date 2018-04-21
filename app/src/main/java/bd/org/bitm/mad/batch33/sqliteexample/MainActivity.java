package bd.org.bitm.mad.batch33.sqliteexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName,editTextAge,editTextDept;
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

        EmployeeDataSource employeeDataSource = new EmployeeDataSource();
        employeeDataSource.saveEmployee(employee);
    }
}
