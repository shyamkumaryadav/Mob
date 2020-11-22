package tk.shyamkumaryadav.backroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SignupActivity extends AppCompatActivity {

    private TextInputLayout emailLayout, password1Layout, password2Layout;
    private TextInputEditText email, password1, password2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        email = findViewById(R.id.emailEditText);
        password1 = findViewById(R.id.password1EditText);
        password2 = findViewById(R.id.password2EditText);
        emailLayout = findViewById(R.id.emailLayout);
        password1Layout = findViewById(R.id.password1Layout);
        password2Layout = findViewById(R.id.password2Layout);
    }

    public void loginView(View view) {
        Intent login_Intent = new Intent(SignupActivity.this, loginActivity.class);
        startActivity(login_Intent);
    }
}