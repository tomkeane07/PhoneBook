package com.example.phonebook.main.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.phonebook.databinding.ContactPhoneListItemBinding
import com.example.phonebook.main.framework.model.Phone

class PhoneListAdapter() :
    ListAdapter<Phone, PhoneListAdapter.PhoneListViewHolder>(
        DiffCallback
    ) {

    /**
     * Allows the RecyclerView to determine which items have changed when the [List]
     * has been updated.
     */
    companion object DiffCallback : DiffUtil.ItemCallback<Phone>() {
        override fun areItemsTheSame(oldItem: Phone, newItem: Phone): Boolean {
            return oldItem === newItem
        }

        /**
         * Create new [RecyclerView] item views (invoked by the layout manager)
         */
        override fun areContentsTheSame(oldItem: Phone, newItem: Phone): Boolean {
            return oldItem.value == newItem.value
        }
    }



    /**
     * The PhoneListViewHolder constructor takes the binding variable from the associated
     * PhoneList, which nicely gives it access to the full [PhoneList] information.
     */
    class PhoneListViewHolder(
        private var binding: ContactPhoneListItemBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(phone: Phone) {
            binding.phone = phone
            // This is important, because it forces the data binding to execute immediately,
            // which allows the RecyclerView to make the correct view size measurements
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): PhoneListViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ContactPhoneListItemBinding.inflate(layoutInflater, parent, false)
                return PhoneListViewHolder(
                    binding
                )
            }
        }
    }


    override fun onBindViewHolder(
        holder: PhoneListViewHolder, position: Int
    ) {

        val phone = getItem(position)
        holder.bind(phone)
    }

    /**
     * Replaces the contents of a view (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            PhoneListViewHolder {
        return PhoneListViewHolder.from(
            parent
        )
    }

}