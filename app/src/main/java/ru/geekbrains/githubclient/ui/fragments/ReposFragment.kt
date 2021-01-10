package ru.geekbrains.githubclient.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_repos.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.geekbrains.githubclient.GithubApplication
import ru.geekbrains.githubclient.R
import ru.geekbrains.githubclient.mvp.model.entity.Pokemon
import ru.geekbrains.githubclient.mvp.model.entity.ReposGithubUser
import ru.geekbrains.githubclient.mvp.presenters.ReposLoginPresenter
import ru.geekbrains.githubclient.mvp.view.ReposLoginView
import ru.geekbrains.githubclient.mvp.view.image.GlideImageLoader
import ru.geekbrains.githubclient.mvp.view.image.IImageLoader
import ru.geekbrains.githubclient.ui.BackButtonListener

class ReposFragment(val imageLoader: IImageLoader<ImageView>) : MvpAppCompatFragment(), ReposLoginView, BackButtonListener {

    companion object {
        const val REPOS_LOGIN = "reposLogin"
        fun newInstance(repos: ReposGithubUser): ReposFragment {
            val fragment = ReposFragment(GlideImageLoader())
            val bundle = Bundle()
            bundle.putParcelable(REPOS_LOGIN, repos)
            fragment.arguments = bundle
            return fragment
        }
    }

    val presenter by moxyPresenter {
        ReposLoginPresenter().apply {
            GithubApplication.instance.initRepositoriesSubcomponent()?.inject(this)
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ) = View.inflate(context, R.layout.fragment_repos, null)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.repos = arguments?.getParcelable(REPOS_LOGIN)
    }

    @SuppressLint("SetTextI18n")
    override fun init(pokemon: ReposGithubUser) {
        activity?.title = pokemon.name
        id_pokemon.text = pokemon.id.toString()
        base_experience_pokemon.text =
                "Базовый опыт: ${pokemon.candy_count.toString()}"
        height_pokemon.text = "Рост: ${pokemon.height.toString()}"
        weight_pokemon.text = "Вес: ${pokemon.weight}"
    }

    override fun loadImage(url: String) {
        imageLoader.loadInto(url, imageView)
    }

    override fun showError(e: Throwable) {
        view?.let { e.message?.let { it1 -> Snackbar.make(it, it1, Snackbar.LENGTH_SHORT).show() } }

    }

    override fun release() {
        GithubApplication.instance.releaseRepositorySubcomponent()
    }

    override fun backPressed() = presenter.backPressed()

}