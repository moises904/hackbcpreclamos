package pe.com.bcp.reclamowow

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import pe.com.bcp.reclamowow.core.internal.commonModule
import pe.com.bcp.reclamowow.feature.home.module.homeModule
import pe.com.bcp.reclamowow.feature.register.module.registerModule

class ReclamoWowApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.INFO)
            androidContext(this@ReclamoWowApplication)
            koin.loadModules(listOf(commonModule, homeModule, registerModule))

            koin.createRootScope()
        }
    }
}