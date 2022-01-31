package com.example.apimoshi.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apimoshi.TAG
import com.example.apimoshi.databinding.ActivityMainBinding
import com.example.apimoshi.databinding.FragmentTodoBinding
import com.example.apimoshi.databinding.FragmentUserBinding
import com.example.apimoshi.network.ApiManager
import com.example.apimoshi.repository.UserRepository
import com.example.apimoshi.view.adapter.UserAdapter
import com.example.apimoshi.viewmodel.UserViewModel

class UserFragment : Fragment() {

    private var _binding: FragmentTodoBinding? = null
    private val binding: FragmentTodoBinding get() = _binding!!

    private val viewModel: UserViewModel by activityViewModels {
        UserViewModel.Factory(UserRepository(ApiManager()))
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTodoBinding.inflate(inflater, container, false)
        return binding.root
    }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.users.observe(viewLifecycleOwner) {
            Log.d(TAG, " ${it.toString()}")
            binding.tvUser.text = it.toString()
        }
    }
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        with(binding) {
//            jsonRv.apply {
//                layoutManager = LinearLayoutManager(requireContext())
//                addItemDecoration(
//                    DividerItemDecoration(
//                        requireContext(),
//                        LinearLayoutManager.VERTICAL
//                    )
//                )
//            }
//        }
//    }


            override fun onDestroyView() {
                super.onDestroyView()
                _binding = null
            }
        }