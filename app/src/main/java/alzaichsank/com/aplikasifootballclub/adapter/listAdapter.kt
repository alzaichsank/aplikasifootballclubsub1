package alzaichsank.com.aplikasifootballclub.adapter

import alzaichsank.com.aplikasifootballclub.ankoUI.ankoUi
import alzaichsank.com.aplikasifootballclub.item.ItemData
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.extensions.LayoutContainer
import org.jetbrains.anko.AnkoContext

class listAdapter(val items: List<ItemData>, val listener: (ItemData) -> Unit) : RecyclerView.Adapter<listAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(ankoUi().createView(AnkoContext.Companion.create(parent.context, parent)))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position], listener)
    }

    inner class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {
        val image = itemView.findViewById<ImageView>(ankoUi.anko_image)
        val name = itemView.findViewById<TextView>(ankoUi.anko_name)
        val layout = itemView.findViewById<LinearLayout>(ankoUi.anko_layout)

        fun bind(item: ItemData, listener: (ItemData) -> Unit) {
            Glide.with(itemView.context)
                    .load(item.image)
                    .into(image)

            name.text = item.name

            layout.setOnClickListener { listener(item) }
        }
    }
}