package com.polotechnologies.hotmusic.adapter

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.polotechnologies.hotmusic.dataModel.Artist
import com.polotechnologies.hotmusic.ui.topArtists.TopArtistRecyclerAdapter

@BindingAdapter("itemList")
fun bind(recyclerView: RecyclerView, data : List<Artist>?){
    val adapter = recyclerView.adapter as TopArtistRecyclerAdapter
    adapter.submitList(data)
}

@BindingAdapter("imageView")
fun bind (imageView: AppCompatImageView, artist: Artist?){
    val imageUrl = artist?.image?.get(0)?.image_url
    imageUrl.let {
        Glide.with(imageView.context)
            .load(imageUrl)
            .into(imageView)
    }
}