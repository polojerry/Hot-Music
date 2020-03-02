package com.polotechnologies.hotmusic.ui.topArtists

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.polotechnologies.hotmusic.dataModel.Artist
import com.polotechnologies.hotmusic.databinding.ItemArtistBinding

class TopArtistRecyclerAdapter : ListAdapter<Artist, TopArtistRecyclerAdapter.TopArtistsViewHolder>(DiffCallBack) {

    object DiffCallBack : DiffUtil.ItemCallback<Artist>() {
        override fun areItemsTheSame(oldItem: Artist, newItem: Artist): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Artist, newItem: Artist): Boolean {
            return oldItem.artist_name == newItem.artist_name
        }

    }

    class TopArtistsViewHolder(private val binding: ItemArtistBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(artist: Artist){
            binding.artist = artist
            binding.executePendingBindings()
        }

    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TopArtistsViewHolder {
        return TopArtistsViewHolder(ItemArtistBinding.inflate(LayoutInflater.from(parent.context)))
    }


    override fun onBindViewHolder(
        holder: TopArtistsViewHolder,
        position: Int
    ) {
        val artist = getItem(position)
        holder.bind(artist)
    }
}