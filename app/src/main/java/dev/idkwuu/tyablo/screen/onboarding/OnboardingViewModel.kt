package dev.idkwuu.tyablo.screen.onboarding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

class OnboardingViewModel(): ViewModel() {
    val route = MutableLiveData<String>("start")

    fun setRoute(newRoute: String) {
        route.value = newRoute
    }
}