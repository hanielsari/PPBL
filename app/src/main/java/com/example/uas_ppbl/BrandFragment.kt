package com.example.uas_ppbl

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uas_ppbl.databinding.FragmentBrandBinding
import com.example.uas_ppbl.presentation.MainActivity
import com.example.uas_ppbl.presentation.adapter.BrandsAdapter
import com.example.uas_ppbl.presentation.viewmodel.BrandViewModel
import com.example.uas_ppbl.data.util.Resource

class BrandFragment : Fragment() {
    private lateinit var viewModel: BrandViewModel
    private lateinit var binding: FragmentBrandBinding
    private lateinit var brandAdapter: BrandsAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_brand, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBrandBinding.bind(view)
        viewModel = (activity as MainActivity).viewModel
        brandAdapter = (activity as MainActivity).brandsAdapter
        brandAdapter.setOnItemListener  {brand->
            val bundle = Bundle().apply {
                putSerializable("selected_brand", brand)
            }
            findNavController().navigate(R.id.action_brandFragment_to_deviceFragment, bundle)
        }
        initRecycleView()
        viewNewsList()
    }

    private fun initRecycleView() {
        binding.rvBrand.apply {
            adapter = brandAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    private fun showPBar(){
        binding.progressBar.visibility = View.VISIBLE
    }
    private fun hidePBar(){
        binding.progressBar.visibility = View.GONE
    }

    private fun viewNewsList() {
        viewModel.getListBrand()
        viewModel.getBrand.observe(viewLifecycleOwner){response->
            when(response){
                is Resource.Success->{
                    hidePBar()
                    response.data?.let {
                        brandAdapter.differ.submitList(it.data?.toList())
                    }
                }
                is Resource.Error->{
                    hidePBar()
                    response.message?.let{
                        Toast.makeText(activity,it,Toast.LENGTH_LONG).show()
                    }
                }
                is Resource.Loading->{
                    showPBar()

                }
            }

        }
    }


}