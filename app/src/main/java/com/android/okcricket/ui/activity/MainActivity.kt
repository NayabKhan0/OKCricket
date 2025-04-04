package com.android.okcricket.ui.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.okcricket.R
import com.android.okcricket.network.ResultState
import com.android.okcricket.viewmodel.MatchViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MatchViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getFirstMatch()

        viewModel.firstMatchData.observe(this) { it ->
            when (it) {
                is ResultState.Loading -> {
                    Log.e("","")
                }
                is ResultState.Success -> {
                    Log.e("","")
                }
                is ResultState.Error -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}