package com.example.uas_ppbl

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.uas_ppbl.data.util.Resource
import com.example.uas_ppbl.databinding.FragmentLastestBinding
import com.example.uas_ppbl.presentation.MainActivity
import com.example.uas_ppbl.presentation.adapter.LatestAdapter
import com.example.uas_ppbl.presentation.viewmodel.BrandViewModel

class LatestFragment : Fragment() {
    private lateinit var viewModel: BrandViewModel
    private lateinit var binding: FragmentLastestBinding
    private lateinit var latestAdapter: LatestAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lastest, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLastestBinding.bind(view)
        viewModel = (activity as MainActivity).viewModel
        latestAdapter = (activity as MainActivity).latestAdapter
        initRecycleView()
        viewDeviceList()
    }

    private fun initRecycleView() {
        binding.rvLatest.apply {
            adapter = latestAdapter
            layoutManager = GridLayoutManager(activity,2)
//            if(brands.brandSlug == device.title ){
//                return viewDeviceList()
//            }
        }
    }

    private fun showPBar() {
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun hidePBar() {
        binding.progressBar.visibility = View.GONE
    }

    private fun viewDeviceList() {
        viewModel.getLatestsDevice()
        viewModel.getLatest.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Success -> {
                    hidePBar()
                    response.data?.let {
                        latestAdapter.differ.submitList(it.data?.phoneLasts?.toList())
//                        Log.d("TAG",it.device?.phones.toString())
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
