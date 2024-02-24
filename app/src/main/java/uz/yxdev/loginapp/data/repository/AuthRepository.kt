package uz.yxdev.loginapp.data.repository

import android.content.Context
import uz.yxdev.loginapp.data.storage.local.LocalStorage

class AuthRepository(private val context: Context) {
    private val storage = LocalStorage(context)
    fun create(
        login: String,
        password: String,
        name: String,
        phone: String,
        email: String,
    ) {
        storage.saveString("login",login)
        storage.saveString("password",password)
        storage.saveString("name",name)
        storage.saveString("number",phone)
        storage.saveString("email",email)
    }
    fun getLogin():String=storage.getString("login")
    fun getPassword():String=storage.getString("password")
    fun getName():String=storage.getString("name")
    fun getNumber():String=storage.getString("number")
    fun getEmail():String=storage.getString("email")
    fun hasUser():Boolean=storage.getBoolean("isUserExist")
    fun createUser(){
        storage.saveBoolean("isUserExist",true)
    }
}