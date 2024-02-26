package uz.yxdev.loginapp.screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import uz.yxdev.loginapp.R
import uz.yxdev.loginapp.data.repository.AuthRepository
import uz.yxdev.loginapp.databinding.ScreenUserDetailBinding
import uz.yxdev.loginapp.presenter.UserPresenter

class UserDetailScreen : Fragment(R.layout.screen_user_detail) {
    private var _binding: ScreenUserDetailBinding? = null
    private val binding: ScreenUserDetailBinding get() = _binding!!
    private lateinit var presenter: UserPresenter
    private lateinit var repository: AuthRepository
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        repository= AuthRepository(requireContext())
        presenter= UserPresenter(this,repository)
        _binding = ScreenUserDetailBinding.bind(view)
        loadUi()
        loadUiClickable()
    }
    private fun loadUi(){
        binding.name.text=repository.getName()
        binding.login.text=repository.getLogin()
        binding.phone.text=repository.getNumber()
        binding.email.text=repository.getEmail()
    }
    private fun loadUiClickable(){
        binding.back.setOnClickListener {
            presenter.backClick()
        }
    }
    fun backClick(){
        parentFragmentManager.popBackStack()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

}