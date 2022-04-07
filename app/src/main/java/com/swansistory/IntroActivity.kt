package com.swansistory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        val skipSignInButton = findViewById<Button>(R.id.btn_skip_sign_in)

        skipSignInButton.setOnClickListener{
            val intent = Intent(this@IntroActivity, MainActivity::class.java)
            startActivity(intent)
        }

        // TODO (click event for Sign Up btn and launch the Sign Up Screen.)
        // START
        val btn_sign_up_intro = findViewById<Button>(R.id.btn_sign_up_intro)
        btn_sign_up_intro.setOnClickListener {

            // Launch the sign up screen.
            startActivity(Intent(this@IntroActivity, SignUpActivity::class.java))
        }

    }
}