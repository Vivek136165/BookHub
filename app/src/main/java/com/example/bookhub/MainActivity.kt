package com.example.bookhub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    lateinit var drawerLayout: DrawerLayout
    lateinit var coordinateLayout: DrawerLayout
    lateinit var frameLayout: DrawerLayout
    lateinit var navigationView: NavigationView
    lateinit var toolbar:Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        drawerLayout=findViewById(R.id.drawerLayout)
        coordinateLayout=findViewById(R.id.coordinatorLayout)
        toolbar=findViewById(R.id.toolbar)
        frameLayout=findViewById(R.id.frame)
        navigationView=findViewById(R.id.navigationView)
        setUpToolbar()
        val actionBarDrawerToggle=ActionBarDrawerToggle(
            this@MainActivity, drawerLayout,
            R.string.open_drawer,
            R.string.close_drawer)
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        navigationView.setNavigationItemSelectedListener {

         when(it.itemId){
             R.id.dashboard->{
                 Toast.makeText(this@MainActivity,"Clicked on Dashboard",Toast.LENGTH_SHORT).show()
             }
             R.id.favourites->{
                 Toast.makeText(this@MainActivity,"Clicked on Favourites",Toast.LENGTH_SHORT).show()
             }
             R.id.profile->{
                 Toast.makeText(this@MainActivity,"Clicked on Profile",Toast.LENGTH_SHORT).show()
             }
             R.id.aboutApp->{
                 Toast.makeText(this@MainActivity,"Clicked on About App",Toast.LENGTH_SHORT).show()
             }
         }


       return@setNavigationItemSelectedListener true
    }

    }
    fun setUpToolbar(){
       setSupportActionBar(toolbar)
       supportActionBar?.title="Toolbar Title"
       supportActionBar?.setHomeButtonEnabled(true)
       supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id=item.itemId
        if(id==android.R.id.home)
        {
            drawerLayout.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)
    }
}