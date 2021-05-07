package pe.com.bcp.reclamowow.feature.home.presentation.view

import android.content.Context
import android.database.DataSetObserver
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import pe.com.bcp.reclamowow.R

class CustomExpandableListAdapter(val context: Context?, val expandableListTitle: List<String>?,
                                                       val expandableListDetail: HashMap<String, List<String>>?):
    BaseExpandableListAdapter() {


    override fun getChild(listPosition: Int, expandedListPosition: Int): Any? {
        return expandableListDetail!![expandableListTitle!![listPosition]]?.get(expandedListPosition)
    }

    override fun getChildView(
        listPosition: Int, expandedListPosition: Int,
        isLastChild: Boolean, convertView: View?, parent: ViewGroup?
    ): View? {
        var convertView: View? = convertView
        val expandedListText =
            getChild(listPosition, expandedListPosition) as String?
        if (convertView == null) {
            val layoutInflater = context
                ?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = layoutInflater.inflate(R.layout.item_claim_title, null)
        }
        val expandedListTextView = convertView?.findViewById(R.id.descriptionClaim) as TextView
        expandedListTextView.text = expandedListText
        return convertView
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        TODO("Not yet implemented")
    }

    override fun areAllItemsEnabled(): Boolean {

    }

    override fun getChildrenCount(listPosition: Int): Int {
        return expandableListDetail!![expandableListTitle!![listPosition]]!!.size
    }

    override fun getGroup(listPosition: Int): Any? {
        return expandableListTitle!![listPosition]
    }

    override fun onGroupCollapsed(groupPosition: Int) {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override fun registerDataSetObserver(observer: DataSetObserver?) {
        TODO("Not yet implemented")
    }

    override fun getGroupCount(): Int {
        return expandableListTitle!!.size
    }

    override fun getGroupId(listPosition: Int): Long {
        return listPosition.toLong()
    }

    override fun getGroupView(
        listPosition: Int, isExpanded: Boolean,
        convertView: View?, parent: ViewGroup?
    ): View? {
        var convertView = convertView
        val listTitle = getGroup(listPosition) as String?
        if (convertView == null) {
            val layoutInflater =
                context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = layoutInflater.inflate(R.layout.item_claim_title, null)
        }
        val listTitleTextView = convertView?.findViewById<View>(R.id.title) as TextView
        listTitleTextView.setTypeface(null, Typeface.BOLD)
        listTitleTextView.text = listTitle
        return convertView
    }

    override fun unregisterDataSetObserver(observer: DataSetObserver?) {
        TODO("Not yet implemented")
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun isChildSelectable(listPosition: Int, expandedListPosition: Int): Boolean {
        return true
    }

}