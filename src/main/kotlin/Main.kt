fun main(){
var ankara=AnkaraFabric("Dotted")
    println(ankara.predictDesignChange(20,"happy"))


var drum=Drum("leather","medium","auto")
    println(drum.makeSound())

var drum2=Djembe("cotton","small","bass")
    println(drum2.makeSound())

    var drum3=Bougaragou("cotton","small","bass")
    println(drum3.makeSound())

    var drum4=TalkingDrum("cotton","small","bass")
    println(drum4.makeSound())




    val myAnkara = Ankara("floral")
    myAnkara.changePattern(25, "happy")
    println("New Ankara pattern: ${myAnkara.pattern}") // Output: New Ankara pattern: unchanged

    myAnkara.changePattern(35, "happy")
    println("New Ankara pattern: ${myAnkara.pattern}") // Output: New Ankara pattern: bright and vibrant

    myAnkara.changePattern(15, "sad")
    println("New Ankara pattern: ${myAnkara.pattern}") // Output: New Ankara pattern: dark and subdued


    val forecast = MigrationForecast()
    println(forecast.predictMovement("sunny", 3, "south"))

    val forecastt = MigrationForecastt()
    println(forecastt.predictMovement("sunny", 3, "south"))

    println(forecastt.predictWaterCrossing(7))

    println(forecastt.predictPredatorAttack("west"))

    val planner = MoviePlanner()
    // Add a new project
    val project1 = MovieProject("The Lion King", mutableListOf("Simba", "Nala"), "June 2022", 1000000.0)
    val project2 = MovieProject("The Lion King", mutableListOf("Donald Glover", "Beyonce", "James Earl Jones"), "July 2022", 250000000.0)
    planner.addProject(project1)
    planner.addProject(project2)
//    planner.removeProject(project1)
    // Update project details
    val newCastMembers = mutableListOf("Simba", "Nala", "Timon", "Pumbaa")
    planner.updateProjectDetails(project1, newCastMembers, "July 2022", 1500000.0)
    // Generate report
    planner.generateReport()
    project1.adjustBudget(-50000000.0)
    project1.addCastMember("Mark Ruffalo")
    project1.removeCastMember("Scarlett Johansson")
    project2.updateShootingSchedule("August 2022")


}

//You are a fashion designer known for your unique vibrant Ankara designs.Recently
//you've discovered that some of your fabric patterns change their designs based on
//the temperature and mood of the wearer.You want to create a software that can predict the
//changes in the fabric design given the mood and temperature data. Think about the classes you
//will need to  model the changing Ankara and how to predict the changes

class AnkaraFabric(var pattern:String) {
    // properties and methods

fun predictDesignChange(temperature: Int, mood: String): String {
    if (temperature > 25 && mood == "happy") {
        return "$pattern changes to brignt and bold design"
    } else if (temperature < 15 && mood == "sad") {
        return "$pattern will change to muted and subdued design"
    } else {
        return "$pattern will remain default design"
    }
}
    }

class Ankara(var pattern: String) {
    fun changePattern(temperature: Int, mood: String) {
        if (temperature > 30 && mood == "happy") {
            pattern = "bright and vibrant"
        } else if (temperature < 20 && mood == "sad") {
            pattern = "dark and subdued"
        } else {
            pattern = "unchanged"
        }
    }
}


//Every year, millions of wildebeest, zebras, and other animals participate in great migration
//across the Serengeti -Mara ecosystem. As a conservationist, you want to develop a software system
//that models this migration, predicting the movement of the herds based on the weather patterns,
//rivers levels, predator locations, and the various factors that influence the migration .
class MigrationForecast {
    fun predictMovement(weather: String, riverLevel: Int, predatorLocation: String): String {
        if (weather == "sunny" && riverLevel < 5 && predatorLocation == "south") {
            return "The herds will move north."
        } else if (weather == "rainy" && riverLevel > 10 && predatorLocation == "west") {
            return "The herds will move east."
        } else {
            return "The herds will stay put."
        }
    }
}

