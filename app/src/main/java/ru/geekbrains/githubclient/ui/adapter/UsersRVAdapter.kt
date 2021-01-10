package ru.geekbrains.githubclient.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_user.view.*
import ru.geekbrains.githubclient.GithubApplication
import ru.geekbrains.githubclient.R
import ru.geekbrains.githubclient.mvp.model.entity.Pokemon
import ru.geekbrains.githubclient.mvp.model.entity.ReposGithubUser
import ru.geekbrains.githubclient.mvp.presenters.list.ILoginListPresenter
import ru.geekbrains.githubclient.mvp.view.image.IImageLoader
import ru.geekbrains.githubclient.mvp.view.list.LoginItemView
import javax.inject.Inject


class UsersRVAdapter(
        val presenter: ILoginListPresenter) : RecyclerView.Adapter<UsersRVAdapter.ViewHolder>() {
    @Inject
    lateinit var imageLoader: IImageLoader<ImageView>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.pos = position
        holder.containerView.setOnClickListener {
            presenter.itemClickListener?.invoke(holder)
        }
        presenter.bindView(holder)
    }

    override fun getItemCount() = presenter.getCount()

    inner class ViewHolder(override val containerView: View) :
            RecyclerView.ViewHolder(containerView), LayoutContainer, LoginItemView {
        override var pos = -1

        override fun setName(text: String) = with(containerView) {
            name_pokemon.text = text
        }

        override fun bind(pokemon: ReposGithubUser) = with(containerView) {
            name_pokemon.text = pokemon.name
            id_pokemon.text = pokemon.id.toString()
        }

        override fun loadAvatar(url: String) = with(containerView) {
            imageLoader.loadInto(url, img_pokemon)
        }
    }
}