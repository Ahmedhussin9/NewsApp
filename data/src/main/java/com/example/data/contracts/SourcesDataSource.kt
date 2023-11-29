package com.example.data.contracts

import com.example.domain.model.sourcesResponse.Source

interface SourcesDataSource {
    suspend fun getSources(catrgorId:String):List<Source?>?
}