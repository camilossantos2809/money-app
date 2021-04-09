package io.money.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import io.money.R
import io.money.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    companion object {
        const val TAG = "FIRESTORE"
    }

    private val model: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(
            inflater,
            R.layout.fragment_home,
            container,
            false
        )

        val observer = Observer<List<String>> {
            binding.textView.text = it.toString()
        }
        binding.button.setOnClickListener { onClickButton() }
        model.stocks.observe(viewLifecycleOwner, observer)
        return binding.root
    }

    fun onClickButton() {
        model.loadStocks()
    }

}