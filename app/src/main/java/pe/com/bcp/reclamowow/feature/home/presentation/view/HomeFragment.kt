package pe.com.bcp.reclamowow.feature.home.presentation.view

import android.util.Log
import android.widget.ListAdapter
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import org.koin.android.viewmodel.ext.android.viewModel
import pe.com.bcp.reclamowow.R
import pe.com.bcp.reclamowow.core.base.BaseFragment
import pe.com.bcp.reclamowow.core.base.BaseViewModel
import pe.com.bcp.reclamowow.databinding.FragmentHomeBinding
import pe.com.bcp.reclamowow.feature.home.domain.model.ClaimModel
import pe.com.bcp.reclamowow.feature.home.presentation.viewmodel.HomeViewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val homeViewModel: HomeViewModel by viewModel(clazz = HomeViewModel::class)

    override fun getViewModel(): BaseViewModel? {
        return homeViewModel
    }

    override fun setupObserversViewModel() {
        homeViewModel.lstClaims.observe(this) {lstClaims ->
            Log.i("DATAFRAGMENT",lstClaims.toString())
            loadFrequentClaims(lstClaims)
        }
    }

    override fun init() {
        homeViewModel.getFrequentClaims()



        bindingView.btnRegister.setOnClickListener { goToRegister() }

        bindingView.btnSearch.setOnClickListener { goToSearch() }

    }

    private fun goToRegister() {
        findNavController().navigate(R.id.action_homeFragment_to_registerFragment)
    }

    private fun goToSearch() {
        findNavController().navigate(R.id.action_homeFragment_to_searchFragment)
    }

    private fun loadFrequentClaims(claims: List<ClaimModel>) {

        var lstTitles = ArrayList<String> ()
        var detailsHashMap = HashMap<String, List<String>> ()
        for(claim in claims) {

            claim.type?.let {
                lstTitles.add(it)
                detailsHashMap.put(it, lstTitles)

            }
        }

        val customExpandableListAdapter = CustomExpandableListAdapter(requireContext(),lstTitles, detailsHashMap)
         //bindingView.expandableFrequentClaims.adapter = customExpandableListAdapter
    }

}