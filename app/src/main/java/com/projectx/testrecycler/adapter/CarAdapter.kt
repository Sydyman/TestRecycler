package com.projectx.testrecycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.projectx.testrecycler.databinding.ItemCarsBinding
import com.projectx.testrecycler.model.CarModel

class CarAdapter(
    private val modelList: List<CarModel>,
    private val onItemClick:(CarModel) -> Unit):RecyclerView.Adapter<CarAdapter.CarViewHolder>() {

        inner class CarViewHolder(private val binding: ItemCarsBinding):RecyclerView.ViewHolder(binding.root){
            fun onBind(carModel: CarModel){
                Glide.with(binding.imCar.context)
                    .load(carModel.image)
                    .into(binding.imCar)

                binding.tvModel.text = carModel.name
                binding.tvYear.text = carModel.year.toString()
                binding.root.setOnClickListener {
                    onItemClick(carModel)
                }

            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val binding = ItemCarsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CarViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return modelList.size
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        holder.onBind(modelList[position])
    }
}