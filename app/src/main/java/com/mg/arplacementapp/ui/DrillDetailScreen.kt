package com.mg.arplacementapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mg.arplacementapp.Drill

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrillDetailScreen(navController: NavController, drill: Drill) {
    Column(modifier = Modifier.fillMaxSize()) {
        // Top App Bar
        TopAppBar(
            title = { Text(drill.name) },
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                }
            }
        )
        

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Drill Image
            Image(
                painter = painterResource(id = drill.imageRes),
                contentDescription = drill.name,
                modifier = Modifier
                    .size(250.dp)
                    .padding(16.dp),
                contentScale = ContentScale.Fit
            )
            
            // Drill Name
            Text(
                text = drill.name,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 16.dp)
            )
            
            // Description
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Description",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = drill.description,
                        fontSize = 16.sp
                    )
                }
            }
            
            // Safety Tip
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.errorContainer)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Tip",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(bottom = 8.dp),
                        color = MaterialTheme.colorScheme.onErrorContainer
                    )
                    Text(
                        text = drill.tip,
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.onErrorContainer
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // Start AR Button
            Button(
                onClick = {

                    // Navigate to AR screen with the selected drill's model

                    navController.navigate("ar/${drill.getModelFileName()}")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Text(
                    text = "Start AR View",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
