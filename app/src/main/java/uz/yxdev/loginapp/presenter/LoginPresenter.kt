package uz.yxdev.loginapp.presenter

import uz.yxdev.loginapp.data.repository.AuthRepository
import uz.yxdev.loginapp.screen.LoginScreen

class LoginPresenter(
    private val view: LoginScreen,
    private val repository: AuthRepository
) {

    init {
        if (repository.hasUser()){
            view.showForgetPassword()
            view.hideRegister()
        }else{
            view.hideForgetPassword()
            view.showRegister()
        }
    }
    fun registerClick() {
        view.registerClick()
    }
    fun forgetClick(){
        view.forgetClick()
    }
    fun signInClick(){
        if (checkLogin()&&checkPassword()){
            view.signIn()
        }else{
            view.showError("Login yoki parol xato")
        }
    }

    fun loadUi() {

    }

    private fun checkLogin():Boolean {
        val login = view.getLogin()
        return (login == (repository.getLogin()))
    }

    private fun checkPassword():Boolean {
        val password = view.getPassword()
        return password==(repository.getPassword())
    }
}