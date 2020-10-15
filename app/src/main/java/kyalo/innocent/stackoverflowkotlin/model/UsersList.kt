package kyalo.innocent.stackoverflowkotlin.model

import com.google.gson.annotations.SerializedName

data class UsersList(
    @SerializedName("items")
    val userList : List<Users>? = null
)