package tk.shyamkumaryadav.mob

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fireAuth = FirebaseAuth.getInstance()
        if (fireAuth.currentUser != null){
            updateUI("IS_LOGIN")
        }
    }

    fun btnGetLogin(view: View) {
        updateUI("LOGIN")
    }

    fun btnGetSignUp(view: View) {
        updateUI("SIGN_UP")
    }

    private fun updateUI(name:String){
        val intent = when(name){
            "LOGIN" -> Intent(this, LoginActivity::class.java)
            "SIGN_UP" -> Intent(this, SignUpActivity::class.java)
            "IS_LOGIN" -> Intent(this, MobActivity::class.java)
            else -> throw Exception("404 Error")
        }
        startActivity(intent)
        finish()
    }
}