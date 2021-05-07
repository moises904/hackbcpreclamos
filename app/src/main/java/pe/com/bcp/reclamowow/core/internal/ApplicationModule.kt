package pe.com.bcp.reclamowow.core.internal

import org.koin.core.module.Module
import org.koin.dsl.module
import pe.com.bcp.reclamowow.core.Navigator

val commonModule: Module = module {
    single { providerNavigator() }
}

fun providerNavigator(): Navigator {
    return Navigator()
}