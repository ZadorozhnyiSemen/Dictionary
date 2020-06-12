package com.semyon.dictionary.screen.word.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.semyon.dictionary.R
import com.semyon.dictionary.model.WordExample
import kotlinx.android.synthetic.main.item_word_example.view.*

class ExampleAdapter(
    private val listener: (WordExample) -> Unit
) : RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>() {

    var examples = arrayListOf<WordExample>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_word_example, parent, false)
        return ExampleViewHolder(view)
    }

    override fun getItemCount(): Int = examples.size

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val item = examples[position]

        holder.apply {
            itemView.setOnClickListener { listener(item) }
            text.text = item.text
        }
    }

    inner class ExampleViewHolder(
        view: View,
        val text: TextView = view.item_text
    ) : RecyclerView.ViewHolder(view)
}