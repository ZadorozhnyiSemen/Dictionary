package com.semyon.dictionary.dagger

import com.semyon.dictionary.repository.WordRepository
import com.semyon.dictionary.repository.WordRepositoryImp
import com.semyon.dictionary.repository.cache.MeaningCache
import com.semyon.dictionary.repository.cache.SearchCache
import com.semyon.dictionary.repository.network.SkyEngApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Provides
    fun provideWordRepository(
        api: SkyEngApi,
        searchCache: SearchCache,
        meaningCache: MeaningCache
    ): WordRepository {
        return WordRepositoryImp(api, searchCache, meaningCache)
    }

    @Provides
    fun provideSearchCache(): SearchCache = SearchCache()

    @Provides
    fun provideMeaningCache(): MeaningCache = MeaningCache()
}