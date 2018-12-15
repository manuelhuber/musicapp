package de.manuelhuber.music.screens.freeTraining

import de.manuelhuber.music.screens.training.TrainingsModel
import de.manuelhuber.music.service.TrainingsService
import de.manuelhuber.music.util.then

class FreeTrainingModel(trainingService: TrainingsService) : TrainingsModel() {

    init {
        trainingService.activeExercises().subscribe { t ->
            exercises = t
            restart()
        }.then(::disposeAtTheEnd)
    }

}