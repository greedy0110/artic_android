package com.android.artic.ui.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.android.artic.R
import com.android.artic.auth.Auth
import com.android.artic.data.auth.Signin
import com.android.artic.logger.Logger
import com.android.artic.ui.base.BaseActivity
import com.android.artic.ui.base.BaseOnPageChangeListener
import com.android.artic.ui.notification.NotificationFragment
import kotlinx.android.synthetic.main.activity_navigation.*
import org.koin.android.ext.android.inject

class NavigationActivity : BaseActivity() {
    private lateinit var pagerAdapter: NavigationTabPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        pagerAdapter = NavigationTabPagerAdapter(supportFragmentManager)

        tl_navigation.setupWithViewPager(vp_navigation)
        tl_navigation.tabIconTint = null // 이거 없으면 안됌 선택시 tint 때문에 icon 이 덮힘
        vp_navigation.adapter = pagerAdapter
        vp_navigation.offscreenPageLimit = 4 // 모든 fragment 들을 메모리에 들고 있게끔 하였다. (mypage 에서 custom viewpager 부분에 에러가있다. 만약 fragment 를 다시 만들면 view pager 의 height 세팅이 제대로 동작하지 않음)

        val iconList = listOf(
            R.drawable.selector_tab_home,
            R.drawable.selector_tab_category,
            R.drawable.selector_tab_notice,
            R.drawable.selector_tab_profile
        )

        for (i in 0 until tl_navigation.tabCount) {
            tl_navigation.getTabAt(i)?.setIcon(iconList[i])
        }

        vp_navigation.addOnPageChangeListener(
            BaseOnPageChangeListener(pagerAdapter)
        )

        // Notification 숫자를 구독해야한다.
        val notificationTabItem = tl_navigation.getTabAt(2)

        (pagerAdapter.getItem(2) as NotificationFragment).numNewNotice.subscribe {
            if (it > 0)
                notificationTabItem?.showBadge()?.number = it
            else
                notificationTabItem?.removeBadge()
        }.apply { addDisposable(this) }
    }
}