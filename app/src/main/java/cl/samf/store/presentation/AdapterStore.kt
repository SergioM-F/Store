package cl.samf.store.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import cl.samf.store.R
import cl.samf.store.data.local.StoreEntity
import cl.samf.store.databinding.ItemProductsBinding
import coil.load

class AdapterStore: RecyclerView.Adapter<AdapterStore.StoreViewHolder>() {

    lateinit var binding: ItemProductsBinding
    private val listProductStore = mutableListOf<StoreEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreViewHolder {
        binding = ItemProductsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StoreViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listProductStore.size
    }

    override fun onBindViewHolder(holder: StoreViewHolder, position: Int) {
        val store = listProductStore[position]
        holder.bind(store)
    }

    fun setDatastore(store: List<StoreEntity>) {
        this.listProductStore.clear()
        this.listProductStore.addAll(store)
        notifyDataSetChanged()

    }

    class StoreViewHolder(val binding: ItemProductsBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(store: StoreEntity) {
            binding.imageViewImage.load(store.image)
            binding.textViewCategory.text = store.category
            binding.textViewDescription.text = store.description

            binding.cardViewid.setOnClickListener{
                val bundle = Bundle()
                bundle.putInt("id", store.id)
                Navigation.findNavController(binding.root).navigate(R.id.action_productsFragment_to_detailsFragment, bundle)
            }

        }

    }

}