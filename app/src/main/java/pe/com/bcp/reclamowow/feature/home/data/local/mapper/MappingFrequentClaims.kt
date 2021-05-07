package pe.com.bcp.reclamowow.feature.home.data.local.mapper

import pe.com.bcp.reclamowow.feature.home.data.ClaimResponse
import pe.com.bcp.reclamowow.feature.home.domain.model.ClaimModel

object MappingFrequentClaims {

    fun toClaimModel(claimReponse: ClaimResponse.Claim): ClaimModel {
        return ClaimModel(claimReponse.type, claimReponse.description)
    }

    fun toListClaimModel(lstClaimReponse: List<ClaimResponse.Claim>):List<ClaimModel>? {

        var lstClaimModel = ArrayList<ClaimModel>()
        for(claimResponse in lstClaimReponse) {
            val claimModel = toClaimModel(claimResponse)
            lstClaimModel.add(claimModel)
        }
        return lstClaimModel
    }
}