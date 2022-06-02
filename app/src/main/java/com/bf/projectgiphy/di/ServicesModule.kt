package com.bf.projectgiphy.di

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object ServicesModule {

    @JvmStatic
    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)


    @JvmStatic
    @Singleton
    @Provides
    fun providesOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(interceptor)
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                val originalUrl = chain.request().url
                val url = originalUrl.newBuilder()
                    .addQueryParameter(
                        name = "api_key",
                        value = "HjrHiMjHCQ1OJE5480AnutX6LxahIVun"
                    ).build()
                request.url(url)
                return@addInterceptor chain.proceed(request.build())
            }
            .build()

    @JvmStatic
    @Singleton
    @Provides
    fun providesGsonConverter(): GsonConverterFactory =
        GsonConverterFactory.create()

    @JvmStatic
    @Singleton
    @Provides
    fun providesRetrofit(
        httpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit =
        Retrofit
            .Builder()
            .baseUrl("https://api.giphy.com/")
            .client(httpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
}