package com.example.uas_ppbl

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uas_ppbl.data.model.device.Device
import com.example.uas_ppbl.data.model.device.Phone
import com.example.uas_ppbl.data.util.Resource
import com.example.uas_ppbl.databinding.FragmentDeviceBinding
import com.example.uas_ppbl.presentation.MainActivity
import com.example.uas_ppbl.presentation.adapter.BrandsAdapter
import com.example.uas_ppbl.presentation.adapter.DeviceAdapter
import com.example.uas_ppbl.presentation.viewmodel.BrandViewModel
import javax.inject.Inject

class DeviceFragment : Fragment() {
    private lateinit var viewModel: BrandViewModel
    private lateinit var binding: FragmentDeviceBinding
    private lateinit var deviceAdapter: DeviceAdapter
    val args: DeviceFragmentArgs by navArgs()
    private var brandSlug = ""
    private var page =1 //
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_device, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDeviceBinding.bind(view)
        viewModel = (activity as MainActivity).viewModel
        viewModel.getListDevice(brandSlug, page)
//        deviceAdapter = (activity as MainActivity).deviceAdapter
        initRecycleView()
        viewDeviceList()
    }

    private fun initRecycleView() {
        deviceAdapter = DeviceAdapter()
        brandSlug = args.selectedBrand.brandSlug.toString()
        binding.rvDevice.apply {
            adapter = deviceAdapter
            layoutManager = GridLayoutManager(activity,2)
            deviceAdapter.setOnItemListener  {device->
                val bundle = Bundle().apply {
                    putSerializable("selected_hp", device)
                }
                findNavController().navigate(R.id.action_deviceFragment_to_spesifikasiFragment, bundle)
            }
        }
    }

    private fun showPBar() {
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun hidePBar() {
        binding.progressBar.visibility = View.GONE
    }

    private fun viewDeviceList() {
        viewModel.getListDevice(brandSlug, page)
        viewModel.getDevice.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Success -> {
                    hidePBar()
                    response.data?.let {
                        deviceAdapter.differ.submitList(it.device?.phones)
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
