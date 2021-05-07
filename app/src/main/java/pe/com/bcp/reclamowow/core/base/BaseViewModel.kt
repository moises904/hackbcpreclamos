package pe.com.bcp.reclamowow.core.base

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel(private val context: Context) : ViewModel() {

    val mutableConecction    = MutableLiveData<Boolean>()
    var mutableLoading       = MutableLiveData<Boolean>()
    var mutableThrowables    = MutableLiveData<Throwable?>()


}