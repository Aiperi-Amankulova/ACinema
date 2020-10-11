package com.example.acinema.ui.main

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import com.example.acinema.R
import com.example.acinema.data.model.CinemaSearchModel
import com.example.acinema.data.remote.RetrofitBuilder
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : BaseActivity() {
    private val adapter = RecyclerViewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RetrofitBuilder.getService()
        recyclerView.adapter = adapter
        search.doAfterTextChanged {
            if (!it.isNullOrEmpty() && it.toString().length > 2)
                getSearch(it.toString())
        }
    }

    private fun getSearch(text: String) {
        RetrofitBuilder.getService()?.getCinema("a2bc6505",text)

            ?.enqueue(object : Callback<CinemaSearchModel>{
                override fun onResponse(
                    call: Call<CinemaSearchModel>,
                    response: Response<CinemaSearchModel>
                ) {
                    if (response.isSuccessful && response.body() != null){
                        val arrays = response.body()?.search?.map { it.title }?.toTypedArray()
                        if (response.isSuccessful && response.body() != null){
                            adapter.submitList(response.body()?.search)
                        }
                    }
                }
                override fun onFailure(call: Call<CinemaSearchModel>, t: Throwable) {
                    Toast.makeText(applicationContext, t.localizedMessage , Toast.LENGTH_LONG).show()
                }
            })
    } }