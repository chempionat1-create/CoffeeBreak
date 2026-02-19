package com.example.champ.my_order

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.champ.R
import com.example.champ.Route
import com.example.champ.common.BottomNav
import com.example.champ.common.MyDialog
import com.example.champ.common.MyIcon
import com.example.champ.common.MyOrderItem
import com.example.champ.common.PaymentComponent
import com.example.champ.ui.theme.MainTheme
import com.example.champ.ui.theme.bgW
import com.example.champ.ui.theme.blue3
import com.example.champ.ui.theme.darkBlue

@Composable
fun MyOrderScreen(navController: NavController, viewModel: MyOrderViewModel = hiltViewModel()) {
    val state = viewModel.state.value
    if (state.isLoading) {
        Text("Downloading")
    } else {
        if (state.isPayment) {
            PaymentComponent(
                state.user!!.name, state.user.address ?: "Адрес не выбран",
                viewModel, navController
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MainTheme.colorScheme.bg)
                .padding(25.dp)
        ) {

            MyIcon(R.drawable.back, tintColor = Color.Black) {
                navController.popBackStack()
            }
            Text(
                stringResource(R.string.my_order),
                modifier = Modifier.padding(vertical = 25.dp),
                style = MainTheme.typography.authTextField,
                fontSize = 18.sp,
                color = darkBlue
            )

            LazyColumn(verticalArrangement = Arrangement.spacedBy(21.dp)) {
                items(3) {
                    MyOrderItem(
                        "https://ytizrftfmlltuhekqnzg.supabase.co/storage/v1/object/public/coffees/latte.png",
                        "Латте",
                        "single | iced | medium | full ice",
                        1,
                        100
                    )
                }
            }
            Spacer(Modifier.weight(1f))
            Row {
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Column(horizontalAlignment = Alignment.End) {

                        Text(
                            stringResource(R.string.sum), color = darkBlue.copy(
                                alpha = 0.22f
                            ), style = MainTheme.typography.authTextField
                        )
                        Spacer(Modifier.height(7.dp))
                        Text(
                            "300 ₽",
                            style = MainTheme.typography.welcomeDesc,
                            color = darkBlue
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(30.dp))
                        .background(blue3)
                        .weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .padding(vertical = 15.dp)
                            .fillMaxWidth()
                            .clickable {
                                viewModel.onEvent(MyOrderEvents.OnPaymentChange)
                            }
                    ) {
                        MyIcon(R.drawable.cart, tintColor = bgW)
                        Text(
                            stringResource(R.string.next),
                            style = MainTheme.typography.robotoSB,
                            color = bgW
                        )
                    }
                }
            }
            Spacer(Modifier.height(5.dp))
        }
    }
    MyDialog(state.isError, state.error) {
        viewModel.onEvent(MyOrderEvents.OnCloseDialog)
    }
}
