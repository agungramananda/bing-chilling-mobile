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
import com.bbc.bbc_mobile.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private val registerViewModel : ViewModel by viewModels {ViewModelFactory(applicationContext)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registerViewModel.register.observe(this){ result ->
            when (result) {
                is Result.Success-> {
                    showLoading(false)
                    val intent = Intent(this, Login::class.java)
                    startActivity(intent)
                }
                is Result.Error -> {
                    showLoading(false)
                    Toast.makeText(this, result.error, Toast.LENGTH_SHORT).show()
                }
                else -> {
                    showLoading(true)
                }
            }
        }

        binding.btnRegister.setOnClickListener{
            val name = binding.tietUsername.text.toString().trim()
            val email = binding.tietEmail.text.toString().trim()
            val password = binding.tietPassword.text.toString().trim()

            if (email.isNotEmpty() && password.isNotEmpty() && name.isNotEmpty()) {
                registerViewModel.registerUser(name, email, password)
            } else {
                Toast.makeText(this, "Username, Email and Password is Required", Toast.LENGTH_SHORT).show()
            }
        }

        binding.tvToLogin.setOnClickListener{
            startActivity(Intent(this, Login::class.java))
        }
    }

    private fun showLoading(loading: Boolean) {
        binding.progressBar.visibility = if (loading) View.VISIBLE else View.GONE
    }
}