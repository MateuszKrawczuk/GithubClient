package pl.mateuszkrawczuk.githubclient

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import pl.mateuszkrawczuk.githubclient.dagger.DaggerAppComponent

class GithubClientApplication :
    DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.factory()
            .create(this)

}