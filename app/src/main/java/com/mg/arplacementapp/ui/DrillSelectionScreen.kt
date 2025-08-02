package com.mg.arplacementapp.ui


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mg.arplacementapp.Drill

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrillSelectionScreen(navController: NavController, drills: List<Drill>) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Select a Drill") })
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            items(drills) { drill ->
                ListItem(
                    headlineContent = { Text(drill.name) },
                    modifier = Modifier.clickable {
                        navController.navigate("detail/${drill.id}")
                    }
                )
                Divider()
            }
        }
    }
}