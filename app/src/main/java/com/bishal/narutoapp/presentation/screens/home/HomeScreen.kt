package com.bishal.narutoapp.presentation.screens.home

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import coil.annotation.ExperimentalCoilApi
import com.bishal.narutoapp.navigation.Screen
import com.bishal.narutoapp.presentation.common.ListContent

@ExperimentalCoilApi
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {

    val allHeroes = homeViewModel.getAllHeroes.collectAsLazyPagingItems()

    Scaffold(
      topBar = {
        HomeTopBar(
            onSearchClicked = {
                navController.navigate(Screen.Search.route)
            }
        )
      },
        content = {
            ListContent(
                heroes = allHeroes,
                navController = navController
            )
        }
    )
}