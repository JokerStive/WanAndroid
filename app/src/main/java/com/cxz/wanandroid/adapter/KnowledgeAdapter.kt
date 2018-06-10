package com.cxz.wanandroid.adapter

import android.content.Context
import android.text.TextUtils
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.cxz.wanandroid.R
import com.cxz.wanandroid.mvp.model.bean.Article

/**
 * Created by chenxz on 2018/4/22.
 */
class KnowledgeAdapter(private val context: Context?, datas: MutableList<Article>) : BaseQuickAdapter<Article, BaseViewHolder>(R.layout.item_knowledge_list, datas) {

    override fun convert(helper: BaseViewHolder?, item: Article?) {
        item ?: return
        helper ?: return
        helper.setText(R.id.tv_article_title, item.title)
                .setText(R.id.tv_article_author, item.author)
                .setText(R.id.tv_article_date, item.niceDate)
        if (!TextUtils.isEmpty(item.chapterName)) {
            helper.setText(R.id.tv_article_chapterName, item.chapterName)
            helper.getView<TextView>(R.id.tv_article_chapterName).visibility = View.VISIBLE
        } else {
            helper.getView<TextView>(R.id.tv_article_chapterName).visibility = View.INVISIBLE
        }

        if (!TextUtils.isEmpty(item.envelopePic)) {
            helper.getView<ImageView>(R.id.iv_article_thumbnail)
                    .visibility = View.VISIBLE
            context?.let {
                Glide.with(it)
                        .load(item.envelopePic)
                        .into(helper.getView(R.id.iv_article_thumbnail))
            }
        } else {
            helper.getView<ImageView>(R.id.iv_article_thumbnail)
                    .visibility = View.GONE
        }
    }

}