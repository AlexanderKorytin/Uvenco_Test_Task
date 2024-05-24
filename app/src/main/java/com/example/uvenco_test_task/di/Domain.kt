package com.example.uvenco_test_task.di

import com.example.uvenco_test_task.data.repository.MainRepositoryImpl
import com.example.uvenco_test_task.data.repository.SettingsRepositoryImpl
import com.example.uvenco_test_task.domain.api.MainInteractor
import com.example.uvenco_test_task.domain.api.MainRepository
import com.example.uvenco_test_task.domain.api.SettingsInteractor
import com.example.uvenco_test_task.domain.api.SettingsRepository
import com.example.uvenco_test_task.domain.impl.MainInteractorImpl
import com.example.uvenco_test_task.domain.impl.SettingsInteractorImpl
import org.koin.dsl.module

val domainModule = module {
    single<MainRepository> {
        MainRepositoryImpl(storage = get())
    }

    single<SettingsRepository> {
        SettingsRepositoryImpl(storage = get())
    }

    factory<MainInteractor> {
        MainInteractorImpl(mainRepository = get())
    }

    factory<SettingsInteractor> {
        SettingsInteractorImpl(settingsRepository = get())
    }
}