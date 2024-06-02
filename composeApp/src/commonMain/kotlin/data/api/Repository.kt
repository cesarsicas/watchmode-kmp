package data.api

import domain.Title
import domain.titlesSample


class Repository() {

    //private val service = watchModeApi.create(WatchModeService::class.java)

    suspend fun getReleases(): List<Title> {
        return titlesSample
        //return service.getReleases(apiKey).releases.map { it.toTitle() }
    }

    suspend fun getTitleDetails(titleId: Int): Title {
        return titlesSample.first()
        //return service.getTitleDetails(titleId, apiKey).toTitle()
    }

    suspend fun getSearch(search: String): List<Title> {
        return titlesSample
        //return service.getSearch(apiKey, search).results.map { it.toTitle() }
    }
}


