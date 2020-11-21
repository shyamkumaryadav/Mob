package tk.shyamkumaryadav.backroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    public void loginView(View view) {
        Intent login_Intent = new Intent(SignupActivity.this, loginActivity.class);
        startActivity(login_Intent);
    }
}