class MigrationForecastt {
    fun predictMovement(weather: String, riverLevel: Int, predatorLocation: String): String {
        if (weather == "sunny" && riverLevel < 5 && predatorLocation == "south") {
            return "The herds will move north"
        } else if (weather == "rainy" && riverLevel > 10 && predatorLocation == "west") {
            return "The herds will move east"
        } else {
            return "The herds will stay in their current location"
        }
    }
    fun predictWaterCrossing(riverLevel: Int): String {
        if (riverLevel > 5 && riverLevel < 10) {
            return "The herds will attempt to cross the river"
        } else if (riverLevel >= 10) {
            return "The herds will not attempt to cross the river"
        } else {
            return "The herds will easily cross the river"
        }
    }
    fun predictPredatorAttack(predatorLocation: String): String {
        if (predatorLocation == "north") {
            return "The herds will move south to avoid predators"
        } else if (predatorLocation == "east") {
            return "The herds will move west to avoid predators"
        } else {
            return "The herds are safe from predators"
        }
    }
}

//AS a producer in the booming Nollywood movie industry , you are in charge of multiple
//film projects at once.Each movie has different cast members , shooting schedules , and budgets .
//You want to write a program to help manage your film projects efficiently .
//The software should be able to handle he complexities of scheduling ,budgeting and
//coordinating between different movie projects.
class MovieProject(
    val title: String,
    var castMembers: MutableList<String>,
    var shootingSchedule: String,
    var budget: Double
) {
    fun addCastMember(castMember: String) {
        castMembers.add(castMember)
    }
//    fun removeCastMember(castMember: String) {
//        castMembers.remove(castMember)
//    }
fun removeCastMember(castMember: String) {
    if (castMembers.contains(castMember)) {
        castMembers.remove(castMember)
    } else {
        println("$castMember is not a cast member of this project.")
    }
}
    fun updateShootingSchedule(schedule: String) {
        shootingSchedule = schedule
    }
//    fun adjustBudget(amount: Double) {
//        budget += amount
//    }
fun adjustBudget(amount: Double) {
    if (budget + amount >= 0) {
        budget += amount
    } else {
        println("Error: Budget cannot be negative.")
    }
}
}

class MoviePlanner {
    val projects = mutableListOf<MovieProject>()

    fun addProject(project: MovieProject) {
        projects.add(project)
    }
//    fun removeProject(project: MovieProject) {
//        projects.remove(project)
//    }
fun removeProject(project: MovieProject) {
    if (projects.contains(project)) {
        projects.remove(project)
    } else {
        println("${project.title} is not a project in the planner.")
    }
}
    fun updateProjectDetails(project: MovieProject, castMembers: MutableList<String>, schedule: String, budget: Double) {
        project.castMembers = castMembers
        project.shootingSchedule = schedule
        project.budget = budget
    }
    fun generateReport() {
        for (project in projects) {
            println("Title: ${project.title}")
            println("Cast Members: ${project.castMembers}")
            println("Shooting Schedule: ${project.shootingSchedule}")
            println("Budget: ${project.budget}")
            println()
        }
    }
}


 open class Drum(var material:String,var size:String,var tone:String){
    open fun makeSound():String{
        return "This drum is of $material material of $size size with $tone tone"
    }
}
class Djembe(material:String,size:String,tone:String):Drum(material,size,tone){
    override fun makeSound():String{
        return "The Djembe of $material material of $tone is of $size size"
    }
}
class Bougaragou(material:String,size:String,tone:String):Drum(material,size,tone){
    override fun makeSound():String{
        return "The Bougaragou of $material material of $tone is of $size size"
    }
}
class TalkingDrum(material:String,size:String,tone:String):Drum(material,size,tone){
    override fun makeSound():String{
        return "The Talking Drum of $material material of $tone is of $size size"
    }
}

