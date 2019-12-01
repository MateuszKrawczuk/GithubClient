package pl.mateuszkrawczuk.tumblrclient

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        setupNavFramework()
    }

    fun setupNavFramework() {
        val host = NavHostFragment.create(R.navigation.navcomponent)
        supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, host)
            .setPrimaryNavigationFragment(host).commit()
    }
}