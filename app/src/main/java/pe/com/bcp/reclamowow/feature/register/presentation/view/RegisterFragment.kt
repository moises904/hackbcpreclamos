package pe.com.bcp.reclamowow.feature.register.presentation.view

import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import org.koin.android.viewmodel.ext.android.viewModel
import pe.com.bcp.reclamowow.core.base.BaseFragment
import pe.com.bcp.reclamowow.core.base.BaseViewModel
import pe.com.bcp.reclamowow.databinding.FragmentRegisterBinding
import pe.com.bcp.reclamowow.feature.register.domain.model.NewClaimModel
import pe.com.bcp.reclamowow.feature.register.domain.model.RegisterSuccessModel
import pe.com.bcp.reclamowow.feature.register.presentation.viewmodel.RegisterViewModel

class RegisterFragment : BaseFragment<FragmentRegisterBinding>() {

    private val registerViewModel:RegisterViewModel by viewModel(clazz = RegisterViewModel::class)

    override fun getViewModel(): BaseViewModel? {
        return registerViewModel
    }

    override fun setupObserversViewModel() {
        registerViewModel.claimLiveData.observe(this){ claim->
            goToSuccessScreen(claim)
        }
    }

    override fun init() {

        bindingView.registerClaimButton.setOnClickListener {
            registerNewClaim()
        }
    }

    private fun registerNewClaim() {

        val newClaim = NewClaimModel(1, "78651234","" +
                                     "986633362","07/05/2021","moises@gmail.com")
        registerViewModel.registerNewClaim(newClaim)

    }

    private fun goToSuccessScreen(successModel: RegisterSuccessModel) {
        val navigation = RegisterFragmentDirections.actionRegisterFragmentToRegisterSuccessFragment(successModel)
        findNavController().navigate(navigation)
    }
}