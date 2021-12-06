package kopycinski.tomasz.ideefixecreator.database.entity

import android.content.Context
import androidx.room.Entity
import androidx.room.PrimaryKey
import kopycinski.tomasz.ideefixecreator.R

@Entity
data class Skill(
    val attributeId: Long,
    val name: String,
    val description: String,
    var baseLevel: Int = 8,
    var level: Int = baseLevel,
    var upgradeCost: Int = 1,

    @PrimaryKey(autoGenerate = true) val skillId: Long = 0
) {
    companion object {
        fun skillList(attributeIdList: List<Long>, context: Context): List<Skill> {
            val skillList = mutableListOf<Skill>()

            skillList.addAll(physicalSkills(attributeIdList[0], context))
            skillList.addAll(determinationSkills(attributeIdList[1], context))
            skillList.addAll(intelligenceSkills(attributeIdList[2], context))
            skillList.addAll(perceptionSkills(attributeIdList[3], context))
            skillList.addAll(dexteritySkills(attributeIdList[4], context))
            skillList.addAll(agilitySkills(attributeIdList[5], context))

            return skillList
        }

        private fun physicalSkills(attributeId: Long, context: Context): List<Skill> {
            return listOf(
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_physique_strength),
                    "Opis siły"
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_physique_swimming),
                    "Opis pływania"
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_physique_heavy_lifter),
                    "Opis pływania",
                    4
                )
            )
        }

        private fun determinationSkills(attributeId: Long, context: Context): List<Skill> {
            return listOf(
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_determination_pain_resistance),
                    "Opis odporności na ból"
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_determination_fight_sense),
                    "Opis instynktu walki",
                    4
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_determination_meditation),
                    "Opis instynktu walki",
                    4
                )
            )
        }

        private fun intelligenceSkills(attributeId: Long, context: Context): List<Skill> {
            return listOf(
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_intelligence_read_and_write),
                    "Opis czytania i pisania"
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_intelligence_native_language),
                    "Opis języka ojczystego"
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_intelligence_dressing_up),
                    "Opis przebierania się"
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_intelligence_electronics_usage),
                    "Opis przebierania się"
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_intelligence_computer_usage),
                    "Opis przebierania się"
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_intelligence_data_analysis),
                    "Opis przebierania się",
                    4
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_intelligence_bioengineering),
                    "Opis przebierania się",
                    4
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_intelligence_biology),
                    "Opis przebierania się",
                    4
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_intelligence_chemistry),
                    "Opis przebierania się",
                    4
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_intelligence_science),
                    "Opis przebierania się",
                    4
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_intelligence_it),
                    "Opis przebierania się",
                    4
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_intelligence_civil_engineering),
                    "Opis przebierania się",
                    4
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_intelligence_electrical_engineering),
                    "Opis przebierania się",
                    4
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_intelligence_mechanical_engineering),
                    "Opis przebierania się",
                    4
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_intelligence_microtronical_engineering),
                    "Opis przebierania się",
                    4
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_intelligence_nucleonical_engineering),
                    "Opis przebierania się",
                    4
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_intelligence_mathematics),
                    "Opis przebierania się",
                    4
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_intelligence_medicine),
                    "Opis przebierania się",
                    4
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_intelligence_nano_engineering),
                    "Opis przebierania się",
                    4
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_intelligence_sport),
                    "Opis przebierania się",
                    4
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_intelligence_conspiracy_stories),
                    "Opis przebierania się",
                    4
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_intelligence_memory_techniques),
                    "Opis przebierania się",
                    0
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_intelligence_web_surfing),
                    "Opis przebierania się",
                    0
                )
            )
        }

        private fun perceptionSkills(attributeId: Long, context: Context): List<Skill> {
            return listOf(
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_perception_computer_games),
                    "Opis gier komputerowych"
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_perception_communication),
                    "Opis komunnikacji"
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_perception_manipulation),
                    "Opis manipulacji"
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_perception_observation),
                    "Opis manipulacji"
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_perception_remote_control),
                    "Opis manipulacji"
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_perception_hide_and_search),
                    "Opis manipulacji"
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_perception_ars_amandi),
                    "Opis manipulacji",
                    4
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_perception_deck_gun),
                    "Opis manipulacji",
                    4
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_perception_cyber_engineering),
                    "Opis manipulacji",
                    4
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_perception_electrotechnology),
                    "Opis manipulacji",
                    4
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_perception_mechanics),
                    "Opis manipulacji",
                    4
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_perception_memetics),
                    "Opis manipulacji",
                    4
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_perception_microtechnology),
                    "Opis manipulacji",
                    4
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_perception_navigation),
                    "Opis manipulacji",
                    4
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_perception_ancient_electronics),
                    "Opis manipulacji",
                    4
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_perception_paramedic),
                    "Opis manipulacji",
                    4
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_perception_city_survival),
                    "Opis manipulacji",
                    4
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_perception_gunsmith),
                    "Opis manipulacji",
                    4
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_perception_minesweeper),
                    "Opis manipulacji",
                    4
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_perception_gray_hat),
                    "Opis manipulacji",
                    4
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_perception_security_systems),
                    "Opis manipulacji",
                    4
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_perception_survival),
                    "Opis manipulacji",
                    4
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_perception_make_up),
                    "Opis manipulacji",
                    4
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_perception_knowledge_of_large_area),
                    "Opis manipulacji",
                    4
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_perception_knowledge_of_city),
                    "Opis manipulacji",
                    4
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_perception_knowledge_of_small_area),
                    "Opis manipulacji",
                    4
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_perception_lip_reading),
                    "Opis manipulacji",
                    0
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_perception_sewering),
                    "Opis manipulacji",
                    0
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_perception_kerning),
                    "Opis manipulacji",
                    0
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_perception_connection),
                    "Opis manipulacji",
                    0
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_perception_survival_in_mutated_areas),
                    "Opis manipulacji",
                    0
                )
            )
        }

        private fun dexteritySkills(attributeId: Long, context: Context): List<Skill> {
            return listOf(
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_dexterity_long_weapons),
                    "Opis broni długiej"
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_dexterity_short_weapons),
                    "Opis broni krótkiej"
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_dexterity_first_aid),
                    "Opis pierwszej pomocy"
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_dexterity_throwing),
                    "Opis pierwszej pomocy"
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_dexterity_cars),
                    "Opis pierwszej pomocy"
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_dexterity_heavy_weaponry),
                    "Opis pierwszej pomocy",
                    4
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_dexterity_boats),
                    "Opis pierwszej pomocy",
                    4
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_dexterity_ground_vehicles),
                    "Opis pierwszej pomocy",
                    4
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_dexterity_parachutist),
                    "Opis pierwszej pomocy",
                    4
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_dexterity_locksmith),
                    "Opis pierwszej pomocy",
                    4
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_dexterity_hovercraft),
                    "Opis pierwszej pomocy",
                    4
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_dexterity_powered_lift_aircraft),
                    "Opis pierwszej pomocy",
                    0
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_dexterity_illusionist),
                    "Opis pierwszej pomocy",
                    0
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_dexterity_planes),
                    "Opis pierwszej pomocy",
                    0
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_dexterity_zeppelins),
                    "Opis pierwszej pomocy",
                    0
                )
            )
        }

        private fun agilitySkills(attributeId: Long, context: Context): List<Skill> {
            return listOf(
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_agility_quarterstaff),
                    "Opis broni drzewcowej"
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_agility_blunt_weapons),
                    "Opis broni obuchowej"
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_agility_athletics),
                    "Opis lekkoatletyki"
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_agility_swords),
                    "Opis lekkoatletyki"
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_agility_motorcycles),
                    "Opis lekkoatletyki"
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_agility_knifes),
                    "Opis lekkoatletyki"
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_agility_power_armor),
                    "Opis lekkoatletyki"
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_agility_bikes),
                    "Opis lekkoatletyki"
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_agility_sneaking),
                    "Opis lekkoatletyki"
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_agility_fencing),
                    "Opis lekkoatletyki"
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_agility_melee),
                    "Opis lekkoatletyki"
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_agility_wrestle),
                    "Opis lekkoatletyki"
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_agility_climbing),
                    "Opis lekkoatletyki"
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_agility_chain_weapons),
                    "Opis lekkoatletyki",
                    4
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_agility_boards),
                    "Opis lekkoatletyki",
                    4
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_agility_exoskeletons),
                    "Opis lekkoatletyki",
                    4
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_agility_skates),
                    "Opis lekkoatletyki",
                    4
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_agility_quick_draw),
                    "Opis lekkoatletyki",
                    4
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_agility_microgravity),
                    "Opis lekkoatletyki",
                    0
                ),
                Skill(
                    attributeId = attributeId,
                    context.getString(R.string.skill_agility_escape),
                    "Opis lekkoatletyki",
                    0
                )
            )
        }
    }
}
