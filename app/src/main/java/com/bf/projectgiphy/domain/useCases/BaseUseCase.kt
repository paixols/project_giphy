package com.bf.projectgiphy.domain.useCases

interface BaseUseCase<TResponse, TParam> {
    suspend operator fun invoke(param: TParam): TResponse
}