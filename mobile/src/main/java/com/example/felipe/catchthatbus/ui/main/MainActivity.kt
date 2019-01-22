package com.example.felipe.catchthatbus.ui.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import com.example.felipe.catchthatbus.R
import com.example.felipe.catchthatbus.ui.departures.DeparturesFragment
import com.example.felipe.catchthatbus.ui.departures.TODAY_ONLY
import kotlinx.android.synthetic.main.activity_main.toolbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        loadFragment()
    }

    private fun loadFragment() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, createFragment())
            .commit()
    }

    private fun createFragment(): Fragment {
        return DeparturesFragment().apply {
            arguments = Bundle().apply {
                putBoolean(TODAY_ONLY, false)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
}
