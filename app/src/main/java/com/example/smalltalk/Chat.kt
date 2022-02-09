package com.example.smalltalk

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class ChatFragment : Fragment() {

    private lateinit var theLayoutManager: LinearLayoutManager
    private lateinit var theView: RecyclerView
    private lateinit var chatAdapter: ChatAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        theView = view.findViewById(R.id.chatViews)
        theLayoutManager = LinearLayoutManager(activity)

        val messageList = listOf(
            ChatObj(
                "Halla! Du glemte maten idag. Jeg ble veldig lei meg...",
                "Bisken",
                false,
                Date()
            ),
            ChatObj("Beklager bisken...", "Meg", true, Date()),
            ChatObj(
                "Voff voff altså. Slemt av deg... Da får jeg spise sofaen istedenfor. Snakkes.",
                "Bisken",
                false,
                Date()
            ),
            ChatObj("Fair enough. Ses...", "Meg", true, Date()),
            ChatObj(
                "Ja det gjør vi. Voff. Husk å kjøpe dentasticks, så slipper du rotet... VOFF",
                "Bisken",
                false,
                Date()
            ),
            ChatObj(
                "Greit det.",
                "Meg",
                true,
                Date()
            ),
            ChatObj(
                "Så bra. <3",
                "Bisken",
                false,
                Date()
            )
        )

        chatAdapter = ChatAdapter(
            messageList,
            "Meg"
        )

        theView.layoutManager = theLayoutManager
        theView.adapter = chatAdapter
        theView.scrollToPosition(messageList.size - 1);
    }
}
