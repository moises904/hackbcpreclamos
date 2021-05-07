package pe.com.bcp.reclamowow.feature.home.data.repositories

import android.app.Application
import pe.com.bcp.reclamowow.core.base.Response
import pe.com.bcp.reclamowow.feature.home.data.local.ClaimLocalDataSource
import pe.com.bcp.reclamowow.feature.home.domain.model.ClaimModel
import pe.com.bcp.reclamowow.feature.home.domain.repository.IFrequentClaimsRepository

class FrequentClaimsRepository(val context: Application, val claimLocalDataSource: ClaimLocalDataSource): IFrequentClaimsRepository {

    override fun frequentClaims(): Response<List<ClaimModel>?> {
        val cliemsModel = claimLocalDataSource.readerLocalJson()
        return Response.Success(cliemsModel)
    }

}