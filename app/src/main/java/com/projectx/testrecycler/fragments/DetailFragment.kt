package com.projectx.testrecycler.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.projectx.testrecycler.R
import com.projectx.testrecycler.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {

    private val binding by lazy {
        FragmentDetailBinding.inflate(layoutInflater)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getViews()
    }

    private fun getViews() {
        val args = DetailFragmentArgs.fromBundle(requireArguments())
        Glide.with(requireContext())
            .load(args.image)
            .into(binding.carImage)
        binding.carName.text = args.name
        binding.carYear.text = args.year.toString()
    }


}