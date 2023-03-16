package com.example.aa6notesaap

import android.content.Context
import android.view.LayoutInflater
import android.view.OnReceiveContentListener
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesRVadapter(private val context : Context, private val listener: INotesRVadapter): RecyclerView.Adapter<NotesRVadapter.NotesViewHolder>() {

    private val allNotes = ArrayList<Notes>()

    inner class NotesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textView :TextView = itemView.findViewById<TextView>(R.id.text)
        val deleteButton : ImageView = itemView.findViewById<ImageView>(R.id.deleteBut)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val viewHolder = NotesViewHolder(LayoutInflater.from(context).inflate(R.layout.note_item, parent, false))
        viewHolder.deleteButton.setOnClickListener{
            listener.onItemClicked(allNotes[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun getItemCount(): Int{
        return allNotes.count()
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val currentNote = allNotes[position]
        holder.textView.text = currentNote.text
    }

    fun updataList(newList : List<Notes>){
        allNotes.clear()
        allNotes.addAll(newList)

        notifyDataSetChanged()
    }

}

interface INotesRVadapter{
    fun onItemClicked(notes: Notes)
}