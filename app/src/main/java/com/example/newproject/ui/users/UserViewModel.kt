package com.example.newproject.ui.users

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newproject.data.network.NetworkManager
import com.example.newproject.model.User
import com.example.newproject.model.UserFromServer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel:ViewModel() {

    var _listUsers = MutableLiveData<List<String>>()

private val _searchResult = MutableLiveData<List<String>>()
    val searchResult: LiveData<List<String>> = _searchResult

    fun getUsersFromServer(){
        NetworkManager.service.getUser().enqueue(object : Callback<List<UserFromServer>>{
            override fun onResponse(
                call: Call<List<UserFromServer>>,
                response: Response<List<UserFromServer>>
            ) {
                _listUsers.postValue(response.body()?.map { it->
                    it.firstName + it.lastName
                })
            }

            override fun onFailure(call: Call<List<UserFromServer>>, t: Throwable) {
                Log.d("TAG", t.message.toString())
            }
        })
    }
    fun searchFromUsers(query:HashMap<String,String>){
        NetworkManager.service.getUser(query).enqueue(object : Callback<List<UserFromServer>?> {
            override fun onResponse(
                call: Call<List<UserFromServer>?>,
                response: Response<List<UserFromServer>?>
            ) {
                _searchResult.postValue(response.body()?.map {
                    it.firstName
                })
            }

            override fun onFailure(call: Call<List<UserFromServer>?>, t: Throwable) {
                Log.d("TAG","searchResult:" + t.message.toString())
            }
        })

    }
    fun getUserFromFirstName(firstname:String){
        if (firstname.isNotBlank()){
            searchFromUsers( hashMapOf("firstname" to firstname))
        }


    }
}