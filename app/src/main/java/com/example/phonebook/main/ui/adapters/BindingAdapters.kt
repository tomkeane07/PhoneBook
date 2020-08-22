package com.example.phonebook.main.ui.adapters

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.phonebook.R
import com.example.phonebook.main.framework.model.Contact

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Contact>?) {
    val adapter = recyclerView.adapter as ContactListAdapter
    adapter.submitList(data)
}


@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, posterPath: String?) {
    val imgUrl = "image.tmdb.org/t/p/w500" + posterPath
    imgUrl.let {

        val imgUri = imgUrl.toUri()
            .buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(
                RequestOptions()
            )
            .into(imgView)
    }
}
