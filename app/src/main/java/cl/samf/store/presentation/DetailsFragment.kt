package cl.samf.store.presentation

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import cl.samf.store.R
import cl.samf.store.databinding.FragmentDetailsBinding
import cl.samf.store.databinding.FragmentProductsBinding
import coil.load

private const val ARG_PARAM1 = "id"



class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private val storeViewModel: StoreViewModel by activityViewModels()
    private var param1: Int? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getInt(ARG_PARAM1)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(layoutInflater, container,false)
        initLoadDate()
        storeViewModel.loadDetailsStore(param1!!.toInt())

        return binding.root
    }

    private fun initLoadDate() {
        storeViewModel.detailsIdLiveData(param1!!).observe(viewLifecycleOwner){
            if(it !=null) {
                binding.imageViewDetails.load(it.image)
                binding.textViewDetails1.text = it.title
                binding.textViewDetails2.text = it.category
                binding.textViewDetails3.text = it.description
            }
        }
    }

}