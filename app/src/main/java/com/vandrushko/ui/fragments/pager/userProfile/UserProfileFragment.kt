package com.vandrushko.ui.fragments.pager.userProfile

import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.vandrushko.R
import com.vandrushko.databinding.FragmentUserProfileBinding
import com.vandrushko.ui.utils.BaseFragment
import com.vandrushko.ui.utils.Parser
import com.vandrushko.ui.utils.ext.loadImage

private const val CONTACTS_PAGE_INDEX = 1

class UserProfileFragment :
    BaseFragment<FragmentUserProfileBinding>(FragmentUserProfileBinding::inflate) {

    private fun setListeners() {
        setGoToContactsOnClickListener()
    }

    private fun setGoToContactsOnClickListener() {
        binding.viewContactsButton.setOnClickListener {
            val viewPager = requireActivity().findViewById<ViewPager2>(R.id.viewPager)
            viewPager.currentItem = CONTACTS_PAGE_INDEX

        }
    }

    private fun setProfileFullName() {
        val email: String? = arguments?.getString("email")
        val fullName: String? = Parser.parseEmail(email)

        if (fullName != null) binding.fullNameText.text = fullName
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.profilePhoto.loadImage()
        setProfileFullName()
        setListeners()
    }
}