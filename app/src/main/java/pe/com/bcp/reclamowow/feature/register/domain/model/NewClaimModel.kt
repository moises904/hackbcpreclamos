package pe.com.bcp.reclamowow.feature.register.domain.model

data class NewClaimModel(val typeDocument:Int, val numberDocument:String,
                         val phoneNumber:String, val email:String, val dateStart: String)