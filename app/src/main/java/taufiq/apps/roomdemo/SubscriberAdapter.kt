package taufiq.apps.roomdemo

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import taufiq.apps.roomdemo.databinding.SubsListItemBinding
import taufiq.apps.roomdemo.db.SubscriberTable

/**
 * Created By Taufiq on 3/4/2021.
 *
 */
class SubscriberAdapter(
    private val context: Context,
    private val data: List<SubscriberTable>,
    private val listener: (SubscriberTable) -> Unit
) : RecyclerView.Adapter<SubscriberAdapter.SubscriberViewHolder>() {


    class SubscriberViewHolder(private val binding: SubsListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: SubscriberTable, listener: (SubscriberTable) -> Unit) {
            binding.apply {
                subName.text = data.subName
                subEmail.text = data.subEmail
                containers.setOnClickListener { listener(data) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubscriberViewHolder {
        return SubscriberViewHolder(SubsListItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: SubscriberViewHolder, position: Int) {
        holder.bind(data[position], listener)
    }

    override fun getItemCount() = data.size

}