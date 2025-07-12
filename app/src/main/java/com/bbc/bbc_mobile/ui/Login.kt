package com.bbc.bbc_mobile.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bbc.bbc_mobile.R
import com.bbc.bbc_mobile.data.Result
import com.bbc.bbc_mobile.databinding.ActivityLogin2Binding
import com.bbc.bbc_mobile.databinding.ActivityMainBinding

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLogin2Binding
    private val loginViewModel : ViewModel by viewModels {ViewModelFactory(applicationContext)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLogin2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        loginViewModel.login.observe(this){ result ->
            when (result) {
                is Result.Success-> {
                    loginViewModel.saveToken(result.data.accessToken.toString())
                    showLoading(false)
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                }
                is Result.Error -> {
                    showLoading(false)
                    Toast.makeText(this, "Email or Password Incorrect", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    showLoading(true)
                }
            }
        }

        binding.btnLogin.setOnClickListener{
            val email = binding.tietEmail.text.toString().trim()
            val password = binding.tietPassword.text.toString().trim()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                loginViewModel.loginUser(email, password)
            } else {
                Toast.makeText(this, "Email and Password is Required",Toast.LENGTH_SHORT).show()
            }
        }

        binding.tvToRegister.setOnClickListener{
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    private fun showLoading(loading: Boolean) {
        binding.progressBar.visibility = if (loading) View.VISIBLE else View.GONE
    }
}

