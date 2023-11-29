package com.example.data.datasource.sources

import com.example.data.api.Constants
import com.example.data.api.WebServices
import com.example.data.contracts.SourcesDataSource
import com.example.domain.model.sourcesResponse.Source
import javax.inject.Inject

class SourcesDataSourceImpl @Inject constructor(
    private val webServices: WebServices,
):SourcesDataSource {
    override suspend fun getSources(catrgorId: String): List<Source?>? {
        return webServices.getSources(Constants.apiKey,catrgorId).sources
    }
}