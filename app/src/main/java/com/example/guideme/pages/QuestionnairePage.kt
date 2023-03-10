package com.example.guideme.pages


import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.alexstyl.swipeablecard.Direction
import com.alexstyl.swipeablecard.ExperimentalSwipeableCardApi
import com.alexstyl.swipeablecard.rememberSwipeableCardState
import com.alexstyl.swipeablecard.swipableCard
import com.example.guideme.R
import com.example.guideme.UserInfo
import com.example.guideme.components.BackIcon
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.launch

@OptIn(ExperimentalSwipeableCardApi::class)
@Composable
fun QuestionnairePage(User: UserInfo, navController: NavController) {
            TransparentSystemBars()
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            listOf(
                                Color(0xfff68084),
                                Color(0xffa6c0fe),
                            )
                        )
                    )
                    .systemBarsPadding()
            ) {
                Box {
                    val states = profiles.reversed()
                        .map { it to rememberSwipeableCardState() }
                    var hint by remember {
                        mutableStateOf("Swipe a card or press a button below")
                    }

                    Hint(hint,navController)

                    val scope = rememberCoroutineScope()
                    Box(
                        Modifier
                            .padding(24.dp)
                            .fillMaxSize()
                            .aspectRatio(1f)
                            .align(Alignment.Center)
                    ) {
                        states.forEach { (matchProfile, state) ->
                            if (state.swipedDirection == null) {
                                ProfileCard(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .swipableCard(
                                            state = state,
                                            onSwiped = {
                                                // swipes are handled by the LaunchedEffect
                                                // so that we track button clicks & swipes
                                                // from the same place
                                            },
                                            onSwipeCancel = {
                                                Log.d("Swipeable-Card", "Cancelled swipe")
                                                hint = "You canceled the swipe"
                                            }
                                        ),
                                    matchProfile = matchProfile
                                )
                            }
                            LaunchedEffect(matchProfile, state.swipedDirection) {
                                if (state.swipedDirection != null //Only Right or Left) {
                                    hint = "You swiped ${stringFrom(state.swipedDirection!!)}"
                                    User.preferences[matchProfile.index] = state.swipedDirection == Direction.Right
                                }
                            }
                        }
                    }
                    Row(
                        Modifier
                            .align(Alignment.BottomCenter)
                            .padding(horizontal = 24.dp, vertical = 32.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        CircleButton(
                            onClick = {
                                scope.launch {
                                    val last = states.reversed()
                                        .firstOrNull {
                                            it.second.offset.value == Offset(0f, 0f)
                                        }?.second
                                    last?.swipe(Direction.Left)
                                }
                            },
                            icon = Icons.Rounded.Close,
                            Color.White,
                            Color.Red
                        )
                        CircleButton(
                            onClick = {
                                scope.launch {
                                    val last = states.reversed()
                                        .firstOrNull {
                                            it.second.offset.value == Offset(0f, 0f)
                                        }?.second

                                    last?.swipe(Direction.Right)
                                }
                            },
                            icon = Icons.Rounded.Favorite,
                            Color.White,
                            Color.Red
                        )
                    }
                }
            }
}

@Composable
private fun CircleButton(
    onClick: () -> Unit,
    icon: ImageVector,
    background: Color,
    color: Color
) {
    IconButton(
        modifier = Modifier
            .clip(CircleShape)
            .background(background)
            .size(56.dp)
            .border(2.dp, background, CircleShape),
        onClick = onClick
    ) {
        Icon(icon, null,
            tint = color)
    }
}

@Composable
private fun ProfileCard(
    modifier: Modifier,
    matchProfile: MatchProfile,
) {
    Card(modifier) {
        Box {
            Image(contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(matchProfile.drawableResId),
                contentDescription = null)
            Scrim(Modifier.align(Alignment.BottomCenter))
            Column(Modifier.align(Alignment.BottomCenter)) {
                Text(text = matchProfile.name,
                    color = MaterialTheme.colors.onPrimary,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(10.dp))
            }
        }
    }
}

@Composable
private fun Hint(text: String,navController: NavController) {

    BackIcon(onBack = {navController.popBackStack()},Color.White)

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(horizontal = 24.dp, vertical = 32.dp)
            .fillMaxWidth()
    ) {
            Text(
                text = text,
                color = MaterialTheme.colors.onPrimary,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                textAlign = TextAlign.Center
            )
    }
}

@Composable
private fun TransparentSystemBars() {
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = false

    DisposableEffect(systemUiController, useDarkIcons) {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = useDarkIcons,
            isNavigationBarContrastEnforced = false
        )
        onDispose {}
    }
}

private fun stringFrom(direction: com.alexstyl.swipeablecard.Direction): String {
    return when (direction) {
        Direction.Left -> "Left 👈"
        Direction.Right -> "Right 👉"
        Direction.Up -> "Up 👆"
        Direction.Down -> "Down 👇"
    }
}

@Composable
fun Scrim(modifier: Modifier = Modifier) {
    Box(
        modifier
            .background(Brush.verticalGradient(listOf(Color.Transparent, Color.Black)))
            .height(180.dp)
            .fillMaxWidth())
}

data class MatchProfile(
    val index: Int,
    val name: String,
    @DrawableRes val drawableResId: Int,
)

val profiles = listOf(
    MatchProfile(0,"Adventure Tourism", R.drawable.adventure),
    MatchProfile(1,"Business Tourism", R.drawable.business),
    MatchProfile(2,"Cultural Tourism", R.drawable.cultural),
    MatchProfile(3,"Familiar Tourism", R.drawable.familiar),
    MatchProfile(4,"Gastronomic Tourism", R.drawable.gastronomic),
    MatchProfile(5,"Relaxing Tourism", R.drawable.relax),
    MatchProfile(6,"Rural Tourism", R.drawable.rural),
)
