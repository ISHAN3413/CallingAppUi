package com.example.callingapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DialPad(
    phoneNumber: String,
    onNumberChange: (String) -> Unit,
    onCallClick: () -> Unit
) {
    val dialPad = listOf(
        "1","2","3",
        "4","5","6",
        "7","8","9",
        "*","0","#"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = if (phoneNumber.isEmpty()) "Enter Number" else phoneNumber,
            textAlign = TextAlign.End,
            fontSize = 32.sp,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier.height(380.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(dialPad.size) { index ->
                DialButton(
                    text = dialPad[index],
                    color = Color(0xFF5E2B01),
                    onClick = {
                        onNumberChange(phoneNumber + dialPad[index])
                    }
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            DialButton(
                text = "C",
                color = Color.Gray,
                onClick = { onNumberChange("") }
            )

            DialButton(
                text = "📞",
                color = Color(0xFF2E7D32),
                onClick = onCallClick
            )
            DialButton(
                text = "⌫",
                color = Color.Gray,
                onClick = {
                    if (phoneNumber.isNotEmpty()) {
                        onNumberChange(phoneNumber.dropLast(1))
                    }
                }
            )
        }
    }
}
@Composable
fun DialButton(
    text: String,
    color: Color,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = color),
        modifier = Modifier
            .size(80.dp)
    ) {
        Text(
            text = text,
            fontSize = 20.sp,
            color = Color.White
        )
    }
}
