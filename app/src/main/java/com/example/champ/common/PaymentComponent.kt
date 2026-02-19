package com.example.champ.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import com.example.champ.R
import com.example.champ.Route
import com.example.champ.my_order.MyOrderEvents
import com.example.champ.my_order.MyOrderViewModel
import com.example.champ.placed.PlacedViewModel
import com.example.champ.ui.theme.MainTheme
import com.example.champ.ui.theme.bgW
import com.example.champ.ui.theme.blue3
import com.example.champ.ui.theme.darkBlue
import com.example.champ.ui.theme.gray4

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentComponent(name: String, address: String, viewModel: MyOrderViewModel, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Spacer(Modifier.height(150.dp))
        Dialog(
            { viewModel.onEvent(MyOrderEvents.OnPaymentChange) },
            properties = DialogProperties(usePlatformDefaultWidth = false)
        ) {
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(topEnd = 35.dp, topStart = 35.dp))
                    .background(MainTheme.colorScheme.bg)
            ) {
                Column(modifier = Modifier.padding(horizontal = 33.dp)) {
                    Spacer(Modifier.height(35.dp))
                    Text(stringResource(R.string.payment))
                    Spacer(Modifier.weight(1f))

                    Row {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(12.dp))
                                .background(gray4)
                        ) {
                            MyIcon(
                                R.drawable.cart,
                                tintColor = darkBlue,
                                modifier = Modifier
                                    .padding(13.dp)
                                    .align(Alignment.Center)
                            )
                        }
                        Spacer(Modifier.width(24.dp))
                        Column {
                            Text(name)
                            Spacer(Modifier.height(5.dp))
                            Text(address)
                        }
                    }
                    Spacer(Modifier.height(46.dp))
                    PaymentMethod(
                        viewModel.state.value.method == 1,
                        stringResource(R.string.payment_online),
                        stringResource(R.string.sbp), // viewModel.onEvent(OnPaymentMethodChange(1))
                        { viewModel.onEvent(MyOrderEvents.OnPaymentMethodChange(1)) }
                    ) {
                        Image(painter = painterResource(R.drawable.sbp), null)
                    }
                    Spacer(Modifier.height(19.dp))

                    PaymentMethod(
                        viewModel.state.value.method != 1,
                        stringResource(R.string.card),
                        stringResource(R.string.card_num),
                        { viewModel.onEvent(MyOrderEvents.OnPaymentMethodChange(2)) }
                    ) {
                        Image(painter = painterResource(R.drawable.mir), null)
                        Spacer(Modifier.width(7.dp))
                        Image(painter = painterResource(R.drawable.union), null)
                    }
                    Spacer(Modifier.weight(2f))

                    Row {
                        Column(
                            modifier = Modifier.weight(1f),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Column(horizontalAlignment = Alignment.End) {

                                Text(
                                    stringResource(R.string.total_sum), color = darkBlue.copy(
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
                                .weight(1f)
                                .clickable {
                                    navController.navigate(Route.Placed)
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.SpaceAround,
                                modifier = Modifier
                                    .padding(vertical = 15.dp)
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                MyIcon(R.drawable.card, tintColor = bgW)
                                Text(
                                    stringResource(R.string.pay_now),
                                    style = MainTheme.typography.robotoSB,
                                    color = bgW,
                                    minLines = 2
                                )
                            }
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun PaymentMethod(
    isSBP: Boolean,
    text: String,
    desc: String,
    onPaymentChange: () -> Unit,
    content: @Composable () -> Unit
) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(gray4), verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(Modifier.width(21.dp))
        Box(
            modifier = Modifier
                .border(width = 1.dp, color = darkBlue, shape = CircleShape)
                .size(20.dp)
                .clickable {
                    onPaymentChange()
                }
        ) {
            if (isSBP) {
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .clip(CircleShape)
                        .background(darkBlue)
                        .align(Alignment.Center)
                )
            }
        }
        Spacer(Modifier.width(18.dp))

        Column(
            modifier = Modifier
                .padding(vertical = 18.dp)
        ) {
            Text(text)
            Spacer(Modifier.height(7.dp))
            Text(desc)
        }
        Spacer(Modifier.weight(1f))
        content()
        Spacer(Modifier.width(15.dp))
    }
}