package com.android.artic.repository.remote

import com.android.artic.data.Archive
import com.android.artic.data.Article
import com.android.artic.repository.remote.response.*
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.*

interface RetrofitInterface {

    @GET("/home/article/articles/new")
    fun getNewArticleList(): Call<BaseResponse<List<ArticleResponse>>>

    @GET("/home/article/{article_idx}/new")
    fun getArticle(
        @Header("Content-Type") contentType: String,
        @Header("token") token: String,
        @Path("article_idx") articleIdx: Int
    ): Call<BaseResponse<ArticleResponse>>

    @GET("/home/archive/archives/new")
    fun getNewArchiveList(): Call<BaseResponse<List<ArchiveResponse>>>

    @GET("/home/article/pick")
    fun getArticPickList(): Call<BaseResponse<List<ArticleResponse>>>

    @GET("/category")
    fun getCategoryList(): Call<BaseResponse<List<CategoryResponse>>>

    // @수민) 카테고리별 아카이브 리스트 GET
    @GET("/category/{category_idx}/archives")
    fun getCategoryArchiveList(
        @Path("category_idx") categoryIdx: Int
    ) : Call<BaseResponse<List<ArchiveResponse>>>

    // @수민) 아티클 담기
    @POST("/archive/{archive_idx}/article/{article_idx}")
    fun postCollectArticleInArchive(
        @Header("Content-Type") contentType: String,
        @Header("token") token: String,
        @Path("archive_idx") archiveId: Int,
        @Path("article_idx") articleIdx: Int
    ) : Call<BaseResponse<Int>>

    // @수민) 아티클 좋아요
    @POST("/archive/article/{article_idx}/like")
    fun postArticleLike(
        @Header("Content-Type") contentType: String,
        @Header("token") token: String,
        @Path("article_idx") articleIdx: Int
    ) : Call<BaseResponse<Int>> // response가 status, success, message만 있다면 data에 아무 값이나 넣어서 status 콜백 함수로 하면 됨

    @GET("/home/archive/category/{category_idx}")
    fun getArchiveListGivenCategory(
        @Path("category_idx") categoryIdx: Int
    ): Call<BaseResponse<List<ArchiveResponse>>>

    // 내 아카이브 목록 GET
    @GET("/mypage/archive/mine")
    fun getMyArchiveList(
        @Header("Content-Type") contentType: String,
        @Header("token") token: String
    ): Call<BaseResponse<List<ArchiveResponse>>>

    /**
     * https://github.com/artic-development/artic_server/wiki/%EC%95%84%EC%B9%B4%EC%9D%B4%EB%B8%8C-%EB%93%B1%EB%A1%9D
     * body
     *      title: String
     *      img: String? (if img == null, server will set default img)
     *      category_idx: Int? (if make my archive then it is set null)
     * @author greedy0110
     * */
    @POST("/archive")
    fun postRegisterArchive(
        @Header("Content-Type") contentType: String,
        @Header("token") token: String,
        @Body body: JsonObject
    ): Call<BaseResponse<Int>>

    @GET("/archive/{archive_idx}/articles")
    fun getArticleListGivenArchiveId(
        @Path("archive_idx") archiveId: Int,
        @Header("Content-Type") contentType: String,
        @Header("token") token: String
    ): Call<BaseResponse<List<ArticleResponse>>>

    @GET("/search/article")
    fun getSearchArticleList(
        @Header("Content-Type") contentType: String,
        @Header("token") token: String,
        @Query("keyword") keyword: String
    ): Call<BaseResponse<List<ArticleResponse>>>

    @GET("/search/archive")
    fun getSearchArchiveList(
        @Header("Content-Type") contentType: String,
        @Header("token") token: String,
        @Query("keyword") keyword: String
    ): Call<BaseResponse<List<ArchiveResponse>>>

    @POST("/archive/article/{article_idx}/history")
    fun postArticleRead(
        @Header("Content-Type") contentType: String,
        @Header("token") token:String,
        @Path("article_idx") articleIdx: Int
    ): Call<BaseResponse<Int>>

    @GET("/mypage/archive/scrap")
    fun getScrapArchiveList(
        @Header("Content-Type") contentType: String,
        @Header("token") token:String
    ): Call<BaseResponse<List<ArchiveResponse>>>

    @GET("/home/article/history")
    fun getReadingHistoryArticle(
        @Header("Content-Type") contentType: String,
        @Header("token") token: String
    ): Call<BaseResponse<List<ArticleResponse>>>

    @GET("/mypage")
    fun getMyPageInfo(
        @Header("Content-Type") contentType: String,
        @Header("token") token: String
    ) : Call<BaseResponse<MyPageResponse>>

    @PUT("/mypage")
    fun putMyPageInfo(
        @Header("Content-Type") contentType: String,
        @Header("token") token: String,
        @Body body:JsonObject
    ): Call<BaseResponse<List<MyPageResponse>>>

    /**
     * 추천 검색어 (https://github.com/artic-development/artic_server/wiki/%EC%B6%94%EC%B2%9C-%EA%B2%80%EC%83%89%EC%96%B4)
     * @author greedy0110
     * */
    @GET("/search/recommendation")
    fun getSearchRecommendation(
        @Header("Content-Type") contentType: String
    ): Call<BaseResponse<List<RecommendationResponse>>>
}