package tk.shyamkumaryadav.backroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class loginActivity extends AppCompatActivity {
    TextInputLayout emailLayout, passwordLayout;
    TextInputEditText email, password;
    Button login;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.emailEditText);
        emailLayout = findViewById(R.id.emailLayout);
        password = findViewById(R.id.passwordEditText);
        passwordLayout = findViewById(R.id.passwordLayout);
        mAuth = FirebaseAuth.getInstance();
        login = findViewById(R.id.loginbtn);
    }

    public void signupView(View view) {
        Intent signup_activity = new Intent(loginActivity.this, SignupActivity.class);
        startActivity(signup_activity);
    }

    public void loginClick(View view) {
        Log.d("Button", "Login button click");
        if (email_valid()) {
            emailLayout.setError(null);
            passwordLayout.setError(null);
            Toast.makeText(getApplicationContext(), "Email Password is OK", Toast.LENGTH_LONG).show();
            mAuth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener(this, task -> {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Login!!!!", Toast.LENGTH_LONG).show();
                    Log.d("Button", "Login ok !!!");
                } else {
                    Toast.makeText(getApplicationContext(), "Authentication failed.",
                            Toast.LENGTH_SHORT).show();
                }
            });

        }else {
            Log.d("Button", "some thing is wrong!!!");
            passwordLayout.setError(null);
            password.setText(null);
            Toast.makeText(getApplicationContext(), "Email is Empty", Toast.LENGTH_LONG).show();
            emailLayout.setError("Email is invalid");
        }
    }

    public boolean email_valid(){
        return Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches();
    }
}