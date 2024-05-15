package ru.playzone.database.points
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction


object Points : Table() {
    private val id = Points.varchar("id", 50)
    private val latitude = Points.double("latitude")
    private val longitude = Points.double("longitude")


    fun insert(pointDTO: PointDTO) {
        transaction {
            Points.insert {
                it[id] = pointDTO.id
                it[latitude] = pointDTO.latitude
                it[longitude] = pointDTO.longitude
            }
        }
    }

    fun delete(id2: String){
        transaction {
            Points.deleteWhere { Points.id eq id2 }
        }
    }

    fun fetchPoints(): List<PointDTO> {
        return try {
            transaction {
                Points.selectAll().toList()
                    .map {
                        PointDTO(
                            id = it[Points.id],
                            latitude = it[Points.latitude],
                            longitude = it[Points.longitude],
                            )
                    }
            }
        } catch (e: Exception) {
            emptyList()
        }
    }



}