package com.hlandim.movies.movieslist.di

import com.hlandim.movies.central.data.Repository
import com.hlandim.movies.central.data.RepositoryImpl
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