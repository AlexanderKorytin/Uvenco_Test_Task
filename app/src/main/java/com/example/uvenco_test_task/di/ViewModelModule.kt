package com.example.uvenco_test_task.di

import com.example.uvenco_test_task.presentation.viewmodels.HeadViewModel
import com.example.uvenco_test_task.presentation.viewmodels.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel<MainViewModel> {
        MainViewModel(mainInteractor = get())
    }

    viewModel<HeadViewModel> {
        HeadViewModel(headInteractor = get())
    }
}