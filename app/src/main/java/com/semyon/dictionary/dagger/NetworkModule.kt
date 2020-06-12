package com.semyon.dictionary.dagger

import com.semyon.dictionary.network.SkyEngApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .build()
    }

    @Provides
    fun provideSkyEngApi(okHttpClient: OkHttpClient): SkyEngApi {
        return Retrofit.Builder()
            .baseUrl("https://dictionary.skyeng.ru")
            .client(okHttpClient)
            .build()
            .create(SkyEngApi::class.java)
    }
}