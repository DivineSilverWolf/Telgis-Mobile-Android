package com.example.Telgis.usecase

import android.util.Log
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import java.io.IOException


class LogInUseCase(val client : OkHttpClient) {
    private var status = 200
    fun execute(login : String, password : String) : Boolean{
        try{
            val jsonBody = JSONObject()
            jsonBody.put("password", password)

            val mediaType = "application/json; charset=utf-8".toMediaType()
            val requestBody = jsonBody.toString().toRequestBody(mediaType)

            val request = Request.Builder()
                .url("http://85.193.80.248:8000/auth/$login") // TODO: ask about urls
                .post(requestBody)
                .build()

            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    Log.e("AAAA", "Error occured!")
                }

                override fun onResponse(call: Call, response: Response) {
                    status = response.code
                }
            })
            return status == 200
        } catch (e: IOException) {
            e.printStackTrace()
            return false
        }
    }
}