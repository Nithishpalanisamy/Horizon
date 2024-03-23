package com.example.horizon

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class Home : MainActivity() {
    private lateinit var bottomNavigationView:BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)
        bottomNavigationView=findViewById(R.id.bottomNavigation)
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.bottom_home->{
                    replaceFragment(FragmentHome())
                    true
                }
                R.id.bottom_search->{
                    replaceFragment(FragementSearch())
                    true
                }
                R.id.bottom_add->{
                    replaceFragment(FragmentAdd())
                    true
                }
                R.id.bottom_profile->{
                    replaceFragment(FragmentProfile())
                    true
                }
                else -> false
            }
        }
        replaceFragment(FragmentHome())
    }
    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout,fragment).commit()
    }
}
