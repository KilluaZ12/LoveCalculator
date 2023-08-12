package com.example.lovecalculator.ui.onboard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.ItemOnBoardingBinding
import com.example.lovecalculator.model.OnBoard

class OnBoardingAdapter(private val onClick: () -> Unit) :
    RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    val list = arrayListOf(
        OnBoard(
            R.raw.animation_broken_heart,
            "Расстаться?",
            "Попробуй с другим человеком. Не опускай руки"
        ),
        OnBoard(

            R.raw.animation_kiss,
            "Утони в любви",
            "Посмотри нужно ли тебе это"
        ),
        OnBoard(
            R.raw.animation_park,
            "Строй оношения",
            "Но не принимай это приложение в серьёз"
        ),
        OnBoard(
            R.raw.animation_live,
            "Живи и наслаждайся",
            "Не трать время зря. Женись чувак!!!"
        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnBoardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    inner class OnBoardingViewHolder(private val binding: ItemOnBoardingBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(onBoard: OnBoard) {
            with(binding) {
                lottieAnimationView.setAnimation(onBoard.anim!!)
                tvTitle.text = onBoard.title
                tvDesc.text = onBoard.description
                binding.btnStart.isVisible = adapterPosition == list.lastIndex
                binding.btnStart.setOnClickListener {
                    onClick()
                }
            }
        }

    }
}