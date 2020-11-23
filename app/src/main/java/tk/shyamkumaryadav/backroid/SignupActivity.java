package tk.shyamkumaryadav.backroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class SignupActivity extends AppCompatActivity {

    private TextInputLayout emailLayout, password1Layout, password2Layout;
    private TextInputEditText email, password1, password2;
    public Button signupbtn;
    private FirebaseAuth mAuth;

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
        signupbtn = findViewById(R.id.signupbtn);
        mAuth = FirebaseAuth.getInstance();
    }

    public boolean email_valid(){
        return Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches();
    }

    public boolean password_valid(){
        return password1.getText().toString().equals(password2.getText().toString());
    }

    public void loginView(View view) {
        Intent login_Intent = new Intent(SignupActivity.this, loginActivity.class);
        startActivity(login_Intent);
    }

    public void signupClick(View view) {
        Log.d("Button", "is_email " + email_valid() + " is_password "+ password_valid());
        if(email.getText().toString().isEmpty() || password1.getText().toString().isEmpty() || password2.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), "Empty is email", Toast.LENGTH_LONG).show();
        }
        if(email_valid()){
            if(password_valid()) {
                Toast.makeText(getApplicationContext(), "Right", Toast.LENGTH_LONG).show();
                mAuth.createUserWithEmailAndPassword(email.getText().toString(), password2.getText().toString()).addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        FirebaseUser user = mAuth.getCurrentUser();
                        Toast.makeText(getApplicationContext(), "Done!!!!", Toast.LENGTH_LONG).show();
                        Log.d("Button", "ok Email " + email_valid() + " ok password "+ password_valid());
//                                updateUI(user);
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(getApplicationContext(), "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
//                                updateUI(null);
                    }
                });
            }
        }
    }
}