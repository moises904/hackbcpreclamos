package pe.com.bcp.reclamowow.feature.home.domain.usecase

import pe.com.bcp.reclamowow.core.base.BaseUseCase
import pe.com.bcp.reclamowow.core.base.Response
import pe.com.bcp.reclamowow.feature.home.domain.model.ClaimModel
import pe.com.bcp.reclamowow.feature.home.domain.repository.IFrequentClaimsRepository

class FrequentClaimsUseCase (private val iFrequentClaimsRepository: IFrequentClaimsRepository): BaseUseCase<Response<List<ClaimModel>?>>() {

    override suspend fun execute(): Response<List<ClaimModel>?> {
        return iFrequentClaimsRepository.frequentClaims()
    }

}