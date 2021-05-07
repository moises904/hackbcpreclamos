package pe.com.bcp.reclamowow.feature.home.data

import com.google.gson.annotations.SerializedName

class ClaimResponse {

    @SerializedName("claims")
    val claims:List<Claim>? = null

    class Claim {
        @SerializedName("type")
        val type: String? = null

        @SerializedName("description")
        val description: String? = null

    }

}