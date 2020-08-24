package com.example.phonebook.main.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.phonebook.databinding.FragmentContactDetailsBinding
import com.example.phonebook.main.ui.adapters.PhoneListAdapter
import com.example.phonebook.main.ui.viewmodels.ContactDetailsViewModel
import com.example.phonebook.main.ui.viewmodels.ContactDetailsViewModelFactory

class ContactDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val application = requireNotNull(activity).application
        val binding = FragmentContactDetailsBinding.inflate(inflater)
        binding.lifecycleOwner = this

        val contact = ContactDetailsFragmentArgs.fromBundle(
            requireArguments()
        ).selectedContact

        val viewModel = ViewModelProviders.of(
            this,
            ContactDetailsViewModelFactory(
                application, contact
            )
        ).get(ContactDetailsViewModel::class.java)

        binding.viewModel = viewModel

        binding.contactPhones.adapter =
            PhoneListAdapter()

        return binding.root
    }
}