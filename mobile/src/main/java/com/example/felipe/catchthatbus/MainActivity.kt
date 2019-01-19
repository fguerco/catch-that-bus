package com.example.felipe.catchthatbus

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.felipe.catchthatbus.departures.departuresFromAllAvailableRoutes
import com.example.felipe.catchthatbus.departures.distinctRoutes
import kotlinx.android.synthetic.main.activity_main.container
import kotlinx.android.synthetic.main.activity_main.toolbar
import java.time.DayOfWeek

class MainActivity : AppCompatActivity() {

    private val departures = DayOfWeek.MONDAY.departuresFromAllAvailableRoutes(0)  // departuresFromAllAvailableRoutes()
    private val routes = departures.distinctRoutes()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        // Set up the ViewPager with the sections adapter.
        container.adapter = SectionsPagerAdapter(supportFragmentManager)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }


    /**
     * A [FragmentPagerAdapter] that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            // getItem is called to instantiate the fragment for the given page.
            // Return a DeparturesFragment (defined as a static inner class below).
            return DeparturesFragment.newInstance(routes[position], departures)
        }

        override fun getCount(): Int {
            return routes.size
        }
    }
}
