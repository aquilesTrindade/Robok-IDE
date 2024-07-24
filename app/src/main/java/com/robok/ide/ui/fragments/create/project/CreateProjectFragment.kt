package com.robok.ide.ui.fragments.create.project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.google.android.material.transition.MaterialSharedAxis

import com.robok.ide.databinding.FragmentCreateProjectBinding
import com.robok.ide.ui.base.RobokFragment

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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}