package com.example.uas_ppbl

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uas_ppbl.data.util.Resource
import com.example.uas_ppbl.databinding.FragmentSearchBinding
import com.example.uas_ppbl.presentation.MainActivity
import com.example.uas_ppbl.presentation.adapter.SearchAdapter
import com.example.uas_ppbl.presentation.viewmodel.BrandViewModel
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SearchFragment : Fragment() {
    private lateinit var viewModel: BrandViewModel
    private lateinit var binding: FragmentSearchBinding
    private lateinit var searchAdapter: SearchAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSearchBinding.bind(view)
        viewModel = (activity as MainActivity).viewModel
        searchAdapter = (activity as MainActivity).searchAdapter
        initRecycleView()
        setSearchView()
    }

    private fun initRecycleView() {
        binding.rvSearch.apply {
            adapter = searchAdapter
            layoutManager = GridLayoutManager(activity,2)
        }
    }


    private fun showPBar() {
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun hidePBar() {
        binding.progressBar.visibility = View.GONE
    }

    //search
    private fun setSearchView() {
        binding.searchDevice.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                //ketika di ketik pada bagian search kemudian di klik searchnya
                viewModel.getSearchDevice(query.toString())
                viewDeviceList()
                return false;
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                MainScope().launch {
                    delay(10000)
                    viewModel.getSearchDevice(p0.toString())
                    viewDeviceList()

                }
                return false
            }

        })
    }

    private fun viewDeviceList() {
        viewModel.getSearch.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Success -> {
                    hidePBar()
                    response.data?.let {
                        searchAdapter.differ.submitList(it.data?.phones?.toList())
                        Log.d("TAG", it.data?.phones.toString())
                    }
                }
                is Resource.Error -> {
                    hidePBar()
                    response.message?.let {
                        Toast.makeText(activity, it, Toast.LENGTH_LONG).show()
                    }
                }
                is Resource.Loading -> {
                    showPBar()

                }
            }

        }
    }
}