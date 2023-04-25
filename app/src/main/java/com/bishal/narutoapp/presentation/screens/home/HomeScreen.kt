package com.bishal.narutoapp.presentation.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.bishal.narutoapp.presentation.common.ListContent
import com.bishal.narutoapp.presentation.screens.components.RatingWidget
import com.bishal.narutoapp.ui.theme.EXTRA_LARGE_PADDING

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {

    val allHeroes = homeViewModel.getAllHeroes.collectAsLazyPagingItems()

    Scaffold(
      topBar = {
        HomeTopBar(onSearchClicked = {})
      },
        content = {
            ListContent(
                heroes = allHeroes,
                navController = navController
            )
        }
    )
}