package pe.com.bcp.reclamowow.feature.register.domain

import pe.com.bcp.reclamowow.core.base.Response
import pe.com.bcp.reclamowow.feature.register.domain.model.NewClaimModel
import pe.com.bcp.reclamowow.feature.register.domain.model.RegisterSuccessModel

interface IRegisterRepository {
  fun registerNewClaims(newClaimModel: NewClaimModel): Response<RegisterSuccessModel?>?
}