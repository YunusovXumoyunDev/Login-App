package uz.yxdev.loginapp.presenter

import android.os.CountDownTimer
import uz.yxdev.loginapp.data.repository.AuthRepository
import uz.yxdev.loginapp.data.utils.checkPassword
import uz.yxdev.loginapp.screen.ForgetPasswordScreen
import kotlin.random.Random

class ForgetPresenter(
    private val view: ForgetPasswordScreen,
    private val repository: AuthRepository
) {
    private var code = -1
    private val time = 120
    private fun loadTimer(timer: Long): String {
        val min = timer / 60
        val second = timer % 60
        val minText = if (min < 10) "0$min" else min.toString()
        val secondText = if (second < 10) "0$second" else second.toString()
        return "$minText:$secondText"
    }

    private fun startTimer() {
        view.generateCode()
        val timer = object : CountDownTimer(time * 1000L, 1000L) {
            override fun onTick(millisUntilFinished: Long) {
                loadTimer(millisUntilFinished / 1000)
            }

            override fun onFinish() {
                code = -1
                view.resendVisibility()
            }
        }
        timer.start()
    }

    fun enterClick() {
        val password = view.getPassword()
        val confirmPassword = view.getConfirmPassword()
        if (password.checkPassword()) {
            if (password == confirmPassword) {
                view.enterClick()
                repository.create(
                    login = repository.getLogin(),
                    name = repository.getName(),
                    email = repository.getEmail(),
                    phone = repository.getNumber(),
                    password = password
                )
            } else {
                view.error("Password va ConfirmPassword bir xil emas!")
            }
        } else {
            view.error("Parol to'g'ri kiritilmagan")
        }
    }

    fun sendLoginClick() {
        if (view.getLogin() == repository.getLogin()) {
            view.hideLogin()
            view.showCode()
            startTimer()
        } else {
            view.error("Siz kiritgan login ro'yxatdan o'tmagan!")
        }
    }

    fun sendCodeClick() {
        if (view.getCode().equals(generateCode()) && view.getCode().equals("-1")) {
            view.hideCode()
            view.showPassword()
        } else {
            view.error("Kiritilgan kod xato!")
        }
    }

    fun generateCode(): String {
        code = Random.nextInt(1000, 10000)
        return code.toString()
    }

}