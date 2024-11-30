package com.projectx.testrecycler.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.projectx.testrecycler.R
import com.projectx.testrecycler.adapter.CarAdapter
import com.projectx.testrecycler.databinding.FragmentMainBinding
import com.projectx.testrecycler.model.CarModel


class MainFragment : Fragment() {

    private val binding by lazy {
        FragmentMainBinding.inflate(layoutInflater)
    }
    private lateinit var adapter: CarAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
       var modelList = listOf(
           CarModel("https://5bmwhistory.wordpress.com/wp-content/uploads/2014/04/bmw-e-34.jpg","BMW",1991),
           CarModel("https://www.supersprint.com/public/img/1-551885.jpg","BMW",2002),
           CarModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQWO61Q-9krWmag7Q8O8d3HYAxJYdfxPb5qLQ&s","Mercedes",1995),
           CarModel("https://avatars.mds.yandex.net/get-verba/787013/2a000001609c156c7556fdeb440728f36350/cattouchret","SUBARU",2002),
           CarModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQazQ1PhIwgcVuXQGI7_Ytyzk41AUZHJ7beUw&s","KABAN",2002),
           CarModel("https://static1.topspeedimages.com/wordpress/wp-content/uploads/2023/01/mercedes-g-wagen.jpg","GELIK",2002),
           CarModel("https://cdn.dealeraccelerate.com/driver/1/384/14944/790x1024/1992-toyota-mark-ii-tourer-v","MARK 2",2002),
       )
       adapter = CarAdapter(modelList){cars->
        val action = MainFragmentDirections.actionMainFragmentToDetailFragment(
            image = cars.image.toString(),
            name = cars.name,
            year = cars.year

        )
           findNavController().navigate(action)
       }
        binding.rvCars.adapter = adapter
        binding.rvCars.layoutManager = LinearLayoutManager(requireContext())

    }


}