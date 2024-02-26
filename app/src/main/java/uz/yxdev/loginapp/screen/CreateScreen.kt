package uz.yxdev.loginapp.screen

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import uz.yxdev.loginapp.R
import uz.yxdev.loginapp.data.repository.AuthRepository
import uz.yxdev.loginapp.databinding.ScreenCreateBinding
import uz.yxdev.loginapp.presenter.CreatePresenter

class CreateScreen : Fragment(R.layout.screen_create) {

    private var _binding: ScreenCreateBinding? = null
    private val binding: ScreenCreateBinding get() = _binding!!
    private lateinit var presenter: CreatePresenter
    private lateinit var repository: AuthRepository
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = ScreenCreateBinding.bind(view)
        repository = AuthRepository(requireContext())
        presenter = CreatePresenter(this, repository)
        loadUiClickable()
    }

    private fun loadUiClickable() {
        binding.createBtn.setOnClickListener {
            presenter.create()
        }
        binding.back.setOnClickListener {
            presenter.backClick()
        }
    }
    fun backClick(){
        parentFragmentManager.popBackStack()
    }

    fun getLogin(): String = binding.loginEt.text.toString()
    fun getPassword(): String = binding.passwordEt.text.toString()
    fun getName(): String = binding.nameEt.text.toString()
    fun getEmail(): String = binding.emailEt.text.toString()
    fun getPhone(): String = binding.phoneEt.text.toString()
    fun getConfirmPassword():String=binding.confirmPasswordEt.text.toString()

    fun success() {
        parentFragmentManager.popBackStack()
    }

    fun showError(){
        Toast.makeText(context, "Wrong", Toast.LENGTH_SHORT).show()
    }
    fun confirmPasswordError(){
        Toast.makeText(context,"Confirm password Pasword bilan bir xil emas", Toast.LENGTH_SHORT).show()
    }
}