package pe.com.bcp.reclamowow.feature.home.presentation.view

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Typeface
import android.os.Build
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.*
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_claim_title_description.view.*
import pe.com.bcp.reclamowow.R
import pe.com.bcp.reclamowow.feature.home.domain.model.ClaimModel

class RVAdapter(private val itemsCells: ArrayList<ClaimModel>, private val expandedSize: ArrayList<Int>) : RecyclerView.Adapter<RVAdapter.ViewHolder>() {

    private lateinit var context: Context

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_claim_title_description, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return itemsCells.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Add data to cells
        holder.itemView.titleClaim.text = itemsCells[position].type
        holder.itemView.description2Claim.text = itemsCells[position].description
        holder.itemView.description2Claim.layoutParams.height = expandedSize[position]

        holder.itemView.titleClaim.setOnClickListener {
            if (expandedSize[position] == 0) {
                // Calculate the height of the Answer Text
                val answerTextViewHeight = height(context, itemsCells[position].description!!, Typeface.DEFAULT, 16, dp2px(15f, context))
                changeViewSizeWithAnimation(holder.itemView.description2Claim, answerTextViewHeight, 300L)
                expandedSize[position] = answerTextViewHeight
            } else {
                changeViewSizeWithAnimation(holder.itemView.description2Claim, 0, 300L)
                expandedSize[position] = 0
            }
        }
    }

    private fun changeViewSizeWithAnimation(view: View, viewSize: Int, duration: Long) {
        val startViewSize = view.measuredHeight
        val endViewSize: Int =
            if (viewSize < startViewSize) (viewSize) else (view.measuredHeight + viewSize)
        val valueAnimator =
            ValueAnimator.ofInt(startViewSize, endViewSize)
        valueAnimator.duration = duration
        valueAnimator.addUpdateListener {
            val animatedValue = valueAnimator.animatedValue as Int
            val layoutParams = view.layoutParams
            layoutParams.height = animatedValue
            view.layoutParams = layoutParams
        }
        valueAnimator.start()
    }

    private fun height(context: Context, text: String, typeface: Typeface?, textSize: Int, padding: Int): Int {
        val textView = TextView(context)
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize.toFloat())
        textView.setPadding(padding, padding, padding, padding)
        textView.typeface = typeface
        textView.text = text
        val mMeasureSpecWidth =
            View.MeasureSpec.makeMeasureSpec(getDeviceWidth(context), View.MeasureSpec.AT_MOST)
        val mMeasureSpecHeight = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
        textView.measure(mMeasureSpecWidth, mMeasureSpecHeight)
        return textView.measuredHeight
    }

    private fun dp2px(dpValue: Float, context: Context): Int {
        val scale = context.resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }

    private fun getDeviceWidth(context: Context): Int {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val displayMetrics = DisplayMetrics()
            val display: Display? = context.display
            display?.getRealMetrics(displayMetrics)
            displayMetrics.widthPixels
        } else {
            val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val displayMetrics = DisplayMetrics()
            wm.defaultDisplay.getMetrics(displayMetrics)
            displayMetrics.widthPixels
        }
    }

}