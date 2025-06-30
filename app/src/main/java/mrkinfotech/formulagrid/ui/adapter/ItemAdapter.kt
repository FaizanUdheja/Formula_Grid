package mrkinfotech.formulagrid.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import mrkinfotech.formulagrid.R
import mrkinfotech.formulagrid.databinding.ItemViewBinding
import mrkinfotech.formulagrid.ui.data.ModelClass

class ItemAdapter(
    val context: Context,
    private var itemList: ArrayList<ModelClass>,
    private val onClickListener: OnClickListener
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(itemList[position], onClickListener)
    }

    override fun getItemCount(): Int = itemList.size

    class OnClickListener(val clickListener: (itemData: ModelClass, clickType: Int) -> Unit) {
        fun onClick(itemData: ModelClass, clickType: Int) = clickListener(itemData, clickType)
    }

    inner class ItemViewHolder(private val binding: ItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(dataModal: ModelClass, onClickListener: OnClickListener) {
            binding.Round.text = dataModal.round
            binding.gpName.text = dataModal.country_name
            binding.gpDesc.text = dataModal.description

            Glide.with(context)
                .load(dataModal.flag)
                .placeholder(R.drawable.ic_app_logo)
                .into(binding.imageView)

        }
    }
}