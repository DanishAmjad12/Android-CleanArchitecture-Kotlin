package com.fernandocejas.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.fernandocejas.sample.framework.extension.inTransaction
import kotlinx.android.synthetic.main.toolbar.*

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout)
        setSupportActionBar(toolbar)
        addFragment(savedInstanceState)
    }

    private fun addFragment(savedInstanceState: Bundle?) {
        savedInstanceState ?:
                supportFragmentManager.inTransaction { add(R.id.fragmentContainer, fragment()) }
    }

    internal fun hideToolbar() = supportActionBar?.hide()

    abstract fun fragment(): BaseFragment
}
