package com.swansistory.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.swansistory.R

class BlogPageFragment : Fragment() {

    private val args:BlogPageFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blog_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val blog = args.blogPost
        val imgResID = view.resources.getIdentifier(blog.imgUrl,"drawable",view.context.packageName)
        Glide.with(view.context).load(imgResID).into(view.findViewById(R.id.blog_image))
        view.findViewById<TextView>(R.id.blog_title).text = blog.title
        view.findViewById<TextView>(R.id.blog_data).text = blog.data
    }

}