package ssa.com.wedding.screens.question

import android.support.v7.widget.AppCompatRadioButton
import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ssa.com.wedding.R
import ssa.com.wedding.screens.question.AnswerAdapter.AnswerViewHolder

class AnswerAdapter(val answers: List<String>): RecyclerView.Adapter<AnswerViewHolder>() {

    var currentCheck = 0

    var enabled = true
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnswerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_answers, parent, false)
        return AnswerViewHolder(view)
    }

    override fun getItemCount() = answers.count()

    override fun onBindViewHolder(holder: AnswerViewHolder, position: Int) {
        holder.radio.isChecked = position == currentCheck
        holder.radio.setOnCheckedChangeListener { _, checked ->
            if (checked) {
                currentCheck = position
                notifyDataSetChanged()
            }
        }
        holder.radio.isEnabled = enabled
        holder.title.text = answers[position]
    }

    inner class AnswerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<AppCompatTextView>(R.id.title)
        val radio = itemView.findViewById<AppCompatRadioButton>(R.id.radio)
    }
}