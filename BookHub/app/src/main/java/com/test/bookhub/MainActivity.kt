package com.test.bookhub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var drawerLayout : DrawerLayout
    lateinit var coordinatorLayout  : CoordinatorLayout
    lateinit var toolbar :Toolbar
    lateinit var navigationView : NavigationView
    lateinit var frameLayout : FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.DrawerLayout)
        coordinatorLayout = findViewById(R.id.coordiantorLayout)
        toolbar = findViewById(R.id.toolbar)
        navigationView = findViewById(R.id.navigationView)
        frameLayout = findViewById(R.id.frameLayout)

        setUpToolbar()
        val ActionBarDrawerToggle = ActionBarDrawerToggle(this@MainActivity ,drawerLayout , R.string.opening_drawer , R.string.closing_drawer)

        drawerLayout.addDrawerListener(ActionBarDrawerToggle)
        ActionBarDrawerToggle.syncState()


        navigationView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.Dashboard -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout ,DashboardFragment())
                        .commit()
                    drawerLayout.closeDrawers()
                }
                R.id.Favourites -> {
                    Toast.makeText(this@MainActivity , "click on Favourites" , Toast.LENGTH_LONG).show()
                }
                R.id.profile -> {
                    Toast.makeText(this@MainActivity , "click on Profile" , Toast.LENGTH_LONG).show()
                }
                R.id.aboutApp -> {
                    Toast.makeText(this@MainActivity , "click on About app" , Toast.LENGTH_LONG).show()
                }
            }
            return@setNavigationItemSelectedListener true
        }
    }

    fun setUpToolbar(){
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Toolbar Title"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if(id==android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)
    }
}