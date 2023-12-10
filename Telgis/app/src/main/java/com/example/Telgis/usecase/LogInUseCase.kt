package com.example.Telgis.usecase

import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import java.io.IOException

class LogInUseCase(val client : OkHttpClient) {
    fun execute(login : String, password : String) : Boolean{
        try{
            val jsonBody = JSONObject()
            jsonBody.put("login", login)
            jsonBody.put("password", password)

            val mediaType = "application/json; charset=utf-8".toMediaType()
            val requestBody = jsonBody.toString().toRequestBody(mediaType)

            val request = Request.Builder()
                .url("your_url") // TODO: ask about urls
                .post(requestBody)
                .build()

            val response = client.newCall(request).execute()

            val returnCode = response.code
            return returnCode == 200
        } catch (e: IOException) {
            e.printStackTrace()
            return false
        }
    }
}