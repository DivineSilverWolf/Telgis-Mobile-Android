package com.example.Telgis

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.Telgis.databinding.FragmentLogInBinding
import com.example.Telgis.usecase.LogInUseCase
import okhttp3.OkHttpClient


class LogInFragment : Fragment() {
    private val client : OkHttpClient = OkHttpClient()
    private val loginUseCase : LogInUseCase by lazy{LogInUseCase(client)}
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding = FragmentLogInBinding.inflate(inflater, container, false)
        binding.signinButton.setOnClickListener {
            var fm = parentFragmentManager
            var ft = fm.beginTransaction()
            val sf = SignInFragment()
            ft.replace(R.id.fragmentContainerView, sf).addToBackStack(null).commit()
        }
        binding.loginButton.setOnClickListener{
            if(loginUseCase.execute(binding.username.text.toString(), binding.password.text.toString())){
                Toast.makeText(context, "Log in sucess!", Toast.LENGTH_SHORT).show()
                val intent = Intent(activity, FriendsActivity::class.java)
                startActivity(intent)
            } else{
                Toast.makeText(context, "Wrong username or password!", Toast.LENGTH_SHORT).show()
            }
        }
        // Inflate the layout for this fragment
        return binding.root
    }
}