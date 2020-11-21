package tk.shyamkumaryadav.backroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button get_started;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        get_started = (Button)findViewById(R.id.button);
        get_started.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Welcome", Toast.LENGTH_LONG).show();
                Intent login_activity = new Intent(MainActivity.this, loginActivity.class);
                startActivity(login_activity);
            }
        });
    }
}