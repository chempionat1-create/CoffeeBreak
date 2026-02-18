package com.example.champ.profile

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.champ.Route
import com.example.champ.common.ProfileItem
import com.example.champ.common.TopBar

@Composable
fun ProfileScreen(navController: NavController, viewModel: ProfileViewModel = hiltViewModel()) {
    val state = viewModel.state.value
    Column(modifier = Modifier.padding(horizontal = 30.dp)) {
        TopBar(isCart = false, navController, "Профиль")
        Spacer(Modifier.height(34.dp))
        if (state.isLoading) {
            Text("Downloading")
        } else {
            state.items.forEach {
                ProfileItem(it.icon, it.title, it.text, it.endIcon) {
                    if (it.title == "QR-код") {
                        navController.navigate(Route.QR)
                    } else {
                        viewModel.onEvent(ProfileEvents.OnOpenDialog(it.title))
                    }
                }
                Spacer(Modifier.height(26.dp))
            }
        }
        Text("EXIT", modifier = Modifier.clickable{
            viewModel.onEvent(ProfileEvents.OnExit)

        })
    }
}