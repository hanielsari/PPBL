package com.example.uas_ppbl.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.uas_ppbl.R
import com.example.uas_ppbl.databinding.ActivityMainBinding
import com.example.uas_ppbl.presentation.adapter.BrandsAdapter
import com.example.uas_ppbl.presentation.adapter.LatestAdapter
import com.example.uas_ppbl.presentation.adapter.SearchAdapter
import com.example.uas_ppbl.presentation.viewmodel.BrandViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
//    @Inject
//    lateinit var factory : BrandViewModelFactory

    @Inject
    lateinit var brandsAdapter: BrandsAdapter

    @Inject
    lateinit var latestAdapter: LatestAdapter

    @Inject
    lateinit var searchAdapter: SearchAdapter

    val viewModel : BrandViewModel by viewModels()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bnvBrand.setupWithNavController(navController)
//        viewmodel = ViewModelProvider(this,factory)[BrandViewModel::class.java]
    }
}
