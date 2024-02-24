package uz.yxdev.loginapp.screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import uz.yxdev.loginapp.R
import uz.yxdev.loginapp.data.repository.AuthRepository
import uz.yxdev.loginapp.databinding.ScreenUserDetailBinding
import uz.yxdev.loginapp.presenter.LoginPresenter

class UserDetailScreen : Fragment(R.layout.screen_user_detail) {
    private var _binding: ScreenUserDetailBinding? = null
    private val binding: ScreenUserDetailBinding get() = _binding!!
    private lateinit var presenter: LoginPresenter
    private lateinit var repository: AuthRepository
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = ScreenUserDetailBinding.bind(view)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

}