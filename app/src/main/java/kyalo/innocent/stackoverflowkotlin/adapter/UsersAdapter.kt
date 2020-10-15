package kyalo.innocent.stackoverflowkotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kyalo.innocent.stackoverflowkotlin.R
import kyalo.innocent.stackoverflowkotlin.model.Users
import kyalo.innocent.stackoverflowkotlin.model.UsersList

class UsersAdapter(private val fContext: Context,
                   private val listOfUsers: List<Users>
) :
    RecyclerView.Adapter<UsersAdapter.UsersViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val view : View = LayoutInflater.from(fContext).inflate(R.layout.layout_item, parent, false)
        return UsersViewHolder(view)
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
       val user : Users
        user = listOfUsers?.get(position)!!

        val iterator: MutableIterator<MutableMap.MutableEntry<String, Int>>? = listOfUsers!!.get(position).badges?.entries?.iterator()
        val pair = iterator?.next()

        holder.username.setText(user.name.toString())
        holder.reputation.setText(user.reputation.toString())
        holder.location.setText(user.location.toString())

        holder.silverBadge.setText(pair?.key)
        holder.silverBadgeCount.setText(pair?.value.toString())
        holder.bronzeBadge.setText(pair?.value.toString())
        holder.bronzeBadgeCount.setText(pair?.value.toString())
        holder.goldBadge.setText(pair?.value.toString())
        holder.goldBadgeCount.setText(pair?.value.toString())

    }

    override fun getItemCount(): Int {
        return listOfUsers?.size!!
    }

    class UsersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var username : TextView = itemView.findViewById(R.id.tvUsername)
        var location : TextView = itemView.findViewById(R.id.tvLocation)
        var reputation : TextView = itemView.findViewById(R.id.tvReputation)
        var silverBadge : TextView = itemView.findViewById(R.id.tvSilverBadge)
        var silverBadgeCount : TextView = itemView.findViewById(R.id.tvSilverBadgeCount)
        var bronzeBadge : TextView = itemView.findViewById(R.id.tvBronzeBadge)
        var bronzeBadgeCount : TextView = itemView.findViewById(R.id.tvBronzeBadgeCount)
        var goldBadge : TextView = itemView.findViewById(R.id.tvGoldBadge)
        var goldBadgeCount : TextView = itemView.findViewById(R.id.tvGoldBadgeCount)
    }
}