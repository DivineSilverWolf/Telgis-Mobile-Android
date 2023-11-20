package com.example.Telgis

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.Telgis.databinding.FragmentLogInBinding
import com.example.Telgis.R


class LogInFragment : Fragment() {

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
        // Inflate the layout for this fragment
        return binding.root
    }
}