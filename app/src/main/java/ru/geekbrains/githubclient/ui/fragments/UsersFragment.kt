package ru.geekbrains.githubclient.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_users.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.geekbrains.githubclient.GithubApplication
import ru.geekbrains.githubclient.R
import ru.geekbrains.githubclient.mvp.model.repo.IGithubRepositoriesRepo
import ru.geekbrains.githubclient.mvp.presenters.UsersPresenter
import ru.geekbrains.githubclient.mvp.view.UsersView
import ru.geekbrains.githubclient.ui.BackButtonListener
import ru.geekbrains.githubclient.ui.adapter.UsersRVAdapter


class UsersFragment : MvpAppCompatFragment(), UsersView, BackButtonListener {
    companion object {
        fun newInstance() = UsersFragment()
    }


    val presenter: UsersPresenter by moxyPresenter {
        UsersPresenter().apply {
            GithubApplication.instance.initUserSubcomponent().inject(this)
        }
    }

    var adapter: UsersRVAdapter? = null

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View = View.inflate(context, R.layout.fragment_users, null)


    override fun init() {
        rv_users.layoutManager =
                GridLayoutManager(context,2)
        adapter = UsersRVAdapter(presenter.usersListPresenter).apply {
            GithubApplication.instance.initUserSubcomponent().inject(this)
        }

        rv_users.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun snowError(error: Throwable) {
        Log.d("ОШИБКА RETROFIT", error.message.toString())
    }

    override fun release() {
        GithubApplication.instance.releaseUserSubcomponent()
    }

    override fun onResume() {
        super.onResume()
        activity?.title = "Pokemons"
    }

    override fun backPressed(): Boolean = presenter.backPressed()

}
