package pl.mateuszkrawczuk.githubclient.dagger

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.mateuszkrawczuk.githubclient.ui.main.UserSearchFragment

@Module
abstract class FragmentBindingModule {

    @ContributesAndroidInjector
    internal abstract fun contributeMainFragment(): UserSearchFragment
}