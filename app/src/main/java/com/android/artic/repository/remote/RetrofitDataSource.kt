package com.android.artic.repository.remote

import com.android.artic.auth.Auth
import com.android.artic.repository.remote.response.*
import com.google.gson.JsonObject
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitDataSource : RemoteDataSource {
    private val retrofit: RetrofitInterface by lazy {
        Retrofit.Builder()
            .baseUrl(Auth.BASE_URL)
            .client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(RetrofitInterface::class.java)
    }

    override fun getNewArticleList(): Call<BaseResponse<List<ArticleResponse>>> {
        return retrofit.getNewArticleList()
    }

    override fun getNewArchiveList(): Call<BaseResponse<List<ArchiveResponse>>> {
        return retrofit.getNewArchiveList()
    }

    override fun getArticle(contentType: String, token: String, articleIdx: Int): Call<BaseResponse<ArticleResponse>> {
        return retrofit.getArticle(contentType, token, articleIdx)
    }

    // 아티클 좋아요 누르기
    override fun postArticleLike(contentType: String, token: String, articleIdx: Int): Call<BaseResponse<Int>> {
        return retrofit.postArticleLike(contentType, token, articleIdx)
    }

    override fun getArticPickList(): Call<BaseResponse<List<ArticleResponse>>> {
        return retrofit.getArticPickList()
    }

    override fun getCategoryList(): Call<BaseResponse<List<CategoryResponse>>> {
        return retrofit.getCategoryList()
    }

    // @수민) 카테고리에 따른 아카이브 리스트
    override fun getCategoryArchiveList(contentType: String, token: String, categoryIdx : Int): Call<BaseResponse<List<ArchiveResponse>>> {
        return retrofit.getCategoryArchiveList(contentType, token, categoryIdx)
    }

    override fun getArchiveListGivenCategory(categoryIdx: Int): Call<BaseResponse<List<ArchiveResponse>>> {
        return retrofit.getArchiveListGivenCategory(categoryIdx)
    }

    override fun getMyArchiveList(contentType: String, token: String): Call<BaseResponse<List<ArchiveResponse>>> {
        return retrofit.getMyArchiveList(contentType, token)
    }

    override fun getScrapArchiveList(contentType: String, token: String): Call<BaseResponse<List<ArchiveResponse>>> {
        return retrofit.getScrapArchiveList(contentType,token)
    }

    override fun getReadingHistoryArticle(contentType: String, token: String): Call<BaseResponse<List<ArticleResponse>>> {
        return retrofit.getReadingHistoryArticle(contentType, token)
    }

    // @수민) 아티클 담기
    override fun postCollectArticleInArchive(
        contentType: String,
        token: String,
        archiveIdx: Int,
        articleIdx: Int
    ): Call<BaseResponse<Int>> {
        return retrofit.postCollectArticleInArchive(contentType, token, archiveIdx, articleIdx)
    }

    override fun postRegisterArchive(contentType: String, token: String, body: JsonObject): Call<BaseResponse<Int>> {
        return retrofit.postRegisterArchive(contentType, token, body)
    }

    override fun postArticleRead(
        contentType: String, token: String,articleIdx: Int
    ): Call<BaseResponse<Int>> {
        return retrofit.postArticleRead(contentType,token,articleIdx)

    }
    override fun getArticleListGivenArchiveId(archiveId: Int, contentType: String, token: String): Call<BaseResponse<List<ArticleResponse>>> {
        return retrofit.getArticleListGivenArchiveId(archiveId, contentType, token )
    }

    override fun putMyPageInfo(
        contentType: String,
        token: String,
        body: JsonObject
    ): Call<BaseResponse<List<MyPageResponse>>> {
        return retrofit.putMyPageInfo(contentType, token, body)
    }
    override fun getMyPageInfo(contentType: String, token: String): Call<BaseResponse<MyPageResponse>> {
        return retrofit.getMyPageInfo(contentType, token)
    }

    override fun getSearchArticleList(
        contentType: String,
        token: String,
        keyword: String
    ): Call<BaseResponse<List<ArticleResponse>>> {
        return retrofit.getSearchArticleList(contentType, token, keyword)
    }

    override fun getSearchArchiveList(
        contentType: String,
        token: String,
        keyword: String
    ): Call<BaseResponse<List<ArchiveResponse>>> {
        return retrofit.getSearchArchiveList(contentType, token, keyword)
    }

    override fun getSearchRecommendation(contentType: String): Call<BaseResponse<List<RecommendationResponse>>> {
        return retrofit.getSearchRecommendation(contentType)
    }

    override fun postArchiveScrap(contentType: String, token: String, archiveIdx: Int): Call<BaseResponse<Any>> {
        return retrofit.postArchiveScrap(contentType, token, archiveIdx)
    }
}