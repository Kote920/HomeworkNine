package com.example.homeworknine

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homeworknine.databinding.ItemRecyclerviewBinding

class ItemsRecyclerAdapter(private val items: MutableList<List<Item>>): RecyclerView.Adapter<ItemsRecyclerAdapter.ItemsViewHolder>() {


    private var filteredItems: MutableList<List<Item>> = items


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        return ItemsViewHolder(
            ItemRecyclerviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        val currentItem = filteredItems[position]
        holder.bind()
    }
    fun filterItemsByCategory(category: String) {
        filteredItems = items.filter { it.isNotEmpty() && it[0].categoryType == category }.toMutableList()
        notifyDataSetChanged()
        notifyDataSetChanged() // Notify RecyclerView that the dataset has changed
    }




    inner class ItemsViewHolder(val binding: ItemRecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(){
            val itemList = filteredItems[adapterPosition]
            with(binding) {
                ivProductLeft.setImageResource(itemList[0].image)
                tvDescription.text = itemList[0].title
                tvPrice.text = itemList[0].price.toString()

                ivProductRight.setImageResource(itemList[1].image)
                tvDescriptionRight.text = itemList[1].title
                tvPriceRight.text = itemList[1].price.toString()



            }
        }

    }

}
