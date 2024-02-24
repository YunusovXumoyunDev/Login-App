package uz.yxdev.loginapp.presenter

import uz.yxdev.loginapp.screen.MainActivity

class MainPresenter(
    private val view:MainActivity
) {
    fun addFragment(){
        view.addFragment()
    }
}