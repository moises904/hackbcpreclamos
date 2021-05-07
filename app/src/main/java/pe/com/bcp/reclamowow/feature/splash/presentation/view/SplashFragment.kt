package pe.com.bcp.reclamowow.feature.splash.presentation.view

import android.content.Intent
import kotlinx.coroutines.*
import org.koin.android.viewmodel.ext.android.viewModel
import pe.com.bcp.reclamowow.core.base.BaseFragment
import pe.com.bcp.reclamowow.core.base.BaseViewModel
import pe.com.bcp.reclamowow.databinding.FragmentSplashBinding
import pe.com.bcp.reclamowow.feature.home.presentation.view.HomeActivity
import pe.com.bcp.reclamowow.feature.splash.presentation.viewmodel.SplashViewModel

class SplashFragment : BaseFragment<FragmentSplashBinding>() {

    private val splashViewModel: SplashViewModel by viewModel(clazz = SplashViewModel::class)

    override fun getViewModel(): BaseViewModel? {
        return splashViewModel
    }

    override fun setupObserversViewModel() {
    }

    override fun init() {
        bindingView.greatTextView.text = "Hackaton grupo 3"
        startSplash()
    }

    private fun startSplash() {
        CoroutineScope(Dispatchers.IO).launch {
            delay(1000L)
            withContext(Dispatchers.Main) {
                goToHome()
            }
        }
    }

    private fun goToHome() {

        val intentHome = Intent(requireActivity(), HomeActivity::class.java)
        startActivity(intentHome)
        requireActivity().finish()

    }
}