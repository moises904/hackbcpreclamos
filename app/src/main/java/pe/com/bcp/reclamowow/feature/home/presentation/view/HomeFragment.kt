package pe.com.bcp.reclamowow.feature.home.presentation.view

import org.koin.android.viewmodel.ext.android.viewModel
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

    }


}