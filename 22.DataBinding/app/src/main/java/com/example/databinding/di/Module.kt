package com.example.databinding.di

import com.example.databinding.remote.APIClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object Module {

    private const val BASE_URL = "https://api.themoviedb.org/3/"
//    private const val BASE_URL = "https://gist.githubusercontent.com/chekeAditya/26a7978a5bdbf95f22751f77bf1f7055/raw/b9633db9cc1de349c1b12e816ad697f04bf55ecc/"

    @Provides
    fun provideAPIService():APIClient{
        val builder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return builder.create(APIClient::class.java)
    }
}