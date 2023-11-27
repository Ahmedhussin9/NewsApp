package com.example.data.contracts

import com.example.domain.model.Source

interface SourcesDataSource {
    suspend fun getSources():List<Source?>?
}