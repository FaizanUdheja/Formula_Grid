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

class HomeFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private lateinit var itemAdapter: ItemAdapter
    private lateinit var dataset: ArrayList<ModelClass>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

        val recyclerView = binding.recyclerView
        dataset = ArrayList()
        dataset.add(
            ModelClass(
                AppHelper.getDrawableUri(requireContext(), R.drawable.abu_dhabi),
                round = "Round1",
                country_name = "Abu Dhabi",
                description = "Fireworks",
                AppHelper.getDrawableUri(requireContext(), R.drawable.abudhabi)
            )
        )
        dataset.add(
            ModelClass(
                AppHelper.getDrawableUri(requireContext(), R.drawable.brazil_flag),
                round = "Round2",
                country_name = "Brazil",
                description = "Hot tracks",
                AppHelper.getDrawableUri(requireContext(), R.drawable.brazil)
            )
        )
        dataset.add(
            ModelClass(
                AppHelper.getDrawableUri(requireContext(), R.drawable.belguim_flag),
                round = "Round3",
                country_name = "Belgium",
                description = "New Livery",
                AppHelper.getDrawableUri(requireContext(), R.drawable.belguim)
            )
        )
        dataset.add(
            ModelClass(
                AppHelper.getDrawableUri(requireContext(), R.drawable.las_vegas_flag),
                round = "Round4",
                country_name = "LAS VEGAS",
                description = "Lightening",
                AppHelper.getDrawableUri(requireContext(), R.drawable.lasvegas)
            )
        )
        dataset.add(
            ModelClass(
                AppHelper.getDrawableUri(requireContext(), R.drawable.united_states_flag),
                round = "Round5",
                country_name = "United States",
                description = "Huge fans",
                AppHelper.getDrawableUri(requireContext(), R.drawable.unitedstates)
            )
        )
        itemAdapter =
            ItemAdapter(
                requireContext(),
                dataset,
                ItemAdapter.OnClickListener { itemData, clickType ->

                })
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = itemAdapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
