package com.example.compose

import android.content.ContentValues
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class Person(
    val id : Int,
    val firstName : String,
    val lastName : String,
    val age : Int,
)

class PersonRepository{
    fun getAllData() : List<Person> {
        return listOf(
            Person(
                id = 0,
                firstName = "Mansur",
                lastName = "Mirzayev",
                age = 26
            ),
            Person(
                id = 1,
                firstName = "Mansur",
                lastName = "Mirzayev",
                age = 25
            ),
            Person(
                id = 2,
                firstName = "Mansur",
                lastName = "Mirzayev",
                age = 23
            ),
            Person(
                id = 3,
                firstName = "Mansur",
                lastName = "Mirzayev",
                age = 24
            ),
            Person(
                id = 4,
                firstName = "Mansur",
                lastName = "Mirzayev",
                age = 46
            ),
            Person(
                id = 5,
                firstName = "Mansur",
                lastName = "Mirzayev",
                age = 55
            ),
            Person(
                id = 6,
                firstName = "Mansur",
                lastName = "Mirzayev",
                age = 56
            ),
            Person(
                id = 7,
                firstName = "Mansur",
                lastName = "Mirzayev",
                age = 96
            ),
            Person(
                id = 8,
                firstName = "Mansur",
                lastName = "Mirzayev",
                age = 86
            ),
            Person(
                id = 9,
                firstName = "Mansur",
                lastName = "Mirzayev",
                age = 66
            ),
            Person(
                id = 10,
                firstName = "Mansur",
                lastName = "Mirzayev",
                age = 86
            ),
            Person(
                id = 11,
                firstName = "Mansur",
                lastName = "Mirzayev",
                age = 76
            ),
            Person(
                id = 12,
                firstName = "Mansur",
                lastName = "Mirzayev",
                age = 16
            ),
            Person(
                id = 13,
                firstName = "Mansur",
                lastName = "Mirzayev",
                age = 6
            ),
        )
    }
}

@Composable
fun CustomItem(person: Person){
    Row(
       modifier = Modifier
           .background(Color.LightGray)
           .fillMaxWidth()
           .padding(24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "${person.age}",
            color = Color.Black,
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = person.firstName,
            color = Color.Black,
            fontSize = MaterialTheme.typography.titleMedium.fontSize,
            fontWeight = FontWeight.Normal
        )
        Text(
            text = person.lastName,
            color = Color.Black,
            fontSize = MaterialTheme.typography.titleMedium.fontSize,
            fontWeight = FontWeight.Normal
        )
    }
}

@Composable
fun LazyColumnExample(){
    val personRepository = PersonRepository()
    val getAllData = personRepository.getAllData()
    
    LazyColumn(
        contentPadding= PaddingValues(all = 12.dp), // ekrandan 12dp uzoqlashadi
        verticalArrangement = Arrangement.spacedBy( 12.dp) // har bir itemning ostidan 12.dp space ajratadi
    ){
        items(items = getAllData){ person ->
            CustomItem(person = person)
        }
//        itemsIndexed(
//            items = getAllData,
//        ){index, person -> // index->ekranda ko'rilgan item indexi
//            CustomItem(person = person)
//        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyColumnStickyHeader(){
    val sections = listOf("A", "B", "C", "D", "F", "G", "J", "H")

    LazyColumn(
        contentPadding = PaddingValues(all = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ){
        sections.forEach {section ->
            stickyHeader {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.LightGray)
                        .padding(12.dp),
                    text = "Section $section"
                )
            }
            items(5){
                Text(
                    modifier = Modifier
                        .padding(12.dp),
                    text = "Item $it from the section $section"
                )
            }
        }
    }
}

@Composable
@Preview
fun CustomItemPreview(){
    CustomItem(Person(0, "Jhon", "Doe", 20))
}

@Composable
@Preview
fun LazyColumnExamplePreview(){
    LazyColumnExample()
}