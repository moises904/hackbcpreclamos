package pe.com.bcp.reclamowow.feature.home.presentation.view

import androidx.navigation.fragment.findNavController
import org.koin.android.viewmodel.ext.android.viewModel
import pe.com.bcp.reclamowow.R
import pe.com.bcp.reclamowow.core.base.BaseFragment
import pe.com.bcp.reclamowow.core.base.BaseViewModel
import pe.com.bcp.reclamowow.databinding.FragmentHomeBinding
import pe.com.bcp.reclamowow.feature.home.presentation.viewmodel.HomeViewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val homeViewModel: HomeViewModel by viewModel(clazz = HomeViewModel::class)

    override fun getViewModel(): BaseViewModel? {
        return homeViewModel
    }

    override fun setupObserversViewModel() {

    }

    override fun init() {

        bindingView.homeTextView.text = "Este es el Home"

        bindingView.btnRegister.setOnClickListener { goToRegister() }

        bindingView.btnSearch.setOnClickListener { goToSearch() }

    }

    private fun goToRegister() {
        findNavController().navigate(R.id.action_homeFragment_to_registerFragment)
    }

    private fun goToSearch() {
        findNavController().navigate(R.id.action_homeFragment_to_searchFragment)
    }

}