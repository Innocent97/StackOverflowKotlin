package kyalo.innocent.stackoverflowkotlin.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Users(
    @Expose
    @SerializedName("location")
    val location : String? = null,

    @Expose
    @SerializedName("display_name")
    val name : String? = null,

    @Expose
    @SerializedName("reputation")
    val reputation : String? = null,

    @Expose
    @SerializedName("badge_counts")
    val badges : HashMap<String, Int>? = null

)