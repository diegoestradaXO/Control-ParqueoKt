import java.io.BufferedReader
import java.io.File
import java.io.InputStream
import Stage
fun readStage(path: String): ArrayList<String>{
    var stageList = ArrayList<String>()
    val bufferedReader = File(path).bufferedReader()
    val lineList = mutableListOf<String>()
    bufferedReader.useLines { lines -> lines.forEach { lineList.add(it) } }
    lineList.forEach { stageList.addAll((it.split(""))) }
    return stageList
}
fun main(args: Array<String>) {
    var wantsToContinue = true
    val myBuilding = Building()
    do{
        println("""
                Escoja una opcion:
                1.Administrador
                2.Conductor
                3.Salir:
        """.trimIndent())
        val option1 = readLine()!!.toInt()
        if(0 < option1 && option1 < 4){
            if (option1 == 1) {
                var admin = true
                do {
                    println("""
                    Escoja una opcion:
                    1.Crear nivel
                    2.Eliminar nivel
                    3.Ver todos los niveles
                    4.Salir:
                """.trimIndent())
                    val option2 = readLine()!!.toInt()
                    if (option2 > 0 && option2 < 5) {
                        if (option2 == 1) {
                            println("Ingrese el nombre del nivel:")
                            val stageName = readLine()!!.toString()
                            println("Ingrese el identificador:")
                            val stageID = readLine()!!.toInt()
                            println("Ingrese el color del nivel:")
                            val stageColor = readLine()!!.toString()
                            println("Ingrese la ruta del archivo del Nivel:")
                            val stagePath = readLine()!!.toString()
                            val checkStageName = myBuilding.stages.filter { it.name == stageName }
                            val checkStageID = myBuilding.stages.filter { it.id == stageID }
                            val checkStageColor = myBuilding.stages.filter { it.color == stageColor }
                            if (checkStageName.count() > 0 || checkStageID.count() > 0 || checkStageColor.count() > 0) {
                                println("Lo siento, alguno de los datos que ingresaste ya existe...")
                            } else {
                                val stageList = readStage(stagePath)
                                val parkingLotList = stageList.filter { it != " " && it != "*" && it != "" }
                                println(parkingLotList)
                                if (parkingLotList.distinct().count() < parkingLotList.count()) {
                                    println("Asegurate de que cada parqueo tenga un id diferente!")
                                } else {
                                    val newStage = Stage(name = stageName, id = stageID, color = stageColor, path = stagePath)
                                    myBuilding.addStage(newStage)
                                    newStage.addParkingLots(stageList)
                                    println("Nivel creado exitosamente")
                                }
                            }
                        }
                        if (option2 == 2) {
                            val id = readLine()!!.toInt()
                            val deleting = myBuilding.deleteStage(id)
                            if (deleting){
                                println("Nivel borrado con exito...")
                            }else{
                                println("No se ha encontrado el mapa con el ID ingresado...")
                            }
                        }
                        if (option2 == 3) {
                        }
                        if (option2 == 4) {
                            admin = !admin
                        }
                    } else {
                        println("Opcion invalida...Intentelo de nuevo...")
                    }
                } while (admin)
            }
            if(option1 == 2){
                println("kkk")
            }
            if(option1 == 3){
                 wantsToContinue = false
            }


        }else{
            println("Opcion invalida, intente de nuevo...")}

    }while (wantsToContinue)
    }

///Users/Diego/Desktop/mapa.txt