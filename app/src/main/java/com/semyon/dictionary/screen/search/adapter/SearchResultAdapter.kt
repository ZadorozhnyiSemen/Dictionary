package com.semyon.dictionary.screen.search.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.semyon.dictionary.R
import com.semyon.dictionary.model.PreviewWord
import kotlinx.android.synthetic.main.item_search_result.view.*

class SearchResultAdapter : RecyclerView.Adapter<SearchResultAdapter.SearchResultViewHolder>() {

    var searchItems = arrayListOf<PreviewWord>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_search_result, parent, false)
        return SearchResultViewHolder(view)
    }

    override fun getItemCount(): Int = searchItems.size

    override fun onBindViewHolder(holder: SearchResultViewHolder, position: Int) {
        val item = searchItems[position]

        holder.apply {
            println(item)
            Glide.with(holder.itemView.context)
                .load(item.getPreview())
                .circleCrop()
                .into(image)

            origin.text = item.text
            translation.text = item.meanings.first().translation.text
        }
    }

    inner class SearchResultViewHolder(
        view: View,
        val image: ImageView = view.item_image,
        val origin: TextView = view.item_original,
        val translation: TextView = view.item_translation
    ) : RecyclerView.ViewHolder(view)
}