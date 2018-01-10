package com.ooftf.straightlayout

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = Adapter()
        straightListView.setAdapter(adapter)
        //adapter.notifyDataSetChanged()
    }
    inner class Adapter:RecyclerView.Adapter<MyViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
          return  MyViewHolder(LayoutInflater.from(this@MainActivity).inflate(R.layout.item_straight_text,parent,false))
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            (holder.itemView as TextView).text = position.toString()
        }

        override fun getItemCount(): Int {
            return 25
        }


    }
    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    }
}
