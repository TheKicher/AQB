package com.k1ch.aqb.ui.activity

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.k1ch.aqb.R

class MainActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)


            val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)

            val navController = findNavController(R.id.nav_host_fragment_activity_main)


                setOf(
                    R.id.ic_home, R.id.ic_quote_book,
                )

            navView.setupWithNavController(navController)
        }
}