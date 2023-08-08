package com.example.booklearn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    lateinit var drawerLayout: DrawerLayout;
    lateinit var coordinatorLayout: CoordinatorLayout;
    lateinit var toolbar: Toolbar
    lateinit var frameLayout: FrameLayout;
    lateinit var navigationView: NavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      drawerLayout = findViewById(R.id.drawerLayout)
        coordinatorLayout=findViewById(R.id.coordinatorLayout)
        toolbar=findViewById(R.id.tool)
        frameLayout=findViewById(R.id.frame)
        navigationView=findViewById(R.id.navigationView);
        //now here we are usign navgation view is ke andr menu list
        //ha unko clickable bnna h;
        navigationView.setNavigationItemSelectedListener {
            //it is using for giving selected item;
            when(it.itemId){
                R.id.dashboard->{
                    supportFragmentManager.beginTransaction().replace(R.id.frame,DashBoardFragment())
                        .addToBackStack("Dashboardf")
                        .commit()
                    drawerLayout.closeDrawers()
                    }
                R.id.favourite->{
                    supportFragmentManager.beginTransaction().replace(R.id.frame,favouriteFragment())
                        .addToBackStack("Favourite")
                        .commit()
                    drawerLayout.closeDrawers()  }
                R.id.profile->{
                    supportFragmentManager.beginTransaction().replace(R.id.frame,profileFrament())
                        .addToBackStack("Profile")
                        .commit()
                    drawerLayout.closeDrawers() }
                R.id.about->{
                    supportFragmentManager.beginTransaction().replace(R.id.frame,aboutFragment())
                        .addToBackStack("About")
                        .commit()
                    drawerLayout.closeDrawers()
                         }
            }

            //return set krna parege return ko;
            return@setNavigationItemSelectedListener true
        }
        setUpToolbar()

//        this is function for drawer open close;
        // we have predefined object actionbardrawertoggle; the purpose of it was kaha p khulega ,clsoe ,open  and putting the actionbartoggle to drawerLayout;
        var actionBarDrawerToggle = ActionBarDrawerToggle(this@MainActivity,drawerLayout,R.string.open_drawer,R.string.close_drawer)
        //this is used to make the event
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
//      this is used for open and close sync when hamburger click it turn icon into arrow and then wise verse;
        actionBarDrawerToggle.syncState()
    }
//    this function are used to created toolbar and working on actionbar;

    fun setUpToolbar(){
        setSupportActionBar(toolbar);
        supportActionBar?.title = "Toolbar title"
        //with these two we can make the humburger init;
        //predefined ha per hmme functionaliity khud bnnani pregi;
        supportActionBar?.setHomeButtonEnabled(true);
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

//    in hamburger icon not giving work  directly
    //so fetching the id of the hamburger icon by we have built in func;
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
    val id = item.itemId
    if(id == android.R.id.home){
        drawerLayout.openDrawer(GravityCompat.START)
    }
    return super.onOptionsItemSelected(item)
    }


}