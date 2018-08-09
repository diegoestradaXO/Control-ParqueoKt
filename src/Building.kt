import java.io.File

class Building(
        val stages: ArrayList<Stage> = ArrayList()
){
    //TODO findStage()
    fun deleteStage(stageID: Int): Boolean{
        val selectedStage = stages.filter {it.id == stageID}
        if(selectedStage.count() > 0){
            stages.remove(selectedStage[0])
            return true
        }else{
            return false
        }
    }
    fun addStage(stage: Stage){
        stages.add(stage)
    }
    //TODO toString()
}