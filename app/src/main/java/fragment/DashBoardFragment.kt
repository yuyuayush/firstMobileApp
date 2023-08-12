package fragment

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.booklearn.R
import com.example.booklearn.adapter.DashboardRecyclerAdapter
import model.Book
import utiils.connectionManager


class DashBoardFragment : Fragment() {
//    recycler dahboar inside the fragment
    lateinit var btn:Button
    lateinit var recyclerDashBoard: RecyclerView
    lateinit var recyclerAdapter: DashboardRecyclerAdapter
//    layout manager btna parta h kaise layout bnana h;
//    fir use usse link kr dege;
    lateinit var layoutManager:RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_dash_board, container, false)
        recyclerDashBoard = view.findViewById(R.id.recyclerDashboard)

        btn = view.findViewById(R.id.btnCheckInternet)
        btn.setOnClickListener {
            if (connectionManager().checkConnectivity(activity as Context)) {
                val dialog = AlertDialog.Builder(activity as Context)
                dialog.setTitle("Success")
                dialog.setMessage("Internet Connection Found")
                dialog.setPositiveButton("ok") { text, listener ->

                }
                dialog.setNegativeButton("cancel") { text, listener ->

                }
                dialog.create()
                dialog.show()
            } else {
                val dialog = AlertDialog.Builder(activity as Context)
                dialog.setTitle("Error")
                dialog.setMessage("Internet Connection is not Found")
                dialog.setPositiveButton("ok") { text, listener -> }

                dialog.setNegativeButton("cancel") { text, listener ->
                }
                dialog.create();
                dialog.show()
            }
        }
        layoutManager = LinearLayoutManager(activity)
        val

                bookList = arrayListOf(
            "p.s Ilobe",
            "ganign",
            "ranin gs",
            "sdgs",
            "sfjdslf" ,
        "p.s Ilobe",
            "ganign",
            "ranin gs",
            "sdgs",
            "sfjdslf")

        val bookInfoList = arrayListOf<Book>(
            Book("P.S. I love You", "Cecelia Ahern", "Rs. 299", "4.5", R.drawable.ps_ily),
            Book("The Great Gatsby", "F. Scott Fitzgerald", "Rs. 399", "4.1", R.drawable.great_gatsby),
            Book("Anna Karenina", "Leo Tolstoy", "Rs. 199", "4.3", R.drawable.anna_kare),
            Book("Madame Bovary", "Gustave Flaubert", "Rs. 500", "4.0", R.drawable.madame),
            Book("War and Peace", "Leo Tolstoy", "Rs. 249", "4.8", R.drawable.war_and_peace),
            Book("Lolita", "Vladimir Nabokov", "Rs. 349", "3.9", R.drawable.lolita),
            Book("Middlemarch", "George Eliot", "Rs. 599", "4.2", R.drawable.middlemarch),
            Book("The Adventures of Huckleberry Finn", "Mark Twain", "Rs. 699", "4.5", R.drawable.adventures_finn),
            Book("Moby-Dick", "Herman Melville", "Rs. 499", "4.5", R.drawable.moby_dick),
            Book("The Lord of the Rings", "J.R.R Tolkien", "Rs. 749", "5.0", R.drawable.lord_of_rings)
        )
        recyclerAdapter = DashboardRecyclerAdapter(activity as Context,bookInfoList)
       recyclerDashBoard.adapter = recyclerAdapter
        recyclerDashBoard.layoutManager=layoutManager
        recyclerDashBoard.addItemDecoration(
            DividerItemDecoration(
                recyclerDashBoard.context,
                (layoutManager as LinearLayoutManager).orientation
            )
        )
        return view
    }

}