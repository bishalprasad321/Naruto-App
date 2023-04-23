package com.bishal.narutoapp.domain.use_cases.read_onboarding

import com.bishal.narutoapp.data.respository.Repository
import kotlinx.coroutines.flow.Flow


class ReadOnBoardingUseCase(
    private val repository: Repository
) {
    operator fun invoke(): Flow<Boolean> {
        return repository.readOnBoardingState()
    }
}