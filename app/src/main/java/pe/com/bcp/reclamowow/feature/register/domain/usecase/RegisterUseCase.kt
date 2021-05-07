package pe.com.bcp.reclamowow.feature.register.domain.usecase

import pe.com.bcp.reclamowow.core.base.BaseUseCase
import pe.com.bcp.reclamowow.core.base.Response
import pe.com.bcp.reclamowow.feature.register.domain.IRegisterRepository
import pe.com.bcp.reclamowow.feature.register.domain.model.NewClaimModel
import pe.com.bcp.reclamowow.feature.register.domain.model.RegisterSuccessModel

class RegisterUseCase(val iRegisterRepository: IRegisterRepository): BaseUseCase<Response<RegisterSuccessModel?>?>() {

    var newClaimModel: NewClaimModel? = null

    fun bind(newClaimModel: NewClaimModel) {
        this.newClaimModel = newClaimModel
    }

    override suspend fun execute(): Response<RegisterSuccessModel?>? {
        return newClaimModel?.let { iRegisterRepository.registerNewClaims(it) }
    }
}