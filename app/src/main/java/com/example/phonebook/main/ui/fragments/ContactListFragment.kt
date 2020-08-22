package com.example.phonebook.main.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.phonebook.databinding.FragmentContactListBinding
import com.example.phonebook.main.framework.model.Contact
import com.example.phonebook.main.ui.adapters.ContactClickListener
import com.example.phonebook.main.ui.adapters.ContactListAdapter
import com.example.phonebook.main.ui.viewmodels.ContactListViewModel
import com.example.phonebook.main.ui.viewmodels.ContactListViewModelFactory

class ContactListFragment : Fragment() {

    lateinit var selectedMovie: Contact
    private lateinit var viewModel: ContactListViewModel
    private lateinit var username: String
    private lateinit var password: String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        username = activity?.intent?.getStringExtra("username")!!
        password = activity?.intent?.getStringExtra("password")!!
        Log.d("credentials", username + " " + password)

        val application = requireNotNull(activity).application
        val binding = FragmentContactListBinding.inflate(inflater)
        binding.lifecycleOwner = this

        viewModel = ViewModelProviders.of(
            this,
            ContactListViewModelFactory(
                application,
                username,
                password
            )
        ).get(ContactListViewModel::class.java)
        binding.viewModel = viewModel

        binding.contactList.adapter =
            ContactListAdapter(ContactClickListener {
                
            })

        return binding.root
    }

}