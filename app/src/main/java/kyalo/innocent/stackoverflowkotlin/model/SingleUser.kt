package kyalo.innocent.stackoverflowkotlin.model

import com.google.gson.annotations.SerializedName

data class SingleUser(
    @SerializedName("display_name")
    val name : String? = null,

    @SerializedName("profile_image")
    val profile_image : String? = null,

    @SerializedName("website_url")
    val website : String? = null,

    @SerializedName("location")
    val location : String? = null,

    @SerializedName("badge_counts")
    val badges : HashMap<String, Int>? = null
)