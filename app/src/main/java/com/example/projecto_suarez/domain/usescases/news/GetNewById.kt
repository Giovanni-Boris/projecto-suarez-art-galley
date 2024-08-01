package com.example.projecto_suarez.domain.usescases.news

import com.example.projecto_suarez.data.remote.dto.NewsResponse
import com.example.projecto_suarez.domain.model.ArticleResponse
import com.example.projecto_suarez.domain.repository.NewsRepository

class GetNewById (
    private val newsRepository: NewsRepository
) {
    suspend operator fun invoke(sources: List<String>, id: String): ArticleResponse {
        return newsRepository.getNewsById(sources = sources, id)
    }
}