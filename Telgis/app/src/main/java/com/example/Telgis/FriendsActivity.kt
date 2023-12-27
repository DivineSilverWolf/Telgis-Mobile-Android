package com.example.Telgis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.Telgis.data.User
import com.example.Telgis.databinding.ActivityFriendsBinding
import com.example.Telgis.usecase.CustomAdaptor
import com.example.Telgis.usecase.MyAdapter

class FriendsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFriendsBinding
    private lateinit var userArrayList: ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFriendsBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_friends)
        val imageId = intArrayOf(
            R.drawable.moog, R.drawable.mio, R.drawable.azusa, R.drawable.yui, R.drawable.ritsu
        )
        val phones = arrayOf(
            "888888", "7777777", "6666666", "55555555", "444444444"
        )
        val names = arrayOf(
            "Mugi", "Mio", "Azusa", "Yui", "Ritsu"
        )
        userArrayList = ArrayList()
        userArrayList.add(User("Mugi", "89312321", R.drawable.moog))
//        for(i in names.indices){
//            val user = User(names[i], phones[i], imageId[i])
//            userArrayList.add(user)
//        }
        Log.d("Friends", "List created!")
        Log.d("Friends", "Size: " + userArrayList.size)
        binding.friendList.isClickable = true
        binding.friendList.adapter = CustomAdaptor(this, userArrayList)

    }
}