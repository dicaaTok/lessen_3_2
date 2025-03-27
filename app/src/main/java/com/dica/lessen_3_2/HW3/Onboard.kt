package com.dica.lessen_3_2.HW3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dica.lessen_3_2.databinding.FragmentOnboardBinding


class Onboard : Fragment() {

    private  val  pref by lazy {
        Pref(requireContext())
    }
    private lateinit var binding: FragmentOnboardBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentOnboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = OnboardAdapter(this::onClick)
        binding.viewPager.adapter = adapter
        binding.c.setViewPager(binding.viewPager)
    }

    private fun onClick() {
        pref.onShowed()
        findNavController().navigateUp()
    }
}