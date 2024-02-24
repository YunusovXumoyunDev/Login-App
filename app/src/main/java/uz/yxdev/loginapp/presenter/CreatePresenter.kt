package uz.yxdev.loginapp.presenter

import uz.yxdev.loginapp.data.repository.AuthRepository
import uz.yxdev.loginapp.data.utils.checkLogin
import uz.yxdev.loginapp.data.utils.checkPassword
import uz.yxdev.loginapp.screen.CreateScreen

class CreatePresenter(
    private val view: CreateScreen,
    private val repository: AuthRepository
) {
    init {

    }

    fun create() {
        val name = view.getName()
        val login = view.getLogin()
        val password = view.getPassword()
        val phone = view.getPhone()
        val email = view.getEmail()
        val confirmPassword = view.getConfirmPassword()
        if (login.checkLogin() && password.checkPassword()) {
            if (confirmPassword == password) {
                repository.create(
                    name = name,
                    login = login,
                    password = password,
                    phone = phone,
                    email = email,
                )
                view.success()
                repository.createUser()
            } else {
                view.confirmPasswordError()
            }
        } else {
            view.showError()
        }
    }

}