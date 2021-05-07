package pe.com.bcp.reclamowow.feature.register.module

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import pe.com.bcp.reclamowow.feature.register.data.RegisterRepository
import pe.com.bcp.reclamowow.feature.register.domain.IRegisterRepository
import pe.com.bcp.reclamowow.feature.register.domain.usecase.RegisterUseCase
import pe.com.bcp.reclamowow.feature.register.presentation.viewmodel.RegisterViewModel

val registerModule: Module = module {

    viewModel { RegisterViewModel(get(), get()) }

    single { providerRegisterUseCase(get()) }

    single<IRegisterRepository> { providerRegisterRepository() }

}

fun providerRegisterUseCase(iRegisterRepository: IRegisterRepository): RegisterUseCase = RegisterUseCase(iRegisterRepository)

fun providerRegisterRepository() = RegisterRepository()