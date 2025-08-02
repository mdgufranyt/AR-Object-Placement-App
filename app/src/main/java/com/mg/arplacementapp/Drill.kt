package com.mg.arplacementapp

data class Drill(
    val id: Int,
    val name: String,
    val imageRes: Int,
    val description: String,
    val tip: String,
    val modelFile: String = ""
) {
    // Helper function to get the model file name based on drill id
    fun getModelFileName(): String {
        return when (id) {
            1 -> "drill_cone.glb"
            2 -> "drill_cube.glb"
            3 -> "drill_sphere.glb"
            else -> "drill_cone.glb"
        }
    }
}
