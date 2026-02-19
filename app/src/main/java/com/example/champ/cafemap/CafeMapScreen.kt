package com.example.champ.cafemap

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.champ.R
import com.example.champ.Route
import com.example.champ.common.MyDialog
import com.example.champ.common.MyIcon
import com.example.champ.ui.theme.MainTheme
import com.example.champ.ui.theme.bgW
import com.example.champ.ui.theme.blue3
import com.example.champ.ui.theme.green1
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView
import com.yandex.runtime.image.ImageProvider

@Composable
fun CafeMapScreen(navController: NavController, viewModel: CafeMapViewModel = hiltViewModel()) {
    val state = viewModel.state.value
    LaunchedEffect(state.isSuccess) {
        if (state.isSuccess) {
            navController.navigate(Route.Menu())
        }
    }
    val context = LocalContext.current
    val mapView = remember { MapView(context) }
    val mapObjects = remember { mapView.map.mapObjects.addCollection() }
    val isPermission = rememberSaveable { mutableStateOf(false) }

    DisposableEffect(Unit) {
        mapView.onStart()
        MapKitFactory.getInstance().onStart()
        onDispose {
            mapView.onStop()
            MapKitFactory.getInstance().onStop()
        }
    }
    if (!isPermission.value) {
        GetPermission({ viewModel.onEvent(CafeMapEvents.OnOpenDialog) }
        ) {
            isPermission.value = true
        }
    }
    LaunchedEffect(isPermission.value) {
        if (isPermission.value) {
            getUserLocation(context) {
                viewModel.onEvent(CafeMapEvents.UpdateUser(it))
            }
        }

    }
    LaunchedEffect(state.user) {
        state.user?.let {
            val placemark = mapView.map.mapObjects.addPlacemark(it)
            placemark.setIcon(
                ImageProvider.fromResource(context, R.drawable.user_point)
            )
            moveHome(mapView, it)
        }
    }
    LaunchedEffect(state.cafes) {
        mapObjects.clear()
        state.cafes.forEach {
            val placemark = mapView.map.mapObjects.addPlacemark(Point(it.latitude, it.longitude))
            placemark.setIcon(
                ImageProvider.fromResource(context, R.drawable.cafe_point)
            )
        }
    }
    Box() {
        AndroidView(factory = { mapView }, modifier = Modifier.fillMaxSize())
        Column(modifier = Modifier.align(Alignment.BottomCenter)) {
            Row {
                Spacer(Modifier.weight(1f))
                FloatingActionButton(onClick = {
                    state.user?.let {
                        moveHome(mapView,it)
                    }
                },
                    shape = CircleShape,
                    containerColor = blue3,
                    elevation = FloatingActionButtonDefaults.elevation(
                        defaultElevation = 0.dp,
                        pressedElevation = 0.dp,
                        focusedElevation = 0.dp,
                        hoveredElevation = 0.dp,
                    )) {
                    MyIcon(R.drawable.locate, tintColor = bgW) {
                        state.user?.let {
                            moveHome(mapView,it)
                        }
                    }
                }
                Spacer(Modifier.width(30.dp))
            }
            Spacer(Modifier.height(35.dp))
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(topEnd = 25.dp, topStart = 25.dp))
                    .background(
                        green1
                    )
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Выберите кофейню Coffee break",
                    modifier = Modifier.padding(vertical = 30.dp),
                    style = MainTheme.typography.authTextField.copy(fontSize = 16.sp, color = bgW)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(topEnd = 25.dp, topStart = 25.dp))
                        .background(
                            MainTheme.colorScheme.cafeBg
                        )
                        .padding(vertical = 20.dp, horizontal = 30.dp)
                ) {
                    if (state.isLoading) {
                        Text("Downloading", color = MainTheme.colorScheme.default)
                    } else {
                        Column(verticalArrangement = Arrangement.spacedBy(7.dp)) {
                            repeat(3) {
                                Row(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(16.dp))
                                        .background(green1)
                                        .padding(14.dp)
                                        .fillMaxWidth()
                                        .clickable {

                                            viewModel.onEvent(CafeMapEvents.OnAddressClick(state.cafes[it].address))
                                        },
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    MyIcon(R.drawable.address, tintColor = bgW)
                                    Spacer(Modifier.width(11.dp))
                                    Text(state.cafes[it].address, style = MainTheme.typography.robotoSB, color = bgW)
                                    Spacer(Modifier.weight(1f))
                                    MyIcon(R.drawable.next2, tintColor = bgW)
                                }
                            }
                        }
                    }

                }
            }
        }
    }
    MyDialog(state.isError, state.error) {
        viewModel.onEvent(CafeMapEvents.OnCloseDialog)
    }
    LaunchedEffect(state.isSettings) {
        if (state.isSettings) {
            openSettings(context)
        }
    }
}

fun moveHome(mapView: MapView, point: Point) {
    mapView.map.move(
        CameraPosition(
            point,
            15f,
            0f,
            0f
        ),
        Animation(Animation.Type.SMOOTH, 1f), null
    )
}


@Composable
fun GetPermission(settings: () -> Unit, action: () -> Unit) {
    val launcher =
        rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                action()
            } else {
                settings()
            }
        }
    LaunchedEffect(Unit) {
        launcher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
    }

}

@SuppressLint("MissingPermission")
fun getUserLocation(context: Context, action: (Point) -> Unit) {
    val t = LocationServices.getFusedLocationProviderClient(context)
    t.getCurrentLocation(Priority.PRIORITY_HIGH_ACCURACY, null)
        .addOnSuccessListener { i ->
            if (i != null) {
                action(Point(i.latitude, i.longitude))
            }

        }

}

fun openSettings(context: Context) {
    val intent = Intent(
        Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
        Uri.fromParts("package", context.packageName, null)
    )
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    context.startActivity(intent)
}