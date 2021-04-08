package io.money

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "FIRESTORE"
    }

    private val model: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val text = findViewById<TextView>(R.id.textView)
        val button = findViewById<Button>(R.id.button)
        val observer = Observer<List<String>> {
            text.text = it.toString()
        }
        button.setOnClickListener { onClickButton() }
        model.stocks.observe(this, observer)
    }

    fun onClickButton() {
        model.loadStocks()
//        Toast.makeText(this, "Teste", Toast.LENGTH_LONG).show()
    }

}