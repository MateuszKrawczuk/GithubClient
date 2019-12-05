package pl.mateuszkrawczuk.tumblrclient

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import pl.mateuszkrawczuk.tumblrclient.dagger.DaggerAppComponent

class MyApplication :
    DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.factory()
            .create(this)

}