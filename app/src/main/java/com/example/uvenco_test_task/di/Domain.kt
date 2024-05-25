package com.example.uvenco_test_task.di

import com.example.uvenco_test_task.data.repository.HeadRepositoryImpl
import com.example.uvenco_test_task.data.repository.MainRepositoryImpl
import com.example.uvenco_test_task.data.repository.SettingsRepositoryImpl
import com.example.uvenco_test_task.domain.api.HeadInteractor
import com.example.uvenco_test_task.domain.api.HeadRepository
import com.example.uvenco_test_task.domain.api.MainInteractor
import com.example.uvenco_test_task.domain.api.MainRepository
import com.example.uvenco_test_task.domain.api.SettingsInteractor
import com.example.uvenco_test_task.domain.api.SettingsRepository
import com.example.uvenco_test_task.domain.impl.HeadInteractorImpl
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

    single<HeadRepository> {
        HeadRepositoryImpl()
    }

    factory<MainInteractor> {
        MainInteractorImpl(mainRepository = get())
    }

    factory<SettingsInteractor> {
        SettingsInteractorImpl(settingsRepository = get())
    }

    factory<HeadInteractor> {
        HeadInteractorImpl(headRepository = get())
    }
}