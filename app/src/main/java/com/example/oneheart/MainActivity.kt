package com.example.oneheart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import com.example.oneheart.databinding.ActivityMainBinding
import com.example.oneheart.screens.DonateNavFragment
import com.example.oneheart.screens.HomeNavFragment
import com.example.oneheart.screens.NgoNavFragment
import com.example.oneheart.screens.PostActivity
import com.example.oneheart.screens.ProfileNavFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        actionBar?.show()

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

        binding.apply {
            toggle = ActionBarDrawerToggle(this@MainActivity, drawerLayout, R.string.open, R.string.close)
            drawerLayout.addDrawerListener(toggle)
            toggle.syncState()

            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            navView.setNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.firstItem -> {
                        Toast.makeText(this@MainActivity, "First Item Clicked", Toast.LENGTH_SHORT).show()
                    }
                    R.id.secondtItem -> {
                        Toast.makeText(this@MainActivity, "Second Item Clicked", Toast.LENGTH_SHORT).show()
                    }
                    R.id.thirdItem -> {
                        Toast.makeText(this@MainActivity, "third Item Clicked", Toast.LENGTH_SHORT).show()
                    }
                }
                true
            }
        }

        binding.floatingPost.setOnClickListener {
            intent = android.content.Intent(this, PostActivity::class.java)
        }
    }

    private fun changeFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, fragment)
        transaction.commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            true
        }
        return super.onOptionsItemSelected(item)
    }

}