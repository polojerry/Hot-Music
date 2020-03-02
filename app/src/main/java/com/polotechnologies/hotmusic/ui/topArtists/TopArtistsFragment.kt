package com.polotechnologies.hotmusic.ui.topArtists

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.polotechnologies.hotmusic.R
import com.polotechnologies.hotmusic.databinding.FragmentTopArtistsBinding

/**
 * A simple [Fragment] subclass.
 */
class TopArtistsFragment : Fragment() {

    private lateinit var mBinding: FragmentTopArtistsBinding
    private lateinit var mViewModel: TopArtistsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_top_artists, container, false)
        mBinding.lifecycleOwner = this

        mViewModel = ViewModelProvider(this).get(TopArtistsViewModel::class.java)
        mBinding.viewModel = mViewModel


        return  mBinding.root
    }

}
