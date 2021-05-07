package pe.com.bcp.reclamowow.feature.register.presentation.view

import org.koin.android.viewmodel.ext.android.viewModel
import pe.com.bcp.reclamowow.core.base.BaseFragment
import pe.com.bcp.reclamowow.core.base.BaseViewModel
import pe.com.bcp.reclamowow.databinding.FragmentRegisterBinding
import pe.com.bcp.reclamowow.feature.register.presentation.viewmodel.RegisterViewModel

class RegisterFragment : BaseFragment<FragmentRegisterBinding>() {

    private val registerViewModel:RegisterViewModel by viewModel(clazz = RegisterViewModel::class)

    override fun getViewModel(): BaseViewModel? {
        return registerViewModel
    }

    override fun setupObserversViewModel() {
    }

    override fun init() {
        bindingView.registerTextView.text = "Este es el Registro"
    }

}