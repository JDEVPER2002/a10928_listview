package com.egci428.a10140_listview

import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.ListView
import androidx.appcompat.widget.Toolbar
import okhttp3.Cookie

class MainActivity : AppCompatActivity() {

    //run the onCreate once
    //after that back onResume
    lateinit var array:ArrayList<CookieObject>
    lateinit var adapter:CookieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listView = findViewById<ListView>(R.id.listView)
        val toolBar = findViewById<Toolbar>(R.id.toolBar)

        toolBar.setTitle("Fortune Cookies")
        setSupportActionBar(toolBar)
        val addButton = findViewById<ImageButton>(R.id.addButton)

        addButton.setOnClickListener {
            val intent = Intent(this,DetailActivity::class.java)
            startActivityForResult(intent,1)
        }
        Log.d("RESULT","BACK TO MAIN")
        array = ArrayList()
        adapter = CookieAdapter(applicationContext,R.layout.detail,array)
        listView.adapter = adapter

        listView.setOnItemClickListener { adapterView, view, position, id ->
            array.removeAt(position)
            adapter.notifyDataSetChanged()
        }
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode==1){
            var msg = data?.getStringExtra("msg").toString()
            var status = data?.getStringExtra("status").toString()
            var date =data?.getStringExtra("date").toString()
            array.add(CookieObject(msg,status,date))
            adapter.notifyDataSetChanged()
        }


        }

    }


