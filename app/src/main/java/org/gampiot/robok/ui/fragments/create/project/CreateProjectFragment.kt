package org.gampiot.robok.ui.fragments.create.project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.activity.OnBackPressedDispatcher

import com.google.android.material.transition.MaterialSharedAxis

import org.gampiot.robok.R
import org.gampiot.robok.databinding.FragmentCreateProjectBinding
import org.gampiot.robok.feature.util.base.RobokFragment
import org.gampiot.robok.feature.util.getBackPressedClickListener

class CreateProjectFragment (private val tansitionAxis : Int = MaterialSharedAxis.X) : RobokFragment(tansitionAxis) {

    private var _binding: FragmentCreateProjectBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCreateProjectBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureToolbarNavigationBack(binding.toolbar)
        setFragmentLayoutResId(R.id.fragment_container)
        
        val onBackPressedDispatcher = requireActivity().onBackPressedDispatcher
        binding.buttonBack.setOnClickListener(getBackPressedClickListener(onBackPressedDispatcher))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}