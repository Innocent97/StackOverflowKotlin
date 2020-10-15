package kyalo.innocent.stackoverflowkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kyalo.innocent.stackoverflowkotlin.adapter.SingleUserAdapter
import kyalo.innocent.stackoverflowkotlin.adapter.UsersAdapter
import kyalo.innocent.stackoverflowkotlin.model.SingleUser
import kyalo.innocent.stackoverflowkotlin.model.UsersList
import kyalo.innocent.stackoverflowkotlin.view_model.SingleUserViewModel


class MainActivity : AppCompatActivity() {

    private val viewModels : SingleUserViewModel by lazy {
        ViewModelProvider(this)[SingleUserViewModel::class.java]
    }
    private lateinit var usersAdapter: UsersAdapter

    private lateinit var singleUserAdapter: SingleUserAdapter

    private  var fUsersList : UsersList? = null

    private  var fSingleUserList : List<SingleUser>? = null

    private lateinit var recylerview : RecyclerView

    val layoutManager : LinearLayoutManager = LinearLayoutManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch(Dispatchers.IO) {
            viewModels.getSingleUsersList()

            fSingleUserList = viewModels.singleUserList

            withContext(Dispatchers.Main) {
                showUsers(fSingleUserList)
            }
        }


    }


    fun showUsers(list: List<SingleUser>?) {
        recylerview = users_recycler
        recylerview.layoutManager = layoutManager
        singleUserAdapter = list?.let { SingleUserAdapter(this, it) }!!
        recylerview.adapter = singleUserAdapter
        singleUserAdapter.notifyDataSetChanged()

        /*val usersList = list

        fUsersList = list
        val localList : List<Users> = ArrayList<Users>()
        recylerview.layoutManager = layoutManager

        //usersAdapter = list.let { UsersAdapter(this, fUsersList!!) }
        recylerview.adapter = usersAdapter
        usersAdapter.notifyDataSetChanged()*/
    }
}