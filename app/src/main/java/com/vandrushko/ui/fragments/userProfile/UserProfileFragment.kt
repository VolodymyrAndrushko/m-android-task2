package com.vandrushko.ui.fragments.userProfile

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.fragment.navArgs
import com.vandrushko.R
import com.vandrushko.databinding.FragmentUserProfileBinding
import com.vandrushko.ui.fragments.Configs
import com.vandrushko.ui.fragments.pager.PagerFragmentArgs
import com.vandrushko.ui.utils.BaseFragment
import com.vandrushko.ui.utils.Parser
import com.vandrushko.ui.utils.ext.changePageTo
import com.vandrushko.ui.utils.ext.loadImage

private const val CONTACTS_PAGE_INDEX = 1
class UserProfileFragment : BaseFragment<FragmentUserProfileBinding>(FragmentUserProfileBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.profilePhoto.loadImage()
        setProfileFullName()
        setListeners()
    }

    private fun setListeners() {
        setGoToContactsOnClickListener()
    }

    private fun setGoToContactsOnClickListener() {
        binding.viewContactsButton.setOnClickListener{
            changePageTo(requireActivity(), CONTACTS_PAGE_INDEX)
        }
    }

    private fun setProfileFullName() {
        val email: String? = arguments?.getString("email")
        val fullName: String? = Parser().parseEmail(email)

        if(fullName!=null) binding.fullNameText.text = fullName
    }


}