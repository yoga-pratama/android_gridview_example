package com.yoga.griviewlayoutexample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import com.yoga.griviewlayoutexample.R
import com.yoga.griviewlayoutexample.adapter.GridviewAdapter
import com.yoga.griviewlayoutexample.databinding.ActivityMainBinding
import com.yoga.griviewlayoutexample.model.GridModel

class MainActivity : AppCompatActivity() {

    private var mBinding: ActivityMainBinding? = null

    private lateinit var gridViewMenu: GridView
    private lateinit var menuList: List<GridModel>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding!!.root)

        initMockData()
        initAdapter()
    }

    private fun initMockData() {
        menuList = ArrayList<GridModel>()
        menuList =
            menuList + GridModel("Kapal", R.drawable.ic_anchor)

        menuList =
            menuList + GridModel("Pesawat", R.drawable.ic_plane)

        menuList =
            menuList + GridModel("Bus", R.drawable.ic_bus)


    }

    private fun initAdapter() {
        val menuAdapter = GridviewAdapter(menuList, this@MainActivity)

        /* gridViewMenu.adapter = menuAdapter*/
        mBinding!!.gvMenu.adapter = menuAdapter

        mBinding!!.gvMenu.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                Toast.makeText(
                    applicationContext, menuList[position].menuName + " selected",
                    Toast.LENGTH_SHORT
                ).show()
            }

    }


    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }
}