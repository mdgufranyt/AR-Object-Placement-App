package com.mg.arplacementapp.ui

import android.view.MotionEvent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.ar.core.Config
import com.google.ar.core.Frame
import com.google.ar.core.TrackingFailureReason
import io.github.sceneview.ar.ARScene
import io.github.sceneview.ar.arcore.createAnchorOrNull
import io.github.sceneview.ar.arcore.isValid
import io.github.sceneview.ar.node.AnchorNode
import io.github.sceneview.ar.rememberARCameraNode
import io.github.sceneview.math.Position
import io.github.sceneview.node.ModelNode
import io.github.sceneview.node.Node
import io.github.sceneview.rememberCollisionSystem
import io.github.sceneview.rememberEngine
import io.github.sceneview.rememberModelLoader
import io.github.sceneview.rememberNodes
import io.github.sceneview.rememberOnGestureListener
import io.github.sceneview.rememberView

@Composable
fun ARScreen(model: String) {
    val engine = rememberEngine()
    val modelLoader = rememberModelLoader(engine = engine)
    val cameraNode = rememberARCameraNode(engine = engine)
    val childNodes = rememberNodes()
    val view = rememberView(engine = engine)
    val collisionSystem = rememberCollisionSystem(view = view)
    val trackingFailureReason = remember {
        mutableStateOf<TrackingFailureReason?>(null)
    }
    val frame = remember {
        mutableStateOf<Frame?>(null)
    }

    Box(modifier = Modifier.fillMaxSize()){
        ARScene(
            modifier = Modifier.fillMaxSize(),
            childNodes = childNodes,
            engine = engine,
            view = view,
            modelLoader = modelLoader,
            collisionSystem = collisionSystem,
            cameraNode = cameraNode,
            onTrackingFailureChanged = {
                trackingFailureReason.value = it
            },
            onSessionUpdated = { _, updatedFrame ->
                frame.value = updatedFrame
            },
            sessionConfiguration = { session, config ->
                config.depthMode = when (session.isDepthModeSupported(Config.DepthMode.AUTOMATIC)) {
                    true -> Config.DepthMode.AUTOMATIC
                    else -> Config.DepthMode.DISABLED
                }
                config.lightEstimationMode = Config.LightEstimationMode.ENVIRONMENTAL_HDR
            },
            onGestureListener = rememberOnGestureListener(
                onSingleTapConfirmed = { e: MotionEvent, node: Node? ->
                    if (node == null) {
                        val hitTestResult = frame.value?.hitTest(e.x, e.y)
                        hitTestResult?.firstOrNull {
                            it.isValid(depthPoint = false, point = false)
                        }?.createAnchorOrNull()?.let { anchor ->
                            // Remove previous model before adding a new one
                            childNodes.clear()
                            val anchorNode = AnchorNode(engine = engine, anchor = anchor)
                            val modelNode = ModelNode(
                                modelInstance = modelLoader.createModelInstance("models/$model"),
                                scaleToUnits = 0.2f,
                                centerOrigin = Position(0f)
                            ).apply {
                                isEditable = true
                            }
                            anchorNode.addChildNode(modelNode)
                            childNodes.add(anchorNode)
                        }
                    }
                }
            )
        )
        Text(
            text = "Tap on ground to place drill marker",
            modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 24.dp),
            color = Color.White,
            fontSize = 16.sp
        )
    }
}
