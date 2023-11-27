package com.example.domain.repository

import com.example.domain.model.Source

interface SourcesRepository {
    suspend fun getSourcesRepository():List<Source?>?
}