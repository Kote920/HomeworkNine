package com.example.homeworknine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homeworknine.databinding.ActivityMainBinding
import com.example.homeworknine.databinding.ItemRecyclerviewBinding

class MainActivity : AppCompatActivity() {

    private val items = mutableListOf<List<Item>>()
    private lateinit var binding: ActivityMainBinding
    private lateinit var bindingItem: ItemRecyclerviewBinding
    private lateinit var adapter: ItemsRecyclerAdapter
//    val drawableGray = ContextCompat.getDrawable(this, R.drawable.gray_bg)
//    val drawableGreen= ContextCompat.getDrawable(this, R.drawable.green_bg)
//

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setProducts()
        setUpEquipmentRecycler()
        setUpButtons()



    }


    private fun setProducts(){
        items.also {
            val listOne = listOf<Item>(Item(R.drawable.girl2, "Woman full body", 99.3, "Party"),
            Item(R.drawable.girl3, "Woman Dark Red", 129.3, "Party"))
            it.add(listOne)
            val listTwo = listOf<Item>(Item(R.drawable.camping, "Camping outfit", 939.3, "Camping"),
               Item(R.drawable.rectanglebg,"", 0.00, "Camping"))
            it.add(listTwo)
            val listThree = listOf<Item>(Item(R.drawable.tyler, "Tyler Durden Outfit", 339.99, "FightClub"),
                    Item(R.drawable.ed, "Edward Norton Outfit", 291.3, "FightClub"))
            it.add(listThree)
            val listFour = listOf<Item>(Item(R.drawable.ryannoteobok, "Ryan Gosling Notebook outfit", 119.00, "RyanGosling"),
                     Item(R.drawable.drive, "I drive", 133.49, "RyanGosling"))
            it.add(listFour)
            val listFive = listOf<Item>( Item(R.drawable.ryan, "You look lonely", 1332.49, "BladeRunner"),
                Item(R.drawable.rectanglebg,"", 0.00, "BladeRunner"))
            it.add(listFive)


        }
    }

    private fun setUpEquipmentRecycler() {
        adapter = ItemsRecyclerAdapter(items)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

    }


    private fun setBackgrounds(){
        binding.btnAll.setBackgroundResource(R.drawable.gray_bg)
        binding.btnCamping.setBackgroundResource(R.drawable.gray_bg)
        binding.btnBladeRunner.setBackgroundResource(R.drawable.gray_bg)
        binding.btnParty.setBackgroundResource(R.drawable.gray_bg)
        binding.btnFightClub.setBackgroundResource(R.drawable.gray_bg)
        binding.btnRyanGosling.setBackgroundResource(R.drawable.gray_bg)




    }
    private fun setUpButtons(){
        binding.btnAll.setOnClickListener {
            setBackgrounds()
            it.setBackgroundResource(R.drawable.green_bg)
        }
        binding.btnCamping.setOnClickListener {
            setBackgrounds()
            it.setBackgroundResource(R.drawable.green_bg)
            adapter.filterItemsByCategory("Camping")

        }
        binding.btnParty.setOnClickListener{
            setBackgrounds()
            it.setBackgroundResource(R.drawable.green_bg)
            adapter.filterItemsByCategory("Party")
        }
        binding.btnRyanGosling.setOnClickListener {
            setBackgrounds()
            it.setBackgroundResource(R.drawable.green_bg)
            adapter.filterItemsByCategory("RyanGosling")
        }
        binding.btnFightClub.setOnClickListener {
            setBackgrounds()
            it.setBackgroundResource(R.drawable.green_bg)
            adapter.filterItemsByCategory("FightClub")
        }
        binding.btnBladeRunner.setOnClickListener {
            setBackgrounds()
            it.setBackgroundResource(R.drawable.green_bg)
            adapter.filterItemsByCategory("BladeRunner")
        }

    }
}

//enum class Categories{
//    ALL,
//    PARTY,
//    CAMPING,
//    RYAN_GOSLING,
//    FIGHT_CLUB,
//    BLADE_RUNNER
//
//}