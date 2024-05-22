package ru.easycode.zerotoheroandroidtdd

interface Count {

    fun initial(number: String): UiState

    fun increment(number: String): UiState

    fun decrement(number: String): UiState
    class Base(val step: Int, val max: Int, val min: Int): Count {

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

        override fun initial(number: String): UiState {
            if(number.toInt() == min) {
                return UiState.Min(number)
            }

            if(number.toInt() == max) {
                return UiState.Max(number)
            }
            return UiState.Base(number)
        }

        override fun increment(number: String): UiState {
            val newNum: Int = number.toInt() + step
            if (newNum + step <= max) {
                return UiState.Base(newNum.toString())
            }
            return UiState.Max(newNum.toString())
        }

        override fun decrement(number: String): UiState {
            val newNum: Int = number.toInt() - step
            if (newNum - step >= min) {
                return UiState.Base(newNum.toString())
            }
            return UiState.Min(newNum.toString())
        }


    }

}