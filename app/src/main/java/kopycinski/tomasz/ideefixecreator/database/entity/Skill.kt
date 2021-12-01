package kopycinski.tomasz.ideefixecreator.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Skill(
    val attributeId: Long,
    val name: String,
    val description: String,
    var level: Int = 8,
    var upgradeCost: Int = 1,

    @PrimaryKey(autoGenerate = true) val skillId: Long = 0
) {
    companion object {
        fun physicalSkills(attributeId: Long): List<Skill> {
            return listOf(
                Skill(attributeId = attributeId, "Siła", "Opis siły"),
                Skill(attributeId = attributeId, "Pływanie", "Opis pływania")
            )
        }

        fun dexteritySkills(attributeId: Long): List<Skill> {
            return listOf(
                Skill(attributeId = attributeId, "Broń długa", "Opis broni długiej"),
                Skill(attributeId = attributeId, "Broń krótka", "Opis broni krótkiej"),
                Skill(attributeId = attributeId, "Pierwsza pomoc", "Opis pierwszej pomocy")
            )
        }

        fun agilitySkilld(attributeId: Long): List<Skill> {
            return listOf(
                Skill(attributeId = attributeId, "Broń drzewcowa", "Opis broni drzewcowej"),
                Skill(attributeId = attributeId, "Broń obuchowa", "Opis broni obuchowej"),
                Skill(attributeId = attributeId, "Lekkoatletyka", "Opis lekkoatletyki"),
            )
        }

        fun determinationSkills(attributeId: Long): List<Skill> {
            return listOf(
                Skill(attributeId = attributeId, "Odporność na ból", "Opis odporności na ból"),
                Skill(attributeId = attributeId, "Instynkt walki", "Opis instynktu walki")
            )
        }

        fun intelligenceSkills(attributeId: Long): List<Skill> {
            return listOf(
                Skill(attributeId = attributeId, "Czytanie i pisanie", "Opis czytania i pisania"),
                Skill(attributeId = attributeId, "Język ojczysty", "Opis języka ojczystego"),
                Skill(attributeId = attributeId, "Przebieranie się", "Opis przebierania się")
            )
        }

        fun perceptionSkills(attributeId: Long): List<Skill> {
            return listOf(
                Skill(attributeId = attributeId, "Gry komputerowe", "Opis gier komputerowych"),
                Skill(attributeId = attributeId, "Komunikacja", "Opis komunnikacji"),
                Skill(attributeId = attributeId, "Manipulacja", "Opis manipulacji")
            )
        }
    }
}
