package dev.idkwuu.tyablo

sealed class OnboardingRoute(val route: String) {
    object Start : OnboardingRoute("start")
    object InputPhone : OnboardingRoute("inputPhone")
    object Verification : OnboardingRoute("verification")
}