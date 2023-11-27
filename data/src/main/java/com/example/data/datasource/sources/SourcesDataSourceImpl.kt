package com.example.data.datasource.sources

import com.example.data.api.Constants
import com.example.data.api.WebServices
import com.example.data.contracts.SourcesDataSource
import com.example.domain.model.Source
import javax.inject.Inject

class SourcesDataSourceImpl @Inject constructor(
    private val webServices: WebServices
):SourcesDataSource {
    override suspend fun getSources(): List<Source?>? {
        return webServices.getSources(Constants.apiKey).sources
    }
}