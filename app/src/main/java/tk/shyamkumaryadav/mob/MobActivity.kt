package tk.shyamkumaryadav.mob

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_mob.*

class MobActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mob)
        val fireAuth = FirebaseAuth.getInstance()
        textUserEmail.text = fireAuth.currentUser?.email ?: "NO User Email"
    }

    fun btnLogout(view: View) {
        // logout and redirect to LoginActivity
        FirebaseAuth.getInstance().signOut()
        var intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}