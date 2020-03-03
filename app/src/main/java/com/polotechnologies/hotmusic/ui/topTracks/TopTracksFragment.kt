package com.polotechnologies.hotmusic.ui.topTracks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.polotechnologies.hotmusic.R
import com.polotechnologies.hotmusic.databinding.FragmentTopTracksBinding

/**
 * A simple [Fragment] subclass.
 */
class TopTracksFragment : Fragment() {

    private lateinit var mBinding: FragmentTopTracksBinding
    private lateinit var mViewModel : TopTracksViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_top_tracks, container, false)
        mViewModel = ViewModelProvider(this).get(TopTracksViewModel::class.java)

        mBinding.lifecycleOwner = this
        mBinding.viewModel = mViewModel

        return mBinding.root
    }

}
