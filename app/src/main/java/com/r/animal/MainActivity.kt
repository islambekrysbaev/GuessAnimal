package com.r.animal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.r.animal.databinding.ActivityMainBinding
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) .also { setContentView(it.root) }

        binding.loadBtn.setOnClickListener {

            val site = "https://source.unsplash.com/random/300×300?"
            val category = "animal"

            val encodedKeyword = URLEncoder.encode(category, StandardCharsets.UTF_8.name())
            val url = "$site/$encodedKeyword"

            Glide.with(this)
                .load(url)
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                .into(binding.animalIV)
        }
    }
}