package pe.com.bcp.reclamowow.feature.search.presentation.view

import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import org.koin.android.viewmodel.ext.android.viewModel
import pe.com.bcp.reclamowow.common.Constants
import pe.com.bcp.reclamowow.core.base.BaseFragment
import pe.com.bcp.reclamowow.core.base.BaseViewModel
import pe.com.bcp.reclamowow.databinding.FragmentSearchBinding
import pe.com.bcp.reclamowow.feature.register.domain.model.RegisterSuccessModel
import pe.com.bcp.reclamowow.feature.search.presentation.viewmodel.SearchViewModel


class SearchFragment : BaseFragment<FragmentSearchBinding>() {

    private val searchViewModel: SearchViewModel by viewModel(clazz = SearchViewModel::class)

    override fun getViewModel(): BaseViewModel? {
        return searchViewModel
    }

    override fun setupObserversViewModel() {

    }

    override fun init() {
        val typeDocumentArrayAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, Constants.typeDocumentos)
        bindingView.spinnerTypeDocument.adapter = typeDocumentArrayAdapter

        bindingView.registerClaimButton3.setOnClickListener {
            goToSuccess()
        }

    }

    private fun goToSuccess() {
        val navigate = SearchFragmentDirections.actionSearchFragmentToRegisterSuccessFragment(
            RegisterSuccessModel(codeClaim = "001231",dateEnd = "20/20/2021")
        )
        findNavController().navigate(navigate)
    }

}