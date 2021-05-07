package pe.com.bcp.reclamowow.feature.home.data.local

import android.app.Application
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import pe.com.bcp.reclamowow.feature.home.data.ClaimResponse
import pe.com.bcp.reclamowow.feature.home.data.local.mapper.MappingFrequentClaims
import pe.com.bcp.reclamowow.feature.home.domain.model.ClaimModel
import java.io.IOException

class ClaimLocalDataSource(val context: Application) {

    companion object {
        const val FILENAME_FREQUENT_CLAIMS = "FrequentClaims.json"
    }

     fun readerLocalJson(): List<ClaimModel>?  {

        val jsonString: String
        var frequentClaims: ClaimResponse? = null

        try {
            jsonString = context.assets.open(FILENAME_FREQUENT_CLAIMS).bufferedReader().use { it.readText() }
            val gson = Gson()
            val claimsResponse = object : TypeToken<ClaimResponse>() {}.type
            frequentClaims = gson.fromJson(jsonString, claimsResponse)
        } catch (ioException: IOException) {

        }
         return frequentClaims?.claims?.let {
             MappingFrequentClaims.toListClaimModel(it)
         }
    }
}


