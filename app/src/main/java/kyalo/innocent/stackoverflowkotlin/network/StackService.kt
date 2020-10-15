package kyalo.innocent.stackoverflowkotlin.network

import kyalo.innocent.stackoverflowkotlin.model.SingleUser
import kyalo.innocent.stackoverflowkotlin.model.TopUserList
import kyalo.innocent.stackoverflowkotlin.model.UsersList
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call

interface StackService {

    @GET("/2.2/users?page=1&pagesize=100&order=desc&site=stackoverflow")
    fun getUsers (@Query("users")  name : String) : Call<UsersList>

    @GET("/2.2/users?order=desc&sort=reputation&site=stackoverflow")
    fun getListOfUsers () : Call<TopUserList>
}