package com.bishal.narutoapp.domain.use_cases.save_onboarding

import com.bishal.narutoapp.data.respository.Repository

class SaveOnBoardingUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(completed: Boolean) {
        repository.saveOnBoardingState(completed = completed)
    }
}