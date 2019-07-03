package com.android.artic.repository

import com.android.artic.data.Archive
import com.android.artic.data.Article
import com.android.artic.ui.category.data.ArchiveCategory
import com.android.artic.ui.category.data.Category
import com.android.artic.ui.home.artic_pick.data.ArticPickData
import com.android.artic.ui.home.new_archive.data.ArchiveCardData
import com.android.artic.ui.home.new_article_link.data.NewArticleLinkData
import com.android.artic.ui.home.reading_history.data.HistoryData
import retrofit2.Call
import retrofit2.mock.Calls

/**
 * object that read, write data from server or local
 * @author greedy0110
 * */
class ArticRepository (

) {
    /**
     * get CategoryList by Asynchronous
     * @author greedy0110
     * @see Category
     * @return Callable Category List
     * */
    fun getCategoryList(): Call<List<Category>> {
        return Calls.response(
            listOf(
                Category(
                    en_name = "Design", kr_name = "디자인", children = listOf(
                        ArchiveCategory(1, "UX/UI"),
                        ArchiveCategory(2, "BX"),
                        ArchiveCategory(3, "그래픽"),
                        ArchiveCategory(4, "영상/모션")
                    )
                ),
                Category(
                    en_name = "Plan", kr_name = "서비스 기획", children = listOf(
                        ArchiveCategory(1, "UX/UI"),
                        ArchiveCategory(2, "BX"),
                        ArchiveCategory(3, "그래픽"),
                        ArchiveCategory(4, "영상/모션")
                    )
                ),
                Category(
                    en_name = "Management", kr_name = "매니지먼트", children = listOf(
                        ArchiveCategory(1, "UX/UI"),
                        ArchiveCategory(2, "BX"),
                        ArchiveCategory(3, "그래픽"),
                        ArchiveCategory(4, "영상/모션")
                    )
                )
            )
        )
    }

    /**
     * get New Archive List by Asynchronous
     * @author greedy0110
     * */
    fun getNewArchiveList(): Call<List<ArchiveCardData>> {
        return Calls.response(
            listOf(
                ArchiveCardData(
                    archive_id = 0, category = "Animal", title = "고양이는 왜 이렇게 귀여운가. 고양이 키우고싶다. 숙소에 고양이 대려와.", img_url = "data:image/jpeg;base64,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"
                ),ArchiveCardData(
                    archive_id = 0, category = "Animal", title = "고양이는 왜 이렇게 귀여운가. 고양이 키우고싶다. 숙소에 고양이 대려와.", img_url = "data:image/jpeg;base64,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"
                ),ArchiveCardData(
                    archive_id = 0, category = "Animal", title = "고양이는 왜 이렇게 귀여운가. 고양이 키우고싶다. 숙소에 고양이 대려와.", img_url = "data:image/jpeg;base64,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"
                ),ArchiveCardData(
                    archive_id = 0, category = "Animal", title = "고양이는 왜 이렇게 귀여운가. 고양이 키우고싶다. 숙소에 고양이 대려와.", img_url = "data:image/jpeg;base64,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"
                ),ArchiveCardData(
                    archive_id = 0, category = "Animal", title = "고양이는 왜 이렇게 귀여운가. 고양이 키우고싶다. 숙소에 고양이 대려와.", img_url = "data:image/jpeg;base64,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"
                )
            )
        )
    }

    fun getReadingHistoryArchiveList():Call<List<HistoryData>> {
        return Calls.response(
            listOf(

               HistoryData(0,"brunch.co.kr","제품 디자이너는 코딩에 대해 잊어야 합니다.","http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png"),
                HistoryData(1,"brunch.co.kr","댑(DApp)이 몰고올 디자이너 '댑'","http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png"),
                HistoryData(2,"brunch.co.kr","사용자 경헙(UX), 망해가던 Gucci를","http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png"),
                HistoryData(3,"brunch.co.kr","디자이너가 알아두면 좋은 인하우스와 에이전시의 차이점","http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png")

            )

        )
    }

    fun getNewArticleLinkList():Call<List<NewArticleLinkData>> {
        return Calls.response(
            listOf(
                NewArticleLinkData(0,"brunch.co.kr","디자이너가 알아두면 좋은 인하우스와 에이전시는 에이전시의 차이점","https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"),
                NewArticleLinkData(1,"brunch.co.kr","디자이너가 알아두면 좋은 인하우스와 에이전시는 에이전시의 차이점","https://images.pexels.com/photos/459225/pexels-photo-459225.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"),
                NewArticleLinkData(2,"brunch.co.kr","디자이너가 알아두면 좋은 인하우스와 에이전시는 에이전시의 차이점","https://images.pexels.com/photos/34950/pexels-photo.jpg?auto=compress&cs=tinysrgb&dpr=1&w=500"),
                NewArticleLinkData(3,"brunch.co.kr","디자이너가 알아두면 좋은 인하우스와 에이전시는 에이전시의 차이점","https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"),
                NewArticleLinkData(4,"brunch.co.kr","디자이너가 알아두면 좋은 인하우스와 에이전시는 에이전시의 차이점","https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500")

            )
        )
    }

    fun getArticPickList():Call<List<ArticPickData>> {
        return Calls.response(
            listOf(
                ArticPickData(0,"brunch.co.kr","디자이너가 알아두면 좋은 인하우스와 에이전시는 에이전시의 차이점","https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"),
                ArticPickData(1,"brunch.co.kr","디자이너가 알아두면 좋은 인하우스와 에이전시는 에이전시의 차이점","https://images.pexels.com/photos/459225/pexels-photo-459225.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"),
                ArticPickData(2,"brunch.co.kr","디자이너가 알아두면 좋은 인하우스와 에이전시는 에이전시의 차이점","https://images.pexels.com/photos/34950/pexels-photo.jpg?auto=compress&cs=tinysrgb&dpr=1&w=500"),
                ArticPickData(3,"brunch.co.kr","디자이너가 알아두면 좋은 인하우스와 에이전시는 에이전시의 차이점","https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"),
                ArticPickData(4,"brunch.co.kr","디자이너가 알아두면 좋은 인하우스와 에이전시는 에이전시의 차이점","https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500")

            )
        )
    }

    /**
     * get archive name given archive Id by Asynchronous
     * @author greedy0110
     * */
    fun getArchiveName(archiveId: Int): Call<String> {
        return Calls.response(
            "지금 바로 시작할 수 있는 린 브랜딩 방법론을 알려주세요"
        )
    }

    /**
     * get dummy category list by asynchronous
     * @see Category
     * @author greedy0110
     * */
    fun getDummyCategoryList(): Call<List<com.android.artic.data.Category>> {
        return Calls.response(
            listOf(
                com.android.artic.data.Category(
                    id = 0,
                    name = "design"
                ),com.android.artic.data.Category(
                    id = 0,
                    name = "design"
                ),com.android.artic.data.Category(
                    id = 0,
                    name = "design"
                ),com.android.artic.data.Category(
                    id = 0,
                    name = "design"
                ),com.android.artic.data.Category(
                    id = 0,
                    name = "design"
                ),com.android.artic.data.Category(
                    id = 0,
                    name = "design"
                ),com.android.artic.data.Category(
                    id = 0,
                    name = "design"
                ),com.android.artic.data.Category(
                    id = 0,
                    name = "design"
                )
            )
        )
    }

    /**
     * get dummy archive list by asynchronous
     * @see Archive
     * @author greedy0110
     * */
    fun getDummyArchiveList(): Call<List<Archive>> {
        return Calls.response(
            listOf(
                Archive(
                    id = 0,
                    category_ids = listOf(1,2,3),
                    title = "dummy archive",
                    title_img_url = "https://pixel.nymag.com/imgs/daily/vulture/2019/03/13/13-captain-marvel-flerken-cat.w700.h700.jpg",
                    num_article = 3,
                    article_ids = listOf(1,2,3)
                ),Archive(
                    id = 1,
                    category_ids = listOf(1,2,3),
                    title = "dummy archive",
                    title_img_url = "https://pixel.nymag.com/imgs/daily/vulture/2019/03/13/13-captain-marvel-flerken-cat.w700.h700.jpg",
                    num_article = 3,
                    article_ids = listOf(1,2,3)
                ),Archive(
                    id = 2,
                    category_ids = listOf(1,2,3),
                    title = "dummy archive",
                    title_img_url = "https://pixel.nymag.com/imgs/daily/vulture/2019/03/13/13-captain-marvel-flerken-cat.w700.h700.jpg",
                    num_article = 3,
                    article_ids = listOf(1,2,3)
                ),Archive(
                    id = 3,
                    category_ids = listOf(1,2,3),
                    title = "dummy archive",
                    title_img_url = "https://pixel.nymag.com/imgs/daily/vulture/2019/03/13/13-captain-marvel-flerken-cat.w700.h700.jpg",
                    num_article = 3,
                    article_ids = listOf(1,2,3)
                ),Archive(
                    id = 4,
                    category_ids = listOf(1,2,3),
                    title = "dummy archive",
                    title_img_url = "https://pixel.nymag.com/imgs/daily/vulture/2019/03/13/13-captain-marvel-flerken-cat.w700.h700.jpg",
                    num_article = 3,
                    article_ids = listOf(1,2,3)
                ),Archive(
                    id = 5,
                    category_ids = listOf(1,2,3),
                    title = "dummy archive",
                    title_img_url = "https://pixel.nymag.com/imgs/daily/vulture/2019/03/13/13-captain-marvel-flerken-cat.w700.h700.jpg",
                    num_article = 3,
                    article_ids = listOf(1,2,3)
                )
            )
        )
    }

    /**
     * get dummy archive by asynchronous
     * @see Archive
     * @author greedy0110
     * */
    fun getDummyArchive(): Call<Archive> {
        return Calls.response(
            Archive(
                id = 0,
                category_ids = listOf(1,2,3),
                title = "dummy archive",
                title_img_url = "https://pixel.nymag.com/imgs/daily/vulture/2019/03/13/13-captain-marvel-flerken-cat.w700.h700.jpg",
                num_article = 3,
                article_ids = listOf(1,2,3)
            )
        )
    }

    /**
     * get dummy article list by asynchronous
     * @see Article
     * @author greedy0110
     * */
    fun getDummyArticleList(): Call<List<Article>> {
        return Calls.response(
            listOf(
                Article(
                    id = 0,
                    title = "dummy article",
                    url = "https://github.com/artic-development/artic_android",
                    title_img_url = "https://avatars0.githubusercontent.com/u/52156026?s=200&v=4",
                    like = 999,
                    isLiked = false
                ),Article(
                    id = 0,
                    title = "dummy article",
                    url = "https://github.com/artic-development/artic_android",
                    title_img_url = "https://avatars0.githubusercontent.com/u/52156026?s=200&v=4",
                    like = 999,
                    isLiked = true
                ),Article(
                    id = 0,
                    title = "dummy article",
                    url = "https://github.com/artic-development/artic_android",
                    title_img_url = "https://avatars0.githubusercontent.com/u/52156026?s=200&v=4",
                    like = 999,
                    isLiked = false
                ),Article(
                    id = 0,
                    title = "dummy article",
                    url = "https://github.com/artic-development/artic_android",
                    title_img_url = "https://avatars0.githubusercontent.com/u/52156026?s=200&v=4",
                    like = 999,
                    isLiked = true
                ),Article(
                    id = 0,
                    title = "dummy article",
                    url = "https://github.com/artic-development/artic_android",
                    title_img_url = "https://avatars0.githubusercontent.com/u/52156026?s=200&v=4",
                    like = 999,
                    isLiked = false
                )
            )
        )
    }

    /**
     * get an dummy article by asynchronous
     * @see Article
     * @author greedy0110
     * */
    fun getDummyArticle(): Call<Article> {
        return Calls.response(
            Article(
                id = 0,
                title = "dummy article",
                url = "https://github.com/artic-development/artic_android",
                title_img_url = "https://avatars0.githubusercontent.com/u/52156026?s=200&v=4",
                like = 999,
                isLiked = false
            )
        )
    }
}


