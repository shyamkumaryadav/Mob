package tk.shyamkumaryadav.mob

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*



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

    fun tvForgetPassword(view: View) {
        val emailLayout = TextInputLayout(this)
        emailLayout.hint = "Email"
        val emailInput = TextInputEditText(this)
        emailLayout.addView(emailInput)

        MaterialAlertDialogBuilder(this)
            .setTitle("Forget Password")
            .setMessage("New To Android ?")
            .setView(emailLayout)
            .setNeutralButton("Cancel"){ dialogInterface: DialogInterface, i: Int ->
                Toast.makeText(this, "Set Neutral Button", Toast.LENGTH_LONG).show()
            }
            .setPositiveButton("Send Email"){ dialogInterface: DialogInterface, i: Int ->
                Toast.makeText(this, "Email send to This Acccount", Toast.LENGTH_LONG).show()
            }
            .show()
    }
}