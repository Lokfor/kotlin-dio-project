enum class Level { BASIC, INTERMEDIARY, ADVANCED }
enum class Perm { STUDENT, TEACHER }

data class Users(val fName: String, val lName: String, val email: String, val perm: Perm)

data class EducationalContent(val name: String, val duration: Int, val level: Level)

data class Formation(val name: String, val contents: List<EducationalContent>, val level: Level) {

    val registered = mutableListOf<Users>()
   
    fun addUser(user: Users) {
         registered.add(user)
    }
   
    fun getAddUser(){
        for(user in registered){
            println("|Nome: ${user.fName+" "+user.lName}| - |Email: ${user.email}| - (${user.perm})")
        }
    }
   
    fun printEducationalContent(){
        for(cont in contents){
            println("${cont.name} - ${cont.duration}min - (${cont.level})")
        }
    }
}

fun main() {
 	val moduleKotlinB = EducationalContent("Linguagem Kotlin - Básico", 120, Level.BASIC)
  	val moduleKotlinI = EducationalContent("Linguagem Kotlin - Intermediário", 180, Level.INTERMEDIARY)
    val moduleKotlinA = EducationalContent("Linguagem Kotlin - Avançado", 200, Level.ADVANCED)
   
	val contentList = mutableListOf<EducationalContent>()
  		contentList.add(moduleKotlinB)
    	contentList.add(moduleKotlinI)
        contentList.add(moduleKotlinA)

    val pedro = Users("Pedro","Rodrigues", "pedro.rodrma@gmail.com", Perm.TEACHER)
    val layla = Users("Layla","Alessandra", "layaalessandra@gmail.com", Perm.STUDENT)
   
    val androidTraining = Formation("Formação Android Developer", contentList, Level.INTERMEDIARY)
        androidTraining.addUser(pedro)
        androidTraining.addUser(layla)
   
  	println(" -----------------------------------------")
    println("|${androidTraining.name} - ${androidTraining.level}|")
    println(" -----------------------------------------")
   
    println("Grade do curso")
    println(androidTraining.printEducationalContent())
    println("******************************************")
   
    println("Usuarios cadastrados no curso")
    println(androidTraining.getAddUser())
}