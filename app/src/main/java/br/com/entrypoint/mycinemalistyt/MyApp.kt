package br.com.entrypoint.mycinemalistyt

import android.app.Application
import br.com.entrypoint.mycinemalistyt.di.apiModule
import br.com.entrypoint.mycinemalistyt.di.retrofitModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApp)
            modules(
                retrofitModule,
                apiModule
            )
        }
    }
}