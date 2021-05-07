package pe.com.bcp.reclamowow.feature.home.presentation.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import pe.com.bcp.reclamowow.core.base.BaseViewModel
import pe.com.bcp.reclamowow.core.base.Response
import pe.com.bcp.reclamowow.feature.home.domain.model.ClaimModel
import pe.com.bcp.reclamowow.feature.home.domain.usecase.FrequentClaimsUseCase

class HomeViewModel(private val context: Application,
                    private val frequetClaimsUseCase: FrequentClaimsUseCase ) : BaseViewModel(context), KoinComponent {

    private val mutableLiveDataClaims = MutableLiveData<List<ClaimModel>>()
    val lstClaims: LiveData<List<ClaimModel>> get() = mutableLiveDataClaims

     fun getFrequentClaims() {

         viewModelScope.launch {
            val result = frequetClaimsUseCase.execute()

            when(result) {
             is Response.Success<*> -> {
                 mutableLiveDataClaims.value = result.successData as List<ClaimModel>?
             }

             is Response.Failure<*> -> {
                 Log.i("Error", result.errorData.toString())
             }
            }
         }

    }

}