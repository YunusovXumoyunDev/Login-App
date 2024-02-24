package uz.yxdev.loginapp.screen

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import uz.yxdev.loginapp.R
import uz.yxdev.loginapp.data.repository.AuthRepository
import uz.yxdev.loginapp.databinding.ScreenLoginBinding
import uz.yxdev.loginapp.presenter.LoginPresenter

class LoginScreen : Fragment(R.layout.screen_login) {
    private var _binding: ScreenLoginBinding? = null
    private val binding: ScreenLoginBinding get() = _binding!!
    private lateinit var presenter: LoginPresenter
    private lateinit var repository: AuthRepository
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = ScreenLoginBinding.bind(view)
        repository = AuthRepository(requireContext())
        presenter = LoginPresenter(this, repository)
        loadUiClickable()
    }

    private fun loadUiClickable() {
        binding.register.setOnClickListener {
            presenter.registerClick()
        }
        binding.signInBtn.setOnClickListener {
            presenter.signInClick()
        }

    }

    fun registerClick() {
        parentFragmentManager.commit {
            setReorderingAllowed(true)
            replace(
                R.id.fragment,
                CreateScreen(),
                "Create Screen"
            )
            addToBackStack(null)
        }
    }
    fun showForgetPassword(){
        binding.forgetPassword.isVisible=true
    }
    fun hideRegister(){
        binding.registerLy.isVisible=false
    }
    fun hideForgetPassword(){
        binding.forgetPassword.isVisible=false
    }
    fun showRegister(){
        binding.registerLy.isVisible=true
    }

    fun getLogin(): String = binding.loginEt.text.toString()
    fun getPassword(): String = binding.passwordEt.text.toString()
    fun signIn() {
        parentFragmentManager.commit {
            setReorderingAllowed(true)
            replace(
                R.id.fragment,
                UserDetailScreen(),
                "User Screen"
            )
            addToBackStack(null)
        }
    }

    fun showError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}