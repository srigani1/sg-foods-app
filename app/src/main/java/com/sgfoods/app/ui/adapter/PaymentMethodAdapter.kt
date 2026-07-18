package com.sgfoods.app.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sgfoods.app.databinding.ItemPaymentMethodBinding

class PaymentMethodAdapter(private val paymentMethods: List<String>) :
    RecyclerView.Adapter<PaymentMethodAdapter.PaymentViewHolder>() {

    inner class PaymentViewHolder(private val binding: ItemPaymentMethodBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(method: String) {
            binding.paymentMethodText.text = method
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentViewHolder {
        val binding = ItemPaymentMethodBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PaymentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PaymentViewHolder, position: Int) {
        holder.bind(paymentMethods[position])
    }

    override fun getItemCount(): Int = paymentMethods.size
}
