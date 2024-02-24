package uz.yxdev.loginapp.screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import uz.yxdev.loginapp.databinding.ActivityMainBinding
import uz.yxdev.loginapp.presenter.MainPresenter

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!
    private lateinit var presenter: MainPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter= MainPresenter(this)
        loadUi()
    }
    private fun loadUi(){
        presenter.addFragment()
    }
    fun addFragment(){
        supportFragmentManager.commit{
            setReorderingAllowed(true)
            add(binding.fragment.id, LoginScreen(),"Login Screen")
        }
    }
}