package tk.shyamkumaryadav.mob

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlin.math.log


class LoginActivity : AppCompatActivity() {

    lateinit var fireAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        fireAuth = FirebaseAuth.getInstance()
    }

    fun btnLogin(view: View) {
        textFieldEmail.error = null
        val email = tfEmail.text.toString()
        val password = tfPassword.text.toString()
        when {
            email.isEmpty() -> {
                textFieldEmail.error = "Required"
            }
            ! Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                textFieldEmail.error = "Not Valid Email !"
            }
            !(email.isEmpty() || password.isEmpty()) -> {
                fireAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this) {
                    if (it.isSuccessful){
                        val intent = Intent(this, MobActivity::class.java)
                        startActivity(intent)
                        finish()
                    }else{
                        Toast.makeText(this, "Pleas enter email and password vaild", Toast.LENGTH_LONG).show()
                    }
                }
            }else -> {
                Toast.makeText(this, "password required", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        var currentUser = fireAuth.currentUser

    }
}