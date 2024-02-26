package uz.yxdev.loginapp.presenter

import uz.yxdev.loginapp.data.repository.AuthRepository
import uz.yxdev.loginapp.screen.UserDetailScreen

class UserPresenter(
    private val view:UserDetailScreen,
    private val repository: AuthRepository
) {
    fun backClick(){
        view.backClick()
    }
}