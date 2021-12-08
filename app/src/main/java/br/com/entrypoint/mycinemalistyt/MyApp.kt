package br.com.entrypoint.mycinemalistyt

import android.app.Application
import br.com.entrypoint.mycinemalistyt.di.apiModule
import br.com.entrypoint.mycinemalistyt.di.retrofitModule
import br.com.entrypoint.mycinemalistyt.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApp)
            modules(
                retrofitModule,
                apiModule,
                viewModelModule
            )
        }
    }
}