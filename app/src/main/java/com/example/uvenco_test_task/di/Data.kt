package com.example.uvenco_test_task.di

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import com.example.uvenco_test_task.data.storage.api.SettingsStorage
import com.example.uvenco_test_task.data.storage.impl.SharedPrefSettingsStorage
import com.google.gson.Gson
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    factory { Gson() }

    single<SharedPreferences> {
        androidContext().getSharedPreferences(
            SETTINGS_APP,
            AppCompatActivity.MODE_PRIVATE
        )
    }

    single<SettingsStorage> {
        SharedPrefSettingsStorage(sharedPreferences = get(), json = get())
    }
}

private const val SETTINGS_APP = "settings_app"