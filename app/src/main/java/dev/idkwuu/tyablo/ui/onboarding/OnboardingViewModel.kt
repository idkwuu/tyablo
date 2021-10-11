package dev.idkwuu.tyablo.ui.onboarding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OnboardingViewModel(): ViewModel() {
    val route = MutableLiveData<String>("start")

    fun setRoute(newRoute: String) {
        route.value = newRoute
    }
}