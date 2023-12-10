package com.example.Telgis

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.Telgis.databinding.FragmentSignInBinding
import com.example.Telgis.usecase.SignInUseCase
import okhttp3.OkHttpClient

class SignInFragment : Fragment() {
    private val client : OkHttpClient = OkHttpClient()
    private val signinUseCase by lazy { SignInUseCase(client) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding = FragmentSignInBinding.inflate(inflater, container, false)
        binding.signinButton.setOnClickListener {
            if(binding.password.text.toString() == binding.confirmPassword.text.toString()){
                if(signinUseCase.execute(binding.loginText.text.toString(), binding.password.text.toString())){
                    Toast.makeText(context, "Sign in sucess!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "An error has occured!", Toast.LENGTH_SHORT).show()
                }
            }
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