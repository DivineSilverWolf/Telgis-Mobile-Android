package com.example.Telgis.usecase

import android.util.Log
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import java.io.IOException

class SignInUseCase(val client: OkHttpClient) {
    private var code = 200
    fun execute(login : String, password: String) : Boolean{
        try{
            val jsonBody = JSONObject()
            jsonBody.put("login", login)
            jsonBody.put("password", password)
            val mediaType = "application/json; charset=utf-8".toMediaType()
            val requestBody = jsonBody.toString().toRequestBody(mediaType)

            val request = Request.Builder()
                .url("http://85.193.80.248:8000/registration") // TODO: ask about urls
                .post(requestBody)
                .build()

            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    Log.e("AAAA", "Error occured!")
                    code = 404
                }

                override fun onResponse(call: Call, response: Response) {
                    code = response.code
                    Log.d("SOSI", code.toString())
                }
            })

            return code == 200
        } catch (e: IOException) {
            e.printStackTrace()
            return false
        }
    }
}