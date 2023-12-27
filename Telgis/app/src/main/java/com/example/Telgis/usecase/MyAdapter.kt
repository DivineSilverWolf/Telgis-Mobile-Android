package com.example.Telgis.usecase

import android.app.Activity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.Telgis.R
import com.example.Telgis.data.User

class MyAdapter(private val context : Activity, private val arrayList: ArrayList<User>) : ArrayAdapter<User>(context, R.layout.list_item, arrayList){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        Log.d("Adapter", "Created!")
        val inflater : LayoutInflater = LayoutInflater.from(context)
        val view : View = inflater.inflate((R.layout.list_item), null);
        val imageView : ImageView = view.findViewById(R.id.pfp)
        val username : TextView = view.findViewById(R.id.username)
        imageView.setImageResource(arrayList[position].imageId)
        username.text = arrayList[position].name
        return view
    }
}