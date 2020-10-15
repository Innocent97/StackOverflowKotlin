package kyalo.innocent.stackoverflowkotlin.model

import com.google.gson.annotations.SerializedName

data class TopUserList(
    @SerializedName("items")
    val topUserList: List<SingleUser>? = null
)
