package com.bbc.bbc_mobile.ui

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bbc.bbc_mobile.data.model.Product
import com.bbc.bbc_mobile.databinding.ActivityDetailBinding
import com.bumptech.glide.Glide
import java.text.NumberFormat
import java.util.Locale

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val product = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("EXTRA_PRODUCT", Product::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Product>("EXTRA_PRODUCT")
        }

        product?.let {
            populateUi(it)
        }
    }

    private fun populateUi(product: Product) {
        val localeEN = Locale("en", "US")
        val numberFormat = NumberFormat.getCurrencyInstance(localeEN)
        numberFormat.minimumFractionDigits = 0

        binding.apply {
            tvProductNameDetail.text = product.name
            tvPriceTag.text = numberFormat.format(product.price)
            tvDescription.text = product.description

            Glide.with(this@DetailActivity)
                .load(product.imageUrl)
                .into(ivProductImageDetail)
        }
    }
}