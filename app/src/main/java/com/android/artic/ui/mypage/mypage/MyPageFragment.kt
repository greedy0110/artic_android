package com.android.artic.ui.mypage.mypage

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.android.artic.R
import com.android.artic.ui.BaseFragment
import com.android.artic.ui.HeightWrappingViewPager
import com.android.artic.ui.setting.setting.SettingActivity
import kotlinx.android.synthetic.main.fragment_my_page.*
import kotlinx.android.synthetic.main.my_page_tablayout.*
import org.jetbrains.anko.startActivity

class MyPageFragment : BaseFragment(R.layout.fragment_my_page) {
    private lateinit var adapter: MyPageTabLayoutAdapter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        activity?.run {
            adapter = MyPageTabLayoutAdapter(supportFragmentManager)
            vp_my_page.adapter = adapter
            tl_my_page.setupWithViewPager(vp_my_page)

            val view = LayoutInflater.from(this).inflate(R.layout.my_page_tablayout, null, false)
            tl_my_page.getTabAt(0)!!.customView = view.findViewById(R.id.my_page_tablayout_srcap)
            tl_my_page.getTabAt(1)!!.customView = view.findViewById(R.id.my_page_tablayout_me)

            vp_my_page.addOnPageChangeListener(
                object : ViewPager.SimpleOnPageChangeListener() {
                    override fun onPageSelected(position: Int) {
                        when(position) {
                            0 -> selectScrapTab()
                            1 -> selectMeTab()
                        }
                    }
                }
            )
            selectScrapTab() // 초기에는 scrap tab을 선택한다.

            btn_my_page_setting.setOnClickListener {
                startActivity<SettingActivity>()
            }
        }
    }

    private fun initAllTabItem() {
        activity?.run {
            txt_my_page_tablayout_scrap.setTextColor(ContextCompat.getColor(this, R.color.brown_grey))
            img_my_page_tablayout_scrap.visibility = View.INVISIBLE

            txt_my_page_tablayout_me.setTextColor(ContextCompat.getColor(this, R.color.brown_grey))
            img_my_page_tablayout_me.visibility = View.INVISIBLE
        }
    }

    private fun selectScrapTab() {
        activity?.run {
            initAllTabItem()
            txt_my_page_tablayout_scrap.setTextColor(ContextCompat.getColor(this, R.color.soft_blue))
            img_my_page_tablayout_scrap.visibility = View.VISIBLE
        }
    }

    private fun selectMeTab() {
        activity?.run {
            initAllTabItem()
            txt_my_page_tablayout_me.setTextColor(ContextCompat.getColor(this, R.color.soft_blue))
            img_my_page_tablayout_me.visibility = View.VISIBLE
        }
    }
}
