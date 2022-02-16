package com.example.randompicturebyglide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.randompicturebyglide.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var url:String = "https://picsum.photos/200"
    lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this , R.layout.activity_main)
        imageView = findViewById<ImageView>(R.id.ivPic2)
        Glide.with(this).load(url).into(imageView)
    }
}