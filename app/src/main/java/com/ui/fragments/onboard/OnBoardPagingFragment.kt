package com.ui.fragments.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dica.lessen_3_2.R
import com.dica.lessen_3_2.databinding.FragmentOnBoardPagingBinding



class OnBoardPagingFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardPagingBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View  {
        binding = FragmentOnBoardPagingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() = with(binding) {
        when (requireArguments().getInt(ARG_ONBOARD_POSITION)) {
            0 -> {
                lottieAnimation.setAnimation(R.raw.anim_hi)
                txtNotes.text = "ZamanBank"
                txtTitle.text = "Приветствие"
                txtDescription.text = "\uD83D\uDC4B Добро пожаловать в ZamanBank\n" +
                        "Банк нового времени — просто, быстро, по-человечески.\n"
            }
            1 -> {
                lottieAnimation.setAnimation(R.raw.anim_2)
                txtNotes.text = "ZamanBank"
                txtTitle.text = "\uD83E\uDDE9 Удобный интерфейс"
                txtDescription.text = "Минималистичный дизайн, понятная структура, никаких лишних шагов. Вы легко найдёте нужное — даже если открыли приложение впервые.\n" +
                        "\n" +
                        "⚡ Быстрые переводы\n" +
                        "Деньги — за секунды.\n" +
                        "Мгновенные переводы между картами и счетами. Без ожиданий, без комиссий, без сложностей.\n" +
                        "\n" +
                        "\uD83D\uDC65 Доверительный кредит от друзей\n" +
                        "Финансовая поддержка — ближе, чем кажется.\n" +
                        "Запросите кредит у друзей напрямую через ZamanBank. Прозрачно, безопасно, с гибкими условиями. Мы просто помогаем вам договориться.\n"
            }
            2 -> {
                lottieAnimation.setAnimation(R.raw.anim)
                txtNotes.text = "ZamanBank"
                txtTitle.text = "Добро пожаловать"
                txtDescription.text = "\uD83D\uDD12 Вход в ZamanBank\n" +
                        "Доступ к вашим финансам — в пару шагов.\n"
            }
        }

    }

    companion object{
        const val ARG_ONBOARD_POSITION = "onBoard"
    }
}