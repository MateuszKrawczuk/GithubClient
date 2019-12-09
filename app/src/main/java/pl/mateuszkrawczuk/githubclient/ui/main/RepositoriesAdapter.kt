package pl.mateuszkrawczuk.githubclient.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import pl.mateuszkrawczuk.githubclient.R
import pl.mateuszkrawczuk.githubclient.databinding.AdapterItemRepositoryBinding
import pl.mateuszkrawczuk.githubclient.models.RepositoryInfo

class RepositoriesAdapter : RecyclerView.Adapter<RepositoriesAdapter.MyViewHolder>() {

    private val items = arrayListOf<RepositoryInfo>()

    fun setItems(newItems: List<RepositoryInfo>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: AdapterItemRepositoryBinding =
            DataBindingUtil.inflate(inflater, R.layout.adapter_item_repository, parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.item = items[position]
    }

    class MyViewHolder(val binding: AdapterItemRepositoryBinding) :
        RecyclerView.ViewHolder(binding.root)
}