package com.example.movieapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.movieapp.databinding.FragmentComingSoonBinding
import com.example.movieapp.databinding.FragmentProfileBinding

class ComingSoonFragment:Fragment(R.layout.fragment_coming_soon) {

    lateinit var binding: FragmentComingSoonBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentComingSoonBinding.bind(view)

        binding.btn11.setOnClickListener {
            movieShare(binding.tvTitle11.text,binding.tvDec12.text )
        }
        binding.btn21.setOnClickListener {
            movieShare(binding.tvTitle21.text,binding.tvDec21.text )
        }
        binding.btn31.setOnClickListener {
            movieShare(binding.tvTitle31.text,binding.tvDec31.text )
        }

    }
    fun movieShare(title :CharSequence , Desc:CharSequence) {
        var intent = Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_SUBJECT, title)
        intent.putExtra(Intent.EXTRA_TEXT, Desc)
        intent.type = "text/plain"
        if (intent.resolveActivity(requireActivity().packageManager) != null) {
            startActivity(intent)
        }
    }
}
