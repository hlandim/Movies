package com.hlandim.movies.di

import com.hlandim.movies.data.Repository
import com.hlandim.movies.data.RepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindRepository(repositoryImpl: RepositoryImpl): Repository
}