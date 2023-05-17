package com.example.oneheart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.oneheart.databinding.ActivityMainBinding
import com.example.oneheart.screens.DonateNavFragment
import com.example.oneheart.screens.HomeNavFragment
import com.example.oneheart.screens.NgoNavFragment
import com.example.oneheart.screens.ProfileNavFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        changeFragment(HomeNavFragment())

        binding.bottomNavBar.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.bottomNavHome -> changeFragment(HomeNavFragment())
                R.id.bottomNavDonate -> changeFragment(DonateNavFragment())
                R.id.bottomNavNgo -> changeFragment(NgoNavFragment())
                R.id.bottomNavProfile -> changeFragment(ProfileNavFragment())
                else -> {
                    changeFragment(HomeNavFragment())
                }
            }
            true
        }
    }

    private fun changeFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, fragment)
        transaction.commit()
    }
}