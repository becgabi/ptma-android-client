package com.ptma.di

import com.ptma.BuildConfig
import com.ptma.api.AppointmentApi
import com.ptma.api.AuthenticationApi
import com.ptma.api.WorkoutApi
import com.ptma.data.network.interceptor.JwtAuthInterceptor
import com.ptma.infrastructure.ApiClient
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideApiClient(jwtAuthInterceptor: JwtAuthInterceptor): ApiClient = ApiClient(
        baseUrl = BuildConfig.PTMA_BASE_URL,
        okHttpClientBuilder = OkHttpClient.Builder()
            .addInterceptor(jwtAuthInterceptor)
    )

    @Provides
    @Singleton
    fun provideAuthApi(apiClient: ApiClient): AuthenticationApi =
        apiClient.createService(AuthenticationApi::class.java)

    @Provides
    @Singleton
    fun provideUserApi(apiClient: ApiClient): AppointmentApi =
        apiClient.createService(AppointmentApi::class.java)

    @Provides
    @Singleton
    fun providePartnerApi(apiClient: ApiClient): WorkoutApi =
        apiClient.createService(WorkoutApi::class.java)
}