package kyalo.innocent.stackoverflowkotlin.network

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object ApiClient  {

    private  val BASE_URL = "https://api.stackexchange.com"

    private var retrofit: Retrofit? = null

    private val gson = GsonBuilder()
        .setLenient()
        .create()

    val apiClient: Retrofit?
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
            }
            return retrofit
        }


}