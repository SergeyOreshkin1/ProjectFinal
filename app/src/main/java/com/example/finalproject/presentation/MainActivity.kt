package com.example.finalproject.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.finalproject.R
import com.example.finalproject.presentation.root.view.RootFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            navigateToFragment(R.id.fragmentContainerView, RootFragment.newInstance())
        }
    }

    fun navigateToFragment(replaceableFragment: Int, newFragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(replaceableFragment, newFragment)
            .commit()
    }
}
