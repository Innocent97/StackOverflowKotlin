package kyalo.innocent.stackoverflowkotlin.view_model

import android.util.Log
import androidx.lifecycle.ViewModel
import kyalo.innocent.stackoverflowkotlin.model.SingleUser
import kyalo.innocent.stackoverflowkotlin.model.TopUserList
import kyalo.innocent.stackoverflowkotlin.network.ApiClient
import kyalo.innocent.stackoverflowkotlin.network.StackService
import retrofit2.await

class SingleUserViewModel : ViewModel() {
    var singleUserList : List<SingleUser>? = null
    val TAG = "Response: "

    suspend fun getSingleUsersList() {
        val apiClient : StackService? = ApiClient.apiClient?.create(StackService::class.java)
        val listCall = apiClient?.getListOfUsers()?.await()

        val theList = listCall?.topUserList
        singleUserList = theList

        for ( user in listCall?.topUserList!!) {
            Log.d(TAG, "Name: ${user.name}\n" +
                "Profile_Image: ${user.profile_image}\n" +
                "Website_URL: ${user.website}\n" +
                "Location: ${user.location}\n" +
                "Bronze: ${user.badges?.get("bronze")}\n" +
                "Silver: ${user.badges?.get("silver")}\n" +
                "Gold: ${user.badges?.get("gold")}\n")
        }
        Log.d(TAG, "getSingleUsersList: " + (listCall?.topUserList ))
    }
}