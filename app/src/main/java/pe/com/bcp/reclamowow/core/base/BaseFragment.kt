package pe.com.bcp.reclamowow.core.base

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import org.koin.android.ext.android.inject
import pe.com.bcp.reclamowow.core.Navigator
import java.lang.reflect.ParameterizedType


abstract class BaseFragment<T : ViewBinding> : Fragment(){

    lateinit var bindingView: T
    private var mLastClickTime: Long = 0
    private var activity: BaseActivity<*>? = null
    protected val navigator: Navigator by inject()

    protected var TAG_SCREEN: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupObserversViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        val type = javaClass.genericSuperclass as ParameterizedType
        val clazz = type.actualTypeArguments[0] as Class<*>
        val method = clazz.getMethod(
            "inflate",
            LayoutInflater::class.java,
            ViewGroup::class.java,
            Boolean::class.java
        )
        bindingView = method.invoke(null, layoutInflater, container, false) as T
        TAG_SCREEN = "["+javaClass.simpleName+"]"
        Log.i("SCREEN", "*********************")
        Log.i("SCREEN", TAG_SCREEN!!)
        Log.i("SCREEN", "*********************")

        return bindingView.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity = context as BaseActivity<*>
    }

    override fun onDetach() {
        super.onDetach()
        activity = null
    }

    abstract fun getViewModel(): BaseViewModel?

    abstract fun setupObserversViewModel()

    abstract fun init()

    protected open fun hideKeyboard() {
        val view: View? = requireActivity().getCurrentFocus()
        if (view != null) {
            val imm: InputMethodManager = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }



    fun View.setEnabledRecursively(enabled: Boolean) {
        isEnabled = enabled
        if (this is ViewGroup)
            (0 until childCount).map(::getChildAt).forEach { it.setEnabledRecursively(enabled) }
    }



    protected open fun getBaseActivity(): BaseActivity<*>? {
        return activity
    }





}
