package com.code.demo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

/**
 * nestscrollview 的几个属性，以AppBarlayout为例
 * scroll 滑出 、插进屏幕
 * enterAlways 配合scroll，插进时先插进然后别的view在滑动
 * enterAlwaysCollapsed 配合scroll 、enterAlways，插进时先插进到最小高度，然后别的view滑动到底部，最后全部插进来
 * exitUntilCollapsed  滑出时不会全部滑出，只滑出到最小高度。 - -`
 * Collapser的两个属性更多的是配合CollaspsingToolbarLayout使用
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }
    private fun initViews() {
        tv.text = resources.getString(R.string.coordinate)
        toolbar.title = "标题"
        toolbar.setNavigationIcon(R.mipmap.ic_launcher)
        fab.setOnClickListener(View.OnClickListener { Snackbar.make(findViewById(R.id.contentView),"wo shi sb",Snackbar.LENGTH_SHORT).show() })
        // 测试git
    }
}
