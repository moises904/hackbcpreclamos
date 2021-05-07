package pe.com.bcp.reclamowow.feature.home.domain.repository

import pe.com.bcp.reclamowow.core.base.Response
import pe.com.bcp.reclamowow.feature.home.domain.model.ClaimModel

interface IFrequentClaimsRepository {
    fun frequentClaims() : Response<List<ClaimModel>?>
}
