package pe.com.bcp.reclamowow.feature.home.module

import android.app.Application
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import pe.com.bcp.reclamowow.feature.home.data.local.ClaimLocalDataSource
import pe.com.bcp.reclamowow.feature.home.data.repositories.FrequentClaimsRepository
import pe.com.bcp.reclamowow.feature.home.domain.repository.IFrequentClaimsRepository
import pe.com.bcp.reclamowow.feature.home.domain.usecase.FrequentClaimsUseCase
import pe.com.bcp.reclamowow.feature.home.presentation.viewmodel.HomeViewModel

val homeModule : Module = module {

    viewModel { HomeViewModel(get(), get()) }

    single { providerFrequentClaimsUseCase(get()) }

    single<IFrequentClaimsRepository> { providerFrequentClaimsRepository(get(), get()) }

    single { providerClaimLocalDataSource(get())}

}

fun providerFrequentClaimsUseCase(iFrequentClaimsRepository: IFrequentClaimsRepository): FrequentClaimsUseCase {
    return FrequentClaimsUseCase(iFrequentClaimsRepository)
}

fun providerFrequentClaimsRepository(context:Application,
                                     claimLocalDataSource: ClaimLocalDataSource) : FrequentClaimsRepository = FrequentClaimsRepository(context, claimLocalDataSource)

fun providerClaimLocalDataSource(context: Application): ClaimLocalDataSource {
    return ClaimLocalDataSource(context)
}