package com.bishal.narutoapp.presentation.screens.home

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen() {

    Scaffold(
      topBar = {
        HomeTopBar(onSearchClicked = {})
      }
    ) {}
}