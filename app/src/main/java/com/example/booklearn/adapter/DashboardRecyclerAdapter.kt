package com.example.booklearn.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
//import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.booklearn.R
import model.Book


class DashboardRecyclerAdapter(val context:Context,val itemList:ArrayList<Book>):RecyclerView.Adapter<DashboardRecyclerAdapter.DashboardViewHolder>() {
// adapter ko  recycler view adaoter
//    then we combine adapter view or recycler view holder sath m ho jyge;
//adapter k andr ata h recycler view holder tb to combine krna parega

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        //list k kisi ek file ko inflate krege fir return karege ;
//        mtlb list item k item ko inflatem krege ;
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_dashboard_single_row,parent,false)
        return DashboardViewHolder(view)
    }

//    adapter k andr view holder hota h h;
//    view holder used to hold data and show data;
//     matlb hum usse dynamical value dege page ko diff diff sirf ek page ko
//    use multi time display krega v




    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        val book = itemList[position]
        holder.txtBookName.text = book.bookName
        holder.txtBookAuthor.text = book.bookAuthor
        holder.txtBookPrice.text = book.bookCost
        holder.txtBookRating.text = book.bookRating
        holder.imgBookImage.setImageResource(book.bookImage)
        holder.llContext.setOnClickListener{
            Toast.makeText(context,"clicked on ${holder.txtBookName.text}",Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int {
       return itemList.size
    }
    class DashboardViewHolder(view:View):RecyclerView.ViewHolder(view) {
        //viewholder k andr view hoga jo usse hold krega ;
//     view hamre single line view hoga hamra;
       val txtBookName:TextView =view.findViewById(R.id.txtBookName)
       val txtBookAuthor:TextView =view.findViewById(R.id.txtBookAuthor)
       val txtBookPrice:TextView =view.findViewById(R.id.txtBookPrice)
       val txtBookRating:TextView =view.findViewById(R.id.txtBookRating)
       val imgBookImage: ImageView =view.findViewById(R.id.imgBookImage)
       val llContext: LinearLayout =view.findViewById(R.id.llContent)
    }

}
