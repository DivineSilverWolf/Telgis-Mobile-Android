package com.example.Telgis.usecase

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.Telgis.R
import com.example.Telgis.data.User

class CustomAdaptor(val ctx : Context, val arrayList: ArrayList<User>) : BaseAdapter(){
    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(position: Int): User {
        return arrayList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var myConvertView = convertView
        Log.d("Adaptor", "Adaptor created!")
        if(myConvertView == null){
            Log.d("Adaptor", "View is empty!")
            myConvertView = LayoutInflater.from(ctx).inflate(R.layout.list_item, parent, false)
        }
        val curr = getItem(position)
        val imageItem = myConvertView?.findViewById<ImageView>(R.id.pfp)
        val username = myConvertView?.findViewById<TextView>(R.id.username)
        imageItem?.setImageResource(curr.imageId)
        username?.text = curr.name
        Log.d("Adaptor", "Killed by drones!")чё
        return myConvertView!!
    }

}