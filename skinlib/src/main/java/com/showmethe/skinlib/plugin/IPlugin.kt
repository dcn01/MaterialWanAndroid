package com.showmethe.skinlib.plugin

import android.view.View

interface IPlugin<T : View> {

    fun individuate(view:T,attrName : String)
}