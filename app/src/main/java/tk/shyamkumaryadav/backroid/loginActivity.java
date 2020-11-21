package tk.shyamkumaryadav.backroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class loginActivity extends AppCompatActivity {
    TextInputLayout emailLayout, passwordLayout;
    TextInputEditText email, password;
    Button login;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.emailEditText);
        emailLayout = findViewById(R.id.emailLayout);
        password = findViewById(R.id.passwordEditText);
        passwordLayout = findViewById(R.id.passwordLayout);

        login = findViewById(R.id.loginbtn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().toString().isEmpty()) {
                    passwordLayout.setError(null);
                    Toast.makeText(getApplicationContext(), "Email is Empty", Toast.LENGTH_LONG).show();
                    emailLayout.setError("Email is Empty");
                } else if (password.getText().toString().isEmpty()) {
                    emailLayout.setError(null);
                    Toast.makeText(getApplicationContext(), "Password is Empty", Toast.LENGTH_LONG).show();
                    passwordLayout.setError("Password is Empty");
                } else {
                    if (email.getText().toString().trim().matches(emailPattern)) {
                        emailLayout.setError(null);
                        passwordLayout.setError(null);
                        Toast.makeText(getApplicationContext(), "Email Password is OK", Toast.LENGTH_LONG).show();
                    } else {
                        emailLayout.setError("Email is invalid");
                        password.setText(null);
                        Toast.makeText(getApplicationContext(), "Email invalid is OK", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

    public void signupView(View view) {
        Intent signup_activity = new Intent(loginActivity.this, SignupActivity.class);
        startActivity(signup_activity);
    }
}