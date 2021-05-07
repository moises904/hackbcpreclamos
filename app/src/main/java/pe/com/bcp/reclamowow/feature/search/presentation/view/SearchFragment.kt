package pe.com.bcp.reclamowow.feature.search.presentation.view

import org.koin.android.viewmodel.ext.android.viewModel
import pe.com.bcp.reclamowow.core.base.BaseFragment
import pe.com.bcp.reclamowow.core.base.BaseViewModel
import pe.com.bcp.reclamowow.databinding.FragmentSearchBinding
import pe.com.bcp.reclamowow.feature.search.presentation.viewmodel.SearchViewModel

class SearchFragment : BaseFragment<FragmentSearchBinding>() {

    private val searchViewModel: SearchViewModel by viewModel(clazz = SearchViewModel::class)

    override fun getViewModel(): BaseViewModel? {
        return searchViewModel
    }

    override fun setupObserversViewModel() {
    }

    override fun init() {
        //bindingView.searchTextView.text = "Esta es Buscar, Filtrar"
    }


}