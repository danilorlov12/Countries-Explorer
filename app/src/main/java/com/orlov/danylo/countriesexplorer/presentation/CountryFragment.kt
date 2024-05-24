package com.orlov.danylo.countriesexplorer.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.orlov.danylo.core.sl.ViewModelsFactory
import com.orlov.danylo.countriesexplorer.R
import com.orlov.danylo.countriesexplorer.sl.CountriesCoreModule

class CountryFragment : Fragment(R.layout.fragment_country_preview) {

    private var viewModel: CountryViewModel? = null

    @Suppress("ReplaceGetOrSet")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val module = (requireActivity().application as CountriesCoreModule)
            .provideCountiesDependencyContainer()
        viewModel = ViewModelProvider(requireActivity(), ViewModelsFactory(module))
            .get(CountryViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val adapter = CountriesAdapter()
        recyclerView.adapter = adapter

        viewModel?.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }
}
