package com.android.artic.ui.collect_archive

import android.content.Context
import android.graphics.Color
import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.android.artic.R
import com.android.artic.data.Archive
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.dialog_put_archive.*

class CollectArchiveListAdapter(
    private val ctx: Context,
    private val parentFragment : CollectArchiveDialogFragment,
    var dataList: List<Archive>,
    var checkedList: MutableList<Boolean>
): RecyclerView.Adapter<CollectArchiveListAdapter.Holder>(){

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): Holder {
        val view: View = LayoutInflater.from(ctx).inflate(R.layout.rv_item_archive_select_my_archive, viewGroup, false)

        return Holder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.img_my_archive_thumbnail.clipToOutline = true
        holder.img_select_layer.clipToOutline = true
        var alpha = holder.img_select_layer.drawable
        alpha.alpha = 61

        Glide
            .with(ctx)
            .load(dataList[position].title_img_url)
            .into(holder.img_my_archive_thumbnail)
        holder.tv_my_archive_name.text = dataList[position].title

        if (checkedList[position]) {
            holder.relative_select_layer.visibility = View.VISIBLE
        }
        else {
            holder.relative_select_layer.visibility = View.GONE
        }

        // @수민) 버튼 리스너
        holder.relative_archive_item.setOnClickListener {
            val prevCheck = checkedList.indexOf(true)
            if (prevCheck == position) { // 전부다 체크 해제!
                checkedList[position] = false
                notifyItemChanged(position)

                parentFragment.btn_rv_dialog_put_archive_complete.setTextColor(Color.parseColor("#000000"))
                parentFragment.btn_rv_dialog_put_archive_complete.text = "취소"
            }
            else if (prevCheck != -1) {
                checkedList[prevCheck] = false
                notifyItemChanged(prevCheck)

                checkedList[position] = true
                notifyItemChanged(position)
            }
            else {
                checkedList[position] = true
                notifyItemChanged(position)

                parentFragment.btn_rv_dialog_put_archive_complete.setTextColor(Color.parseColor("#4f80ff"))
                parentFragment.btn_rv_dialog_put_archive_complete.text = "완료"
            }
        }
    }

    private fun setDialogSelect(position: Int) {

    }

    inner class Holder(itemView: View): RecyclerView.ViewHolder(itemView){
        var relative_archive_item = itemView.findViewById<RelativeLayout>(R.id.relative_rv_item_archive_select_my_archive)
        var img_my_archive_thumbnail = itemView.findViewById<ImageView>(R.id.img_rv_item_archive_select_my_archive)
        var tv_my_archive_name = itemView.findViewById<TextView>(R.id.tv_rv_item_archive_select_my_archive_name)
        var relative_select_layer = itemView.findViewById<RelativeLayout>(R.id.relative_rv_item_archive_select_my_archive_select)
        var img_select_layer = itemView.findViewById<ImageView>(R.id.img_rv_item_archive_select_my_archive_select_background)
    }
}