package com.egci428.a10928_listview

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.egci428.a10928_listview.R

class CookieAdapter(val mContext: Context, val layoutResId: Int,
                    val messageList: ArrayList<CookieObject> ): ArrayAdapter<CookieObject>(mContext, layoutResId, messageList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater = LayoutInflater.from(mContext)
        val view = layoutInflater.inflate(layoutResId, null)
        val msgTextView = view.findViewById<TextView>(R.id.mmsg)
        var status = messageList[position].status
        if(status.equals("positive")){
            msgTextView.setTextColor(Color.BLUE)
        } else if(status.equals("negative")){
            msgTextView.setTextColor(Color.RED)
        }
        msgTextView.text = messageList[position].message
        val dateTextView = view.findViewById<TextView>(R.id.ddate)
        dateTextView.text = messageList[position].date

        return view
    }
}