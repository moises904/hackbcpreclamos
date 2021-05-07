package pe.com.bcp.reclamowow.feature.register.presentation.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pe.com.bcp.reclamowow.core.base.BaseViewModel
import pe.com.bcp.reclamowow.core.base.Response
import pe.com.bcp.reclamowow.feature.home.domain.model.ClaimModel
import pe.com.bcp.reclamowow.feature.register.domain.model.NewClaimModel
import pe.com.bcp.reclamowow.feature.register.domain.model.RegisterSuccessModel
import pe.com.bcp.reclamowow.feature.register.domain.usecase.RegisterUseCase

class RegisterViewModel(val context:Application,
                        val registerUseCase: RegisterUseCase): BaseViewModel(context) {

    private val mutableLiveDataClaim = MutableLiveData<RegisterSuccessModel>()
    val claimLiveData: LiveData<RegisterSuccessModel> get() = mutableLiveDataClaim

    fun registerNewClaim(newClaimModel: NewClaimModel) {

        registerUseCase.bind(newClaimModel)

        viewModelScope.launch {
            val result = registerUseCase.execute()

            when(result) {
                is Response.Success<*> -> {
                    mutableLiveDataClaim.value = result.successData as RegisterSuccessModel
                    Log.i("VM-SUCCESS", result.successData.toString())

                }

                is Response.Failure<*> -> {
                    Log.i("VM-ERROR", result.errorData.toString())
                }
            }
        }
    }
}