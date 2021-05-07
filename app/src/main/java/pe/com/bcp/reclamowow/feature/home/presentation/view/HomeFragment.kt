package pe.com.bcp.reclamowow.feature.home.presentation.view

import android.util.Log
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.android.viewmodel.ext.android.viewModel
import pe.com.bcp.reclamowow.R
import pe.com.bcp.reclamowow.core.base.BaseFragment
import pe.com.bcp.reclamowow.core.base.BaseViewModel
import pe.com.bcp.reclamowow.databinding.FragmentHomeBinding
import pe.com.bcp.reclamowow.feature.home.domain.model.ClaimModel
import pe.com.bcp.reclamowow.feature.home.presentation.viewmodel.HomeViewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val homeViewModel: HomeViewModel by viewModel(clazz = HomeViewModel::class)
    private var expandedSize =  ArrayList<Int>()
    private var lstClaims = ArrayList<ClaimModel> ()
    private lateinit var adapter: RVAdapter

    override fun getViewModel(): BaseViewModel? {
        return homeViewModel
    }

    override fun setupObserversViewModel() {
        homeViewModel.lstClaims.observe(this) {lstClaims ->
            Log.i("DATAFRAGMENT",lstClaims.toString())
            this.lstClaims = lstClaims as ArrayList<ClaimModel>
            loadFrequentClaims(lstClaims)
        }
    }

    override fun init() {

        adapter = RVAdapter(lstClaims, expandedSize)
        bindingView.rvClaims.adapter = this.adapter
        homeViewModel.getFrequentClaims()

        bindingView.cardView5.setOnClickListener {
            goToRegister()
        }

        bindingView.cardView3.setOnClickListener {
            goToSearch()
        }

    }

    private fun goToRegister() {
        findNavController().navigate(R.id.action_homeFragment_to_registerFragment)
    }

    private fun goToSearch() {
        findNavController().navigate(R.id.action_homeFragment_to_searchFragment)
    }

    private fun loadFrequentClaims(claims: List<ClaimModel>) {


         bindingView.rvClaims.setHasFixedSize(true)
         bindingView.rvClaims.layoutManager =  LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
         setCellSize()

        bindingView.rvClaims.adapter = RVAdapter(claims as ArrayList<ClaimModel>,expandedSize)
    }

    private fun setCellSize() {
        expandedSize = ArrayList()
        for (i in 0 until lstClaims.count()) {
            expandedSize.add(0)
        }
    }
}