package org.firebase.crud.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amulyakhare.textdrawable.util.ColorGenerator
import org.firebase.crud.adapter.MainAdapter;
import com.azhar.firebasecrud.holder.MainViewHolder
import org.firebase.crud.model.ModelBarang;
import org.firebase.crud.R
import java.util.*
import org.firebase.crud.activities.MainActivity
class MainAdapter(private val context: Context,
                  private val daftarBarang: ArrayList<ModelBarang?>?) : RecyclerView.Adapter<MainViewHolder>() {
    private val listener: FirebaseDataListener
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_barang, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val generator = ColorGenerator.MATERIAL //custom color
        val color = generator.randomColor
        holder.view.setCardBackgroundColor(color)
        holder.namaBarang.text = "Nama   : " + (daftarBarang?.get(position)?.nama)
        holder.merkBarang.text = "Merk     : " + daftarBarang?.get(position)?.merk
        holder.hargaBarang.text = "Harga   : " + daftarBarang?.get(position)?.harga
        holder.view.setOnClickListener { listener.onDataClick(daftarBarang?.get(position), position) }
    }

    override fun getItemCount(): Int {

        return daftarBarang?.size!!
    }

    //interface data listener
    interface FirebaseDataListener {
        fun onDataClick(barang: ModelBarang?, position: Int)
    }

    init {
        listener = context as FirebaseDataListener
    }
}