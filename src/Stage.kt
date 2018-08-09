import java.io.File

class Stage(
        val name: String,
        val id: Int,
        val color: String,
        val path: String,
        private var parkingLots: ArrayList<ParkingLot> = ArrayList(),
        private var walls: ArrayList<ParkingLot> = ArrayList()

){
    //fun checkParkingLotState(parkingLotID: String): Boolean{
      //  val selectedParkingLot = parkingLots.filter{it.parkingLotID == parkingLotID}
        //return selectedParkingLot[0].isOccupied
    //}
    fun addParkingLots(stageList: ArrayList<String>){
        var parkingLotList = stageList.filter {it != " " && it != "*" && it != ""}
        parkingLotList.forEach {i: String -> parkingLots.add(ParkingLot(parkingLotID = i))}
    }
    fun addPared(){

    }
}