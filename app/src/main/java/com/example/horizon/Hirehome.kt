package com.example.horizon

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class Hirehome : MainActivity() {
    private lateinit var bottomNavigationView:BottomNavigationView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hire_home)
        bottomNavigationView=findViewById(R.id.bottomNavigation01)
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.bottom_home->{
                    replaceFragment(hire_home())
                    true
                }
                R.id.bottom_search->{
                    replaceFragment(hire_search())
                    true
                }
                R.id.bottom_add->{
                    replaceFragment(fragment_post())
                    true
                }
                R.id.bottom_profile->{
                    replaceFragment(hire_profile())
                    true
                }
                else -> false
            }
        }
        replaceFragment(hire_home())
    }
    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout,fragment).commit()
    }
}
