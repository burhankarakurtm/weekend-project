package com.burhan.karakurt.weekend.core.di

import com.burhan.karakurt.weekend.core.data.repository.MarvelRepository
import com.burhan.karakurt.weekend.core.data.repository.MarvelRepositoryImpl
import com.burhan.karakurt.weekend.core.usecase.MarvelCharacterListUseCase
import com.burhan.karakurt.weekend.core.usecase.MarvelCharacterListUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MarvelModule {
    @Binds
    abstract fun provideMarvelRepository(
        marvelRepositoryImpl: MarvelRepositoryImpl
    ): MarvelRepository

    @Binds
    abstract fun provideMarvelCharacterListUseCase(
        marvelCharacterListUseCaseImpl: MarvelCharacterListUseCaseImpl
    ): MarvelCharacterListUseCase
}