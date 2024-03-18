package com.example.tugas1ppb.presentation.skill

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.itemsIndexed

@Composable
fun SkillNav(){
    val listSkills = listOf(
        SkillItem(1, "Javascript" , 2),
        SkillItem(1, "Python" , 2),
        SkillItem(1, "Go Lang" , 2),
    )
    Box(modifier= Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    )
    {
        LazyColumn(
            modifier = Modifier.padding(5.dp)
        )
        {
            item{
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    TableCell(
                        text = "Number",
                        alignment = TextAlign.Left,
                        title = true
                    )
                    TableCell(text = "Skill", title = true)
                    TableCell(text = "Rate", title = true)
                }
                Divider(
                    color = Color.LightGray,
                    modifier = Modifier
                        .height(1.dp)
                        .fillMaxHeight()
                        .fillMaxWidth()
                )
            }
            itemsIndexed(listSkills) { _, skill ->
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    TableCell(
                        text = skill.urutan.toString(),
                        alignment = TextAlign.Left
                    )
                    TableCell(text = skill.nama)
                    TableCell(
                        text = skill.rate.toString()
                    )
                }
                Divider(
                    color = Color.LightGray,
                    modifier = Modifier
                        .height(1.dp)
                        .fillMaxHeight()
                        .fillMaxWidth()
                )
            }
        }
    }
}

@Composable
fun RowScope.TableCell(
    text: String,
    alignment: TextAlign = TextAlign.Center,
    title: Boolean = false
) {
    val fontWeight = if (title) FontWeight.Bold else FontWeight.Normal
    Text(
        text = text,
        modifier = Modifier.padding(10.dp),
        fontWeight = fontWeight,
        textAlign = alignment,
    )
}

