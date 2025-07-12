package com.bbc.bbc_mobile.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bbc.bbc_mobile.R
import com.bbc.bbc_mobile.data.Result
import com.bbc.bbc_mobile.data.model.Product
import com.bbc.bbc_mobile.data.remote.response.IceCreamResponse
import com.bbc.bbc_mobile.databinding.ActivityHomeBinding
import com.bbc.bbc_mobile.databinding.ActivityRegisterBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val viewModel : ViewModel by viewModels {ViewModelFactory(applicationContext)}
    private val topAdapter: Adapter by lazy { Adapter(Adapter.Type.VERTICAL) {iceCreamData ->
        navigateToDetail(iceCreamData)
    } }
    private val newArrivalsAdapter: Adapter by lazy { Adapter(Adapter.Type.HORIZONTAL) {iceCreamData ->
        navigateToDetail(iceCreamData)
    }}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()

        viewModel.getIceCreams().observe(this) { result ->
            when(result) {
                is Result.Loading -> showLoading(true)
                is Result.Error -> {
                    showLoading(false)
                    Toast.makeText(this, result.error, Toast.LENGTH_LONG).show()
                }
                is Result.Success -> {
                    showLoading(false)
                    val data = result.data
                    val topList = data.take(5)
                    val newArrivalsList = data.drop(5).take(5)
                    topAdapter.submitList(topList)
                    newArrivalsAdapter.submitList(newArrivalsList)
                }
            }
        }

        binding.ivProfile.setOnClickListener{
            startActivity(Intent(this,AboutUsActivity::class.java))
        }
    }

    private fun setupRecyclerView() {
        binding.rvTop.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = topAdapter
        }

        binding.rvNewArrivals.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = newArrivalsAdapter
        }
    }

    private fun showLoading(loading: Boolean) {
        binding.progressBar.visibility = if (loading) View.VISIBLE else View.GONE
    }

    private fun navigateToDetail(product: IceCreamResponse) {
        val intent = Intent(this, DetailActivity::class.java).apply {
            val parcelableProduct = Product(
                id = product.id!!,
                name = product.name!!,
                price = product.price!!,
                imageUrl = product.images!!,
                description = product.description!!,
            )
            putExtra("EXTRA_PRODUCT", parcelableProduct)
        }
        startActivity(intent)
    }
}