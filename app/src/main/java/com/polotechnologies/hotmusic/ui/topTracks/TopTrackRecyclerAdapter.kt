package com.polotechnologies.hotmusic.ui.topTracks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.polotechnologies.hotmusic.dataModel.Track
import com.polotechnologies.hotmusic.databinding.ItemTrackBinding

class TopTrackRecyclerAdapter: ListAdapter<Track, TopTrackRecyclerAdapter.TrackViewHolder>(DiffCallBack) {
    object DiffCallBack : DiffUtil.ItemCallback<Track>() {
        override fun areItemsTheSame(oldItem: Track, newItem: Track): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Track, newItem: Track): Boolean {
            return oldItem.url == newItem.url
        }

    }

    class TrackViewHolder(private val binding : ItemTrackBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(track: Track){
            binding.track = track
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TrackViewHolder {
        return TrackViewHolder(ItemTrackBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
        val track = getItem(position)
        holder.bind(track)
    }
}