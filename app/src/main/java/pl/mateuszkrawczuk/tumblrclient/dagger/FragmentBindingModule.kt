package pl.mateuszkrawczuk.tumblrclient.dagger

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.mateuszkrawczuk.tumblrclient.ui.main.UserSearchFragment

@Module
abstract class FragmentBindingModule {

    @ContributesAndroidInjector
    internal abstract fun contributeMainFragment(): UserSearchFragment
}