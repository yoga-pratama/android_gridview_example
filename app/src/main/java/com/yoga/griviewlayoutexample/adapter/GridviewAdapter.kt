package com.yoga.griviewlayoutexample.adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.yoga.griviewlayoutexample.R
import com.yoga.griviewlayoutexample.databinding.GridviewItemBinding
import com.yoga.griviewlayoutexample.model.GridModel

class GridviewAdapter(
    private val menuList: List<GridModel>,
    private val activity: Activity
) : BaseAdapter() {

    private var layoutInflater: LayoutInflater? = null

    override fun getCount(): Int {
        return menuList.size
    }

    override fun getItem(position: Int): Any {
        return menuList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {

        val mBinding: GridviewItemBinding =
            GridviewItemBinding.inflate(LayoutInflater.from(activity), viewGroup, false)


        mBinding.ivMenu.setImageResource(menuList[position].menuImg)
        mBinding.tvMenu.text = menuList[position].menuName

        return mBinding.root

    }


}