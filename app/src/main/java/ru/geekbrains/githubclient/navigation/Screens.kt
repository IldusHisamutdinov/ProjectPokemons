package ru.geekbrains.githubclient.navigation

import ru.geekbrains.githubclient.mvp.model.entity.ReposGithubUser
import ru.geekbrains.githubclient.ui.fragments.ReposFragment
import ru.geekbrains.githubclient.ui.fragments.UsersFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {
    class UsersScreen : SupportAppScreen() {
        override fun getFragment() = UsersFragment.newInstance()
    }

//    class LoginScreen(val user: GithubUser) : SupportAppScreen() {
//
//        override fun getFragment() = LoginFragment.newInstance(user)
//    }

    class ReposScreen(val reposUser: ReposGithubUser) : SupportAppScreen() {
        override fun getFragment() = ReposFragment.newInstance(reposUser)
           }
}