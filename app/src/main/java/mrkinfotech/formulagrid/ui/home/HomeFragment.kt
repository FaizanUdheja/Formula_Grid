package mrkinfotech.formulagrid.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import mrkinfotech.formulagrid.R
import mrkinfotech.formulagrid.databinding.FragmentFirstBinding
import mrkinfotech.formulagrid.ui.adapter.ItemAdapter
import mrkinfotech.formulagrid.ui.data.ModelClass
import mrkinfotech.formulagrid.utils.AppHelper
import mrkinfotech.formulagrid.utils.MasterDataUtils

class HomeFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private lateinit var itemAdapter: ItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        itemAdapter =
            ItemAdapter(
                requireContext(),
                MasterDataUtils.contestList(requireContext()),
                ItemAdapter.OnClickListener { itemData, clickType ->

                })
        binding.recyclerView.adapter = itemAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
