package com.example.smalltalk

import android.graphics.Color
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*

class ChatAdapter(
    private val messages: List<ChatObj>,
    private val myName: String
) : RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {
    class ChatViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val senderName: TextView = view.findViewById(R.id.bubble_name)
        val theirPic: ImageView = view.findViewById(R.id.their_image)
        val yourPic: ImageView = view.findViewById(R.id.your_image)
        val message: TextView = view.findViewById(R.id.chat_message)
        val date: TextView = view.findViewById(R.id.date)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {

        val cellView = LayoutInflater.from(parent.context)
            .inflate(R.layout.example_chat_item, parent, false)

        val params: ViewGroup.LayoutParams = cellView.layoutParams
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT
        params.width = ViewGroup.LayoutParams.MATCH_PARENT
        cellView.layoutParams = params


        return ChatViewHolder(cellView)
    }


    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val chatObject = messages[position]
        val loggedIn = isMyMessage(position)

        holder.senderName.text = chatObject.username
        holder.message.text = chatObject.message

        val simpleDate = SimpleDateFormat("dd/MM/yyyy hh:mm", Locale.getDefault())
        holder.date.text = simpleDate.format(chatObject.time)

        holder.theirPic.isVisible = !loggedIn
        holder.yourPic.isVisible = loggedIn

        if (loggedIn) {
            holder.yourPic.setImageResource(R.drawable.me)
            holder.senderName.gravity = Gravity.END
            holder.date.gravity = Gravity.END
            holder.message.setBackgroundResource(R.drawable.right)
            holder.message.setTextColor(Color.WHITE)
        } else {
            holder.theirPic.setImageResource(R.drawable.doggy)
            holder.senderName.gravity = Gravity.START
            holder.date.gravity = Gravity.START
            holder.message.setBackgroundResource(R.drawable.left)
        }
    }

    override fun getItemCount() = messages.size

    private fun isMyMessage(position: Int): Boolean {
        return messages[position].username == myName
    }
}