package com.example.Telgis

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.Telgis.databinding.FragmentSignInBinding
class SignInFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding = FragmentSignInBinding.inflate(inflater, container, false)
        binding.signinButton.setOnClickListener {
            Log.i("Fragment", binding.password.text.toString())
            Log.i("Fragment", binding.password.text.toString())
        }
        binding.loginButton.setOnClickListener {
            var fm = parentFragmentManager
            var ft = fm.beginTransaction()
            val lf = LogInFragment()
            ft.replace(R.id.fragmentContainerView, lf).addToBackStack(null).commit()
        }
        return binding.root
    }
}