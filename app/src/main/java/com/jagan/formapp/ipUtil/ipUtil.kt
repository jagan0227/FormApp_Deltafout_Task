package com.jagan.formapp.ipUtil

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jagan.formapp.R
import com.jagan.formapp.ui.theme.blackGlance
import com.jagan.formapp.ui.theme.blackGlance1
import com.jagan.formapp.ui.theme.blackGlance2
import com.jagan.formapp.ui.theme.blueColor
import com.jagan.formapp.ui.theme.whiteGlance


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownIP(listItems: Array<String>, placeHolder: String) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    var selectedText by rememberSaveable { mutableStateOf("") }
    var dropDownWidth by rememberSaveable { mutableStateOf(0) }

    Column {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth()
                .onSizeChanged {
                    dropDownWidth = it.width
                }
                .onFocusChanged {
                    if (it.isFocused) {
                        expanded = !expanded
                    }
                },
            readOnly = true,
            placeholder = { Text(placeHolder, fontSize = 13.sp) },
            trailingIcon = {
                Image(if (expanded) painterResource(id = R.drawable.arrowdown) else painterResource(
                    id = R.drawable.arrowup
                ), null, Modifier.clickable { expanded = !expanded })
            },
            textStyle = TextStyle.Default.copy(fontSize = 13.sp),
            shape = MaterialTheme.shapes.small.copy(all = CornerSize(0.dp)),
            colors = TextFieldDefaults.textFieldColors(
                unfocusedIndicatorColor = blackGlance2, containerColor = Color.Transparent
            )
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .background(Color.White)
                .width(with(LocalDensity.current) { dropDownWidth.toDp() })
        ) {
            listItems.forEachIndexed { index, item ->
                DropdownMenuItem(text = {
                    Column {
                        Text(item, fontSize = 12.sp, color = blackGlance1)
                    }
                }, onClick = {
                    selectedText = item
                    expanded = false
                }, modifier = Modifier.height(35.dp)
                )
                if (index != listItems.size - 1) {
                    Divider(Modifier.background(blackGlance2))
                }
            }

        }
    }
}

@Composable
fun ExpandableBar(name: String, subname: String, onclick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(65.dp)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFefefef), Color.Transparent
                    ), // Adjust colors as needed
                    startY = 75f,
                    endY = 120f // Adjust the endY value based on the height of the row
                )
            )
    ) {

        Row(modifier = Modifier
            .clickable { onclick() }
            .fillMaxWidth()
            .height(45.dp)
            .background(whiteGlance)
            .padding(start = 8.dp, end = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {

            Text(text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = 15.sp, fontWeight = FontWeight.Bold
                    )
                ) {
                    append(name)
                }

                withStyle(
                    style = SpanStyle(
                        fontSize = 10.sp,
                    )
                ) {
                    append(" $subname")
                }
            }, color = blackGlance)

            Icon(
                painterResource(id = R.drawable.arrowdown),
                null,
                tint = blueColor,
                modifier = Modifier.size(20.dp)
            )
        }

    }
}

@Composable
fun TopAppBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .paint(
                painterResource(id = R.drawable.barimg), contentScale = ContentScale.FillWidth
            )
            .padding(start = 10.dp, end = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically

    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { /*TODO*/ }, modifier = Modifier
                    .clip(
                        RoundedCornerShape(50)
                    )
                    .background(blueColor)
                    .width(40.dp)
                    .height(40.dp)
            ) {
                Icon(
                    painterResource(id = R.drawable.back),
                    "back",
                    Modifier.size(20.dp),
                    tint = Color.White
                )
            }
            Text(
                text = "Create Safety Work Permit",
                color = Color.White,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(10.dp)
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            IconButton(
                onClick = { /*TODO*/ }, modifier = Modifier
                    .clip(
                        RoundedCornerShape(50)
                    )
                    .background(blueColor)
                    .width(40.dp)
                    .height(40.dp)

            ) {
                Icon(
                    painterResource(id = R.drawable.formcomplete),
                    "auto-fill",
                    Modifier.size(20.dp),
                    tint = Color.White
                )
            }
            Spacer(modifier = Modifier.height(9.dp))
            Text(
                text = "Magic Auto-Fill",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}