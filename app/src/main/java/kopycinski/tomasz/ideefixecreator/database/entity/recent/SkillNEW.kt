package kopycinski.tomasz.ideefixecreator.database.entity.recent

import android.content.Context
import androidx.room.Entity
import androidx.room.PrimaryKey
import kopycinski.tomasz.ideefixecreator.R

@Entity
data class SkillNEW(
    override val name: String,
    override val description: String,
    override val baseLevel: Int,
    val attributeID: Long,
    @PrimaryKey(autoGenerate = true) val skillID: Long = 0
) : Statistic() {
    companion object {

        const val COMMON_BASE_LEVEL: Int = 8
        const val UNCOMMON_BASE_LEVEL: Int = 4
        const val RARE_BASE_LEVEL: Int = 0

        fun skillList(context: Context): List<SkillNEW> {
            val skillList = mutableListOf<SkillNEW>()

            skillList.addAll(physicalSkills(context))
            skillList.addAll(determinationSkills(context))
            skillList.addAll(intelligenceSkills(context))
            skillList.addAll(perceptionSkills(context))
            skillList.addAll(dexteritySkills(context))
            skillList.addAll(agilitySkills(context))

            return skillList
        }

        private fun physicalSkills(context: Context): List<SkillNEW> {
            val id = AttributeNEW.PHYSIQUE_ID

            return listOf(
                SkillNEW(
                    context.getString(R.string.skill_physique_strength),
                    "Opis siły",
                    COMMON_BASE_LEVEL,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_physique_swimming),
                    "Opis pływania",
                    COMMON_BASE_LEVEL,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_physique_heavy_lifter),
                    "Opis pływania",
                    COMMON_BASE_LEVEL,
                    attributeID = id,
                )
            )
        }

        private fun determinationSkills(context: Context): List<SkillNEW> {
            val id = AttributeNEW.DETERMINATION_ID

            return listOf(
                SkillNEW(
                    context.getString(R.string.skill_determination_pain_resistance),
                    "Opis odporności na ból",
                    COMMON_BASE_LEVEL,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_determination_fight_sense),
                    "Opis instynktu walki",
                    UNCOMMON_BASE_LEVEL,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_determination_meditation),
                    "Opis instynktu walki",
                    UNCOMMON_BASE_LEVEL,
                    attributeID = id
                )
            )
        }

        private fun intelligenceSkills(context: Context): List<SkillNEW> {
            val id = AttributeNEW.INTELLIGENCE_ID

            return listOf(
                SkillNEW(
                    context.getString(R.string.skill_intelligence_read_and_write),
                    "Opis czytania i pisania",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_intelligence_native_language),
                    "Opis języka ojczystego",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_intelligence_dressing_up),
                    "Opis przebierania się",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_intelligence_electronics_usage),
                    "Opis przebierania się",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_intelligence_computer_usage),
                    "Opis przebierania się",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_intelligence_data_analysis),
                    "Opis przebierania się",
                    UNCOMMON_BASE_LEVEL,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_intelligence_bioengineering),
                    "Opis przebierania się",
                    UNCOMMON_BASE_LEVEL,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_intelligence_biology),
                    "Opis przebierania się",
                    UNCOMMON_BASE_LEVEL,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_intelligence_chemistry),
                    "Opis przebierania się",
                    UNCOMMON_BASE_LEVEL,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_intelligence_science),
                    "Opis przebierania się",
                    UNCOMMON_BASE_LEVEL,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_intelligence_it),
                    "Opis przebierania się",
                    UNCOMMON_BASE_LEVEL,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_intelligence_civil_engineering),
                    "Opis przebierania się",
                    UNCOMMON_BASE_LEVEL,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_intelligence_electrical_engineering),
                    "Opis przebierania się",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_intelligence_mechanical_engineering),
                    "Opis przebierania się",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_intelligence_microtronical_engineering),
                    "Opis przebierania się",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_intelligence_nucleonical_engineering),
                    "Opis przebierania się",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_intelligence_mathematics),
                    "Opis przebierania się",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_intelligence_medicine),
                    "Opis przebierania się",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_intelligence_nano_engineering),
                    "Opis przebierania się",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_intelligence_sport),
                    "Opis przebierania się",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_intelligence_conspiracy_stories),
                    "Opis przebierania się",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_intelligence_memory_techniques),
                    "Opis przebierania się",
                    RARE_BASE_LEVEL,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_intelligence_web_surfing),
                    "Opis przebierania się",
                    RARE_BASE_LEVEL,
                    attributeID = id
                )
            )
        }

        private fun perceptionSkills(context: Context): List<SkillNEW> {
            val id = AttributeNEW.PERCEPTION_ID

            return listOf(
                SkillNEW(
                    context.getString(R.string.skill_perception_computer_games),
                    "Opis gier komputerowych",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_perception_communication),
                    "Opis komunnikacji",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_perception_manipulation),
                    "Opis manipulacji",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_perception_observation),
                    "Opis manipulacji",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_perception_remote_control),
                    "Opis manipulacji",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_perception_hide_and_search),
                    "Opis manipulacji",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_perception_ars_amandi),
                    "Opis manipulacji",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_perception_deck_gun),
                    "Opis manipulacji",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_perception_cyber_engineering),
                    "Opis manipulacji",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_perception_electrotechnology),
                    "Opis manipulacji",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_perception_mechanics),
                    "Opis manipulacji",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_perception_memetics),
                    "Opis manipulacji",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_perception_microtechnology),
                    "Opis manipulacji",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_perception_navigation),
                    "Opis manipulacji",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_perception_ancient_electronics),
                    "Opis manipulacji",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_perception_paramedic),
                    "Opis manipulacji",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_perception_city_survival),
                    "Opis manipulacji",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_perception_gunsmith),
                    "Opis manipulacji",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_perception_minesweeper),
                    "Opis manipulacji",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_perception_gray_hat),
                    "Opis manipulacji",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_perception_security_systems),
                    "Opis manipulacji",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_perception_survival),
                    "Opis manipulacji",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_perception_make_up),
                    "Opis manipulacji",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_perception_knowledge_of_large_area),
                    "Opis manipulacji",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_perception_knowledge_of_city),
                    "Opis manipulacji",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_perception_knowledge_of_small_area),
                    "Opis manipulacji",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_perception_lip_reading),
                    "Opis manipulacji",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_perception_sewering),
                    "Opis manipulacji",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_perception_kerning),
                    "Opis manipulacji",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_perception_connection),
                    "Opis manipulacji",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_perception_survival_in_mutated_areas),
                    "Opis manipulacji",
                    8,
                    attributeID = id
                )
            )
        }

        private fun dexteritySkills(context: Context): List<SkillNEW> {
            val id = AttributeNEW.DEXTERITY_ID

            return listOf(
                SkillNEW(
                    context.getString(R.string.skill_dexterity_long_weapons),
                    "Opis broni długiej",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_dexterity_short_weapons),
                    "Opis broni krótkiej",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_dexterity_first_aid),
                    "Opis pierwszej pomocy",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_dexterity_throwing),
                    "Opis pierwszej pomocy",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_dexterity_cars),
                    "Opis pierwszej pomocy",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_dexterity_heavy_weaponry),
                    "Opis pierwszej pomocy",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_dexterity_boats),
                    "Opis pierwszej pomocy",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_dexterity_ground_vehicles),
                    "Opis pierwszej pomocy",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_dexterity_parachutist),
                    "Opis pierwszej pomocy",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_dexterity_locksmith),
                    "Opis pierwszej pomocy",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_dexterity_hovercraft),
                    "Opis pierwszej pomocy",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_dexterity_powered_lift_aircraft),
                    "Opis pierwszej pomocy",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_dexterity_illusionist),
                    "Opis pierwszej pomocy",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_dexterity_planes),
                    "Opis pierwszej pomocy",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_dexterity_zeppelins),
                    "Opis pierwszej pomocy",
                    8,
                    attributeID = id
                )
            )
        }

        private fun agilitySkills(context: Context): List<SkillNEW> {
            val id = AttributeNEW.AGILITY_ID

            return listOf(
                SkillNEW(
                    context.getString(R.string.skill_agility_quarterstaff),
                    "Opis broni drzewcowej",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_agility_blunt_weapons),
                    "Opis broni obuchowej",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_agility_athletics),
                    "Opis lekkoatletyki",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_agility_swords),
                    "Opis lekkoatletyki",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_agility_motorcycles),
                    "Opis lekkoatletyki",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_agility_knifes),
                    "Opis lekkoatletyki",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_agility_power_armor),
                    "Opis lekkoatletyki",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_agility_bikes),
                    "Opis lekkoatletyki",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_agility_sneaking),
                    "Opis lekkoatletyki",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_agility_fencing),
                    "Opis lekkoatletyki",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_agility_melee),
                    "Opis lekkoatletyki",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_agility_wrestle),
                    "Opis lekkoatletyki",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_agility_climbing),
                    "Opis lekkoatletyki",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_agility_chain_weapons),
                    "Opis lekkoatletyki",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_agility_boards),
                    "Opis lekkoatletyki",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_agility_exoskeletons),
                    "Opis lekkoatletyki",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_agility_skates),
                    "Opis lekkoatletyki",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_agility_quick_draw),
                    "Opis lekkoatletyki",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_agility_microgravity),
                    "Opis lekkoatletyki",
                    8,
                    attributeID = id
                ),
                SkillNEW(
                    context.getString(R.string.skill_agility_escape),
                    "Opis lekkoatletyki",
                    8,
                    attributeID = id
                )
            )
        }
    }
}
