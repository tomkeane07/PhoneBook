package com.example.phonebook.main.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.phonebook.databinding.ContactListItemBinding
import com.example.phonebook.main.framework.model.Contact

class ContactListAdapter() :
    ListAdapter<Contact, ContactListAdapter.ContactListViewHolder>(
        DiffCallback
    ) {

    /**
     * Allows the RecyclerView to determine which items have changed when the [List]
     * has been updated.
     */
    companion object DiffCallback : DiffUtil.ItemCallback<Contact>() {
        override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem === newItem
        }

        /**
         * Create new [RecyclerView] item views (invoked by the layout manager)
         */
        override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem.id == newItem.id
        }
    }



    /**
     * The ContactListViewHolder constructor takes the binding variable from the associated
     * ContactList, which nicely gives it access to the full [ContactList] information.
     */
    class ContactListViewHolder(
        private var binding: ContactListItemBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind( contact: Contact) {

            binding.contact = contact
            // This is important, because it forces the data binding to execute immediately,
            // which allows the RecyclerView to make the correct view size measurements
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ContactListViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ContactListItemBinding.inflate(layoutInflater, parent, false)
                return ContactListViewHolder(
                    binding
                )
            }
        }
    }


    override fun onBindViewHolder(
        holder: ContactListViewHolder, position: Int
    ) {

        val contact = getItem(position)
        holder.bind(contact)
    }

    /**
     * Replaces the contents of a view (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ContactListViewHolder {
        return ContactListViewHolder.from(
            parent
        )
    }

}

class ContactClickListener(val clickListener: (contact: Contact) -> Unit) {
    fun onClick(contact: Contact) = clickListener(contact)
}