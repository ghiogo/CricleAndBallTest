package com.example.cricleandballtest

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cricleandballtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val redCircleAnimator = ObjectAnimator.ofFloat(
            binding.redCircle,
            "translationX",
            0f,
            resources.displayMetrics.widthPixels.toFloat()
        )
        redCircleAnimator.duration = 10000

        val blueSquareAnimator = ObjectAnimator.ofFloat(
            binding.blueSquare,
            "translationY",
            resources.displayMetrics.heightPixels.toFloat(),
            binding.blueSquare.height.toFloat()
        )
        blueSquareAnimator.duration = 10000

        val animatorSet = AnimatorSet()
        animatorSet.playTogether(redCircleAnimator, blueSquareAnimator)


        animatorSet.start()
    }
}
