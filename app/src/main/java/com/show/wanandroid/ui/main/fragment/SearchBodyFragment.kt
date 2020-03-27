package com.show.wanandroid.ui.main.fragment

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.interpolator.view.animation.FastOutLinearInInterpolator
import androidx.lifecycle.Observer
import com.google.android.material.chip.Chip
import com.google.android.material.transition.MaterialSharedAxis
import com.show.wanandroid.R
import com.show.wanandroid.databinding.FragmentSearchBodyBinding
import com.show.wanandroid.entity.KeyWord
import com.show.wanandroid.ui.main.vm.MainViewModel
import kotlinx.android.synthetic.main.fragment_search_body.*
import kotlinx.android.synthetic.main.fragment_search_body.group
import kotlinx.android.synthetic.main.item_tree_body.*
import showmethe.github.core.base.BaseFragment

/**
 *  com.show.wanandroid.ui.main.fragment
 *  2020/3/26
 *  23:57
 */
class SearchBodyFragment : BaseFragment<FragmentSearchBodyBinding, MainViewModel>() {


    override fun initViewModel(): MainViewModel = createViewModel()
    override fun getViewId(): Int = R.layout.fragment_search_body
    override fun onBundle(bundle: Bundle) {

    }


    override fun observerUI() {
        viewModel.hotKey.observe(this, Observer {
            it?.apply {
                response?.apply {
                    addGroup(this)
                }
            }
        })

    }

    override fun init(savedInstanceState: Bundle?) {

        if(viewModel.hotKey.value == null){
            router.toTarget("getHotKey")
        }
    }


    override fun initListener() {

    }

    private fun addGroup(array:ArrayList<KeyWord>){
        array.forEach {
            val chip = View.inflate(context,R.layout.chip_tree_layout,null) as Chip
            chip.text =  it.name
            chip.setTextColor(Color.WHITE)
            chip.chipBackgroundColor = ColorStateList.valueOf(Color.parseColor("#5f4fc3f7"))
            group.addView(chip)
        }

    }
}