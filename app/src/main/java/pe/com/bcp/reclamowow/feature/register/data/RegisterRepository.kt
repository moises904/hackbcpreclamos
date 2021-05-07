package pe.com.bcp.reclamowow.feature.register.data

import pe.com.bcp.reclamowow.core.base.Response
import pe.com.bcp.reclamowow.feature.register.domain.IRegisterRepository
import pe.com.bcp.reclamowow.feature.register.domain.model.NewClaimModel
import pe.com.bcp.reclamowow.feature.register.domain.model.RegisterSuccessModel

class RegisterRepository: IRegisterRepository {

    override fun registerNewClaims(newClaimModel: NewClaimModel): Response<RegisterSuccessModel?>?{
        return Response.Success(RegisterSuccessModel("423423","20/05/2021"))
    }

}