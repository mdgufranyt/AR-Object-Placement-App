package com.mg.arplacementapp


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mg.arplacementapp.ui.ARScreen
import com.mg.arplacementapp.ui.DrillDetailScreen
import com.mg.arplacementapp.ui.DrillSelectionScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    // Dummy data for drills
    val drills = listOf(
        Drill(1, "Cone Drill", R.drawable.drill_cone, "A powerful drill for tough surfaces.", "Always wear safety glasses.", "impact_drill.glb"),
        Drill(2, "Cube Drill", R.drawable.drill_cube, "A versatile drill for everyday tasks.", "Ensure the battery is fully charged.", "cordless_drill.glb"),
        Drill(3, "Sphere Drill", R.drawable.drill_sphere, "Used for drilling into masonry and concrete.", "Use the auxiliary handle for better control.", "hammer_drill.glb")
    )

    NavHost(navController = navController, startDestination = "selection") {
        composable("selection") {
            DrillSelectionScreen(navController = navController, drills = drills)
        }
        composable("detail/{drillId}") { backStackEntry ->
            val drillId = backStackEntry.arguments?.getString("drillId")?.toIntOrNull()
            val drill = drills.find { it.id == drillId }
            if (drill != null) {
                DrillDetailScreen(navController = navController, drill = drill)
            }
        }
        composable("ar/{model}") { backStackEntry ->
            val model = backStackEntry.arguments?.getString("model") ?: ""
            ARScreen(model = model)
        }
    }
}