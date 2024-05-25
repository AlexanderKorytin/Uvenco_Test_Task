package com.example.uvenco_test_task.data.repository

import android.icu.text.SimpleDateFormat
import com.example.uvenco_test_task.domain.api.HeadRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.Calendar
import java.util.Locale
import kotlin.random.Random

class HeadRepositoryImpl : HeadRepository {
    override suspend fun getTime(): Flow<String> = flow {
        val time = Calendar.getInstance().time.time
        emit(SimpleDateFormat("HH:mm", Locale.getDefault()).format(time))
    }

    override suspend fun getTemperature(): Flow<String> = flow {
        val temp = Random.nextDouble(85.0, 95.1)
        emit("${String.format("%.1f", temp)}°")
    }
}