package com.animecix

import com.lagradost.cloudstream3.*
import com.lagradost.cloudstream3.utils.AppUtils.parseJson
import com.lagradost.cloudstream3.utils.ExtractorLink
import org.jsoup.nodes.Element

class AnimeciXProvider : MainAPI() { // all providers must be an instance of MainAPI
    override var mainUrl = "https://animecix.tv"
    override var name = "AnimeciX"
    override val hasMainPage = true
    override var lang = "tr"
    override val hasDownloadSupport = true
    override val supportedTypes = setOf(
        TvType.Anime,
        TvType.AnimeMovie
    )

    override val mainPage = mainPageOf(
        "$mainUrl/api/v1/anime/latest-episodes" to "Son Bölümler",
        "$mainUrl/api/v1/anime/top-rated" to "En Çok Oy Alanlar",
        "$mainUrl/api/v1/anime/popular" to "Popüler Animeler"
    )

    override suspend fun getMainPage(
        page: Int,
        request: MainPageRequest
    ): HomePageResponse {
        // TODO: Implement actual parsing logic.
        // This is a boilerplate to ensure it compiles.
        val items = ArrayList<SearchResponse>()
        return newHomePageResponse(request.name, items)
    }

    override suspend fun search(query: String): List<SearchResponse> {
        // TODO: Implement actual search parsing
        return listOf()
    }

    override suspend fun load(url: String): LoadResponse {
        // TODO: Implement episode loading
        return newAnimeLoadResponse(name, url, TvType.Anime) {
            this.posterUrl = null
            this.year = 2024
            this.plot = "Boilerplate eklenti tasarımı."
        }
    }

    override suspend fun loadLinks(
        data: String,
        isCasting: Boolean,
        subtitleCallback: (SubtitleFile) -> Unit,
        callback: (ExtractorLink) -> Unit
    ): Boolean {
        // TODO: Implement extractor parsing
        return true
    }
}