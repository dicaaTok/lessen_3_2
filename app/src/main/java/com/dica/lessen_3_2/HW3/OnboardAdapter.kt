package com.dica.lessen_3_2.HW3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.dica.lessen_3_2.R
import com.dica.lessen_3_2.databinding.ItemOnboardBinding

class OnboardAdapter(private val onClick: () -> Unit) :
    RecyclerView.Adapter<OnboardAdapter.OnBoardingViewHolder>() {
    private val list = arrayListOf<OnBoarding>(
        OnBoarding(
            "Удобство",
            "Создавайте заметки в два клика! Записывайте мысли, идеи и важные задачи мгновенно.",
            R.raw.anim1
        ),
        OnBoarding(
            "Организация",
            "Организуйте заметки по папкам и тегам. Легко находите нужную информацию в любое время..",
            R.raw.anim2
        ),
        OnBoarding(
            "Синхронизация",
            "Синхронизация на всех устройствах. Доступ к записям в любое время и в любом месте..",
            R.raw.anim3
        ),
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnboardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class OnBoardingViewHolder(private val binding: ItemOnboardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(onBoarding: OnBoarding) = with(binding) {
            title.text = onBoarding.title
            tvDesc.text = onBoarding.desc
            skip.isVisible = adapterPosition != list.lastIndex
            startButton.isVisible = adapterPosition == list.lastIndex

            onBoarding.image?.let {
                animation.setAnimation(onBoarding.image)
                animation.playAnimation()
            }
            startButton.setOnClickListener {
                onClick()
            }
            skip.setOnClickListener {
                onClick()
            }

        }


    }

}