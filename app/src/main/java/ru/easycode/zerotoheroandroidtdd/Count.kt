package ru.easycode.zerotoheroandroidtdd

interface Count {

    fun increment(number: String): UiState
    class Base(private val step: Int, private val max: Int): Count {

        init {
            if(step < 1) {
                throw IllegalStateException("step should be positive, but was $step")
            }

            if(max < 0) {
                throw IllegalStateException("max should be positive, but was $max")
            }

            if (step > max) {
                throw IllegalStateException("max should be more than step")
            }
        }

        override fun increment(number: String): UiState {
            var newNum: Int = number.toInt() + step
            if (newNum + step <= max) {
                return UiState.Base(newNum.toString())
            }
            return UiState.Max(newNum.toString())

        }

    }

}