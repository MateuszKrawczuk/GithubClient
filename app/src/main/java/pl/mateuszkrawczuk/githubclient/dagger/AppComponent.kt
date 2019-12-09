package pl.mateuszkrawczuk.githubclient.dagger

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import pl.mateuszkrawczuk.githubclient.MyApplication
import javax.inject.Singleton

@Singleton
@Component(
    modules =
    [AndroidInjectionModule::class,
        AppModule::class,
        FragmentBindingModule::class,
        ViewModelModule::class,
        MainFragmentModule::class
    ]
)
interface AppComponent :
    AndroidInjector<MyApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

}