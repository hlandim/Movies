package com.hlandim.movies.di

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.hlandim.movies.BuildConfig
import com.hlandim.movies.data.remote.themoviedb.TheMovieDbService
import com.hlandim.movies.util.Constants.Companion.BASE_URL
import com.hlandim.movies.util.RequestInterceptor
import com.hlandim.movies.util.Utils.hasInternetConnection
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.io.IOException
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Singleton
    @Provides
    fun provideHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        connectivityInterceptor: ConnectivityInterceptor,
        requestInterceptor: RequestInterceptor
    ): OkHttpClient {
        loggingInterceptor.level =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        return OkHttpClient
            .Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .addInterceptor(connectivityInterceptor)
            .addInterceptor(requestInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gson: Gson
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Singleton
    @Provides
    fun providerGson(): Gson = GsonBuilder().setDateFormat("yyyy-MM-dd").create()

    @Singleton
    @Provides
    fun provideTheMovieDbService(retrofit: Retrofit): TheMovieDbService =
        retrofit.create(TheMovieDbService::class.java)

    @Singleton
    @Provides
    fun providerViewModelDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor()

    @Singleton
    @Provides
    fun provideConnectivityInterceptor(@ApplicationContext appContext: Context): ConnectivityInterceptor =
        ConnectivityInterceptor(appContext)

    @Singleton
    @Provides
    fun provideRequestInterceptor() = RequestInterceptor()

    class ConnectivityInterceptor(private val context: Context) : Interceptor {

        override fun intercept(chain: Interceptor.Chain): Response {
            if (!hasInternetConnection(context)) {
                throw NoConnectivityException()
            }

            val builder: Request.Builder = chain.request().newBuilder()
            return chain.proceed(builder.build())
        }

    }

    class NoConnectivityException : IOException() {
        companion object {
            private const val ERROR_MSG = "No connectivity"
        }

        override val message: String
            get() = ERROR_MSG

        override fun getLocalizedMessage(): String {
            return ERROR_MSG
        }
    }
}