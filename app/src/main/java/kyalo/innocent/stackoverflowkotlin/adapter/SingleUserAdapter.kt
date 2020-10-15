package kyalo.innocent.stackoverflowkotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.single_user_layout.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kyalo.innocent.stackoverflowkotlin.R
import kyalo.innocent.stackoverflowkotlin.R.string
import kyalo.innocent.stackoverflowkotlin.R.string.*
import kyalo.innocent.stackoverflowkotlin.model.SingleUser

class SingleUserAdapter(
     val fContext : Context,
     var userList : List<SingleUser>
) : RecyclerView.Adapter<SingleUserAdapter.SingleUserViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingleUserViewHolder {
        val rootView : View = LayoutInflater.from(fContext)
            .inflate(R.layout.single_user_layout, parent, false)

        return SingleUserViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: SingleUserViewHolder, position: Int) {
        val singleUser : SingleUser = userList.get(position)
        val badgesMap = userList.get(position).badges

        GlobalScope.launch(Dispatchers.Main) { holder.run {

            // bind data to views
            Picasso.get().load(singleUser.profile_image).into(profile_image)
            display_name.setText(fContext.getString(name) + singleUser.name)
            location.setText(fContext.getString(string.location) + singleUser.location)
            website_url.setText(fContext.getString(website_string) + singleUser.website)

            // set badges count
            bronze.setText("Bronze: ${badgesMap?.get("bronze")}")
            silver.setText("Silver: ${badgesMap?.get("silver")}")
            gold.setText("Gold: ${badgesMap?.get("gold")}")
        } }
    }

    override fun getItemCount(): Int {
        return userList.size ?: 0
    }

    class SingleUserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val display_name = itemView.tv_display_name
        val profile_image = itemView.image_profile
        val website_url = itemView.tv_website_url
        val location = itemView.tv_location
        val bronze = itemView.tv_bronze
        val silver = itemView.tv_silver
        val gold = itemView.tv_gold
    }
}