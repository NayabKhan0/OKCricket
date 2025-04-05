package com.android.okcricket.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.okcricket.R
import com.android.okcricket.databinding.FragmentTeamDetailsBinding


class TeamDetailsFragment : Fragment() {

    private lateinit var binding: FragmentTeamDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTeamDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

}