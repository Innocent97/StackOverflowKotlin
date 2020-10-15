package kyalo.innocent.stackoverflowkotlin.view_model

import androidx.lifecycle.ViewModel
import kyalo.innocent.stackoverflowkotlin.model.Users
import kyalo.innocent.stackoverflowkotlin.model.UsersList
import kyalo.innocent.stackoverflowkotlin.network.ApiClient
import kyalo.innocent.stackoverflowkotlin.network.StackService
import retrofit2.Call
import retrofit2.await

class GetUsersViewModel : ViewModel() {

    var fList : UsersList? = null

    suspend fun getUsers()  {
        val stackService  = ApiClient.apiClient?.create(StackService::class.java)
        val apiCall  = stackService?.getUsers("reputation")

        val list = apiCall?.await()
        //val list : List<Users> = stackUser.getUsers("reputation").await()
        fList = list
    }
}