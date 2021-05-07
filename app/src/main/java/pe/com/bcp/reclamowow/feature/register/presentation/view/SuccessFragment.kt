package pe.com.bcp.reclamowow.feature.register.presentation.view

import androidx.navigation.fragment.navArgs
import org.koin.android.viewmodel.ext.android.viewModel
import pe.com.bcp.reclamowow.core.base.BaseFragment
import pe.com.bcp.reclamowow.core.base.BaseViewModel
import pe.com.bcp.reclamowow.databinding.FragmentRegisterSuccessBinding
import pe.com.bcp.reclamowow.feature.register.presentation.viewmodel.RegisterViewModel

class RegisterSuccessFragment : BaseFragment<FragmentRegisterSuccessBinding>() {

    private val registerViewModel: RegisterViewModel by viewModel(clazz = RegisterViewModel::class)
    private val arguments: RegisterSuccessFragmentArgs by navArgs()

    override fun getViewModel(): BaseViewModel? {
        return registerViewModel
    }

    override fun setupObserversViewModel() {

    }

    override fun init() {
        bindingView.txtComplaintId.text = "Reclamo "+arguments.resultRegisterModel.codeClaim
    }
}