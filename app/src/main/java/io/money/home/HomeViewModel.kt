package io.money.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import io.money.MainActivity

class HomeViewModel : ViewModel() {
    private val db = Firebase.firestore
    val stocks: MutableLiveData<List<String>> by lazy {
        MutableLiveData()
    }

    fun loadStocks() {
        db.collection("stocks").get().addOnSuccessListener { res ->
            stocks.value = res.documents.map { "${it.id} - ${it.data?.get("description")}" }
        }.addOnFailureListener { Log.w(HomeFragment.TAG, "Erro ao obter informações", it) }
    }
